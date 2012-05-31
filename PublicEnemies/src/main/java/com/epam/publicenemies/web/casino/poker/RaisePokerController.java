package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.poker.EasyBot;
import com.epam.publicenemies.domain.poker.FoldException;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerGameList;
import com.epam.publicenemies.domain.poker.PokerPlayer;
import com.epam.publicenemies.domain.poker.PokerRound;
import com.epam.publicenemies.web.casino.blackjack.BlackJackEngine;
import com.epam.publicenemies.web.casino.blackjack.DealBlackJackController;
import com.google.gson.Gson;

import flexjson.JSONSerializer;


@Controller
public class RaisePokerController {
	private static Logger log = Logger.getLogger(RaisePokerController.class);
	
	static int counter = 0;
	static int botChips = 5000;
	
	@Autowired
	@Qualifier("pokerGames")
	private PokerGameList games;

	public void setGames(PokerGameList games) {
		this.games = games;
	}

	@Autowired
	@Qualifier("deck")
	private BlackJackDeck deck;

	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}

	@Autowired
	@Qualifier("engine")
	private BlackJackEngine engine;

	public void setEnhine(BlackJackEngine engine) {
		this.engine = engine;
	}
	
	@RequestMapping("/raisePokerController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int botBet = 0;
		// Get player bet
		Integer playerBet = Integer.valueOf(request.getParameter("playerBet"));
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile profile = (Profile) request.getSession().getAttribute("userProfile");
		
		PokerGame game = games.getGameById(userId);
		PokerRound round = game.getPokerGameRound();
		
		
		// If Player Folds
		if(playerBet < 0){
			round.setResult("Player folded");
			PrintWriter out = response.getWriter();
			JSONSerializer json = new JSONSerializer();
			game.setPokerGameRound(round);
			log.info("Pot - " + round.getPot());
			log.info("Sending game after raise - " + json.serialize(game));
			out.print(json.serialize(game));
			out.flush();
			return;
		}
		
		
		
		round.setPlayer1Bet(round.getPlayer1Bet() + playerBet);
		round.getPlayer1().setCash(round.getPlayer1().getCash() - playerBet); 
		log.info("Player1 cash updated to " + round.getPlayer1().getCash());
		log.info(round.getPlayer1().getName() + " BET " + playerBet);
		botChips = round.getPlayer2().getCash();
		
		
		
		if(round.getPlayer1Bet() > round.getPlayer2Bet()){
			try {
				botBet = round.getPlayer2().makeMove(game);
			} catch (FoldException e) {
				//If Bot Folds
				log.info("Bot folded");
				round.setResult("Bot folded");
			}
			round.setPlayer2Bet(round.getPlayer2Bet() + botBet);
			log.info("Bot bet " + botBet);
			round.getPlayer2().setCash(round.getPlayer2().getCash() - botBet);
			log.info("Bot cash updated to " + round.getPlayer2().getCash());
		}
		if(round.getPlayer1Bet() == round.getPlayer2Bet()){
			counter++;
			if(counter == 1){
				round.flop();
			}else if(counter == 2){
				round.turn();
			}else if(counter == 3){
				round.river();
			}else if(counter == 4){
				String res = round.displayResults();
				round.setResult(res);
				if(res.contains(round.getPlayer1().getName())){
					log.info("PLAYER 1 won and will recieve - "+round.getPot());
					round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot());			
				}
				else if(res.contains(round.getPlayer2().getName())){
					log.info("PLAYER 2 won and will recieve - "+round.getPot());
					round.getPlayer2().setCash(round.getPlayer2().getCash() + round.getPot());
				}else if (res.contains("Split pot")){
					log.info("NOBODY won and both will recieve - "+round.getPot() / 2);
					round.getPlayer2().setCash(round.getPlayer2().getCash() + round.getPot() / 2);
					round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot() / 2);
				}
				log.info("RESULT - " + round.getResult());
				botChips = round.getPlayer2().getCash();
			}
			round.setPot(round.getPot() + playerBet + botBet);
		}
		
		if(counter != 0){
			// Round to json
			PrintWriter out = response.getWriter();
			JSONSerializer json = new JSONSerializer();
			game.setPokerGameRound(round);
			log.info("Pot - " + round.getPot());
			log.info("Sending game after raise - " + json.serialize(game));
			out.print(json.serialize(game));
			out.flush();
			//counter = 0;
		}
		
	}
}
