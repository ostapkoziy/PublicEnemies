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
	static boolean botRaised = false;
	
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
		PrintWriter out = response.getWriter();
		JSONSerializer json = new JSONSerializer();
		int botBet = 0;
		int botChips = (Integer)request.getSession().getAttribute("botChips");
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

			if(botRaised){
				PokerCreateController.pokerStats.addF3betCounter();
				log.info("f3bet counter increased");
			}
			
			game.setPokerGameRound(round);
			log.info("Pot - " + round.getPot());
			round.getPlayer2().setCash(round.getPlayer2().getCash() + round.getPot());
			request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
			request.getSession().setAttribute("chips", round.getPlayer1().getCash());
			log.info("Sending game after raise - " + json.serialize(game));
			out.print(json.serialize(game));
			out.flush();
			return;
		}
		
		
		
		round.setPlayer1Bet(round.getPlayer1Bet() + playerBet);
		round.getPlayer1().setCash(round.getPlayer1().getCash() - playerBet); 	
		log.info(round.getPlayer1().getName() + " BET " + playerBet);
		if((playerBet > 0) && (round.getTable().getFlop().size() == 0)){
			PokerCreateController.pokerStats.addVpipCounter();
			log.info("vpip counter increased");
		}
		if((round.getPlayer1Bet() > round.getPlayer2Bet()) && (botRaised == true)){
			PokerCreateController.pokerStats.addTribetCounter();
			log.info("3bet counter increased");
		}
		log.info("Player1 cash updated to " + round.getPlayer1().getCash());
		botChips = round.getPlayer2().getCash();
		
		
		
		if(round.getPlayer1Bet() > round.getPlayer2Bet()){
			if(round.getTable().getFlop().size() == 0){
				PokerCreateController.pokerStats.addPfrCounter();
				log.info("pfr counter increased");
			}
			log.info("Bot bet before move - " + round.getPlayer2Bet());
			try {
				botBet = round.getPlayer2().makeMove(game);
			} catch (FoldException e) {
				//If Bot Folds
				log.info("Bot folded");
				round.setResult("Bot folded");
				game.setPokerGameRound(round);
				log.info("Pot - " + round.getPot());
				log.info("Player cash before fold - " + round.getPlayer1().getCash());
				round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot());
				log.info("Player cash after fold - " + round.getPlayer1().getCash());
				request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
				request.getSession().setAttribute("chips", round.getPlayer1().getCash());
				log.info("Sending game after bot fold - " + json.serialize(game));
				out.print(json.serialize(game));
				out.flush();
				return;
			}
			if(botBet == 0){
				log.info("Bot folded");
				round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot());
				request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
				request.getSession().setAttribute("chips", round.getPlayer1().getCash());
				round.setResult("Bot folded");
				game.setPokerGameRound(round);
				log.info("Pot - " + round.getPot());
				log.info("Sending game after bot fold - " + json.serialize(game));
				out.print(json.serialize(game));
				out.flush();
				return;
			}
			
			
			log.info("Bot bet after move - " + round.getPlayer2Bet());
			log.info("bot just bet - " + botBet);
			if(botBet > round.getPlayer2().getCash()){
				botBet = round.getPlayer2().getCash();
			}
			round.setPlayer2Bet(round.getPlayer2Bet() + botBet);
			if(round.getPlayer2Bet() > round.getPlayer1Bet()){
				botRaised = true;
			}else{
				botRaised = false;
			}
			log.info("Bot bet after adding - " + round.getPlayer2Bet());
			round.getPlayer2().setCash(round.getPlayer2().getCash() - botBet);
			log.info("Bet 1 - " + round.getPlayer1Bet() + " Bet 2 - " + round.getPlayer2Bet());
		}
		if((round.getPlayer1Bet() == round.getPlayer2Bet()) || (round.getPlayer1().getCash() == 0) || (round.getPlayer2().getCash() == 0)){
			counter++;
			if(counter == 1){
				round.flop();
				if((round.getPlayer1().getCash() == 0) || (round.getPlayer2().getCash() == 0)){
					round.turn();
					round.river();
					counter = 4;
				}
			}else if(counter == 2){
				round.turn();
				if((round.getPlayer1().getCash() == 0) || (round.getPlayer2().getCash() == 0)){
					round.river();
					counter = 4;
				}
			}else if(counter == 3){
				round.river();
				if((round.getPlayer1().getCash() == 0) || (round.getPlayer2().getCash() == 0)){
					counter = 4;
				}
			}
			
			
			if(counter == 4){
				String res = round.displayResults();
				round.setResult(res);
				if(res.contains(round.getPlayer1().getName())){
					log.info("PLAYER 1 won and will recieve - "+round.getPot());
					round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot());	
					request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
					request.getSession().setAttribute("chips", round.getPlayer1().getCash());
				}
				else if(res.contains(round.getPlayer2().getName())){
					log.info("PLAYER 2 won and will recieve - "+round.getPot());
					log.info("Bot cash before win - " + round.getPlayer2().getCash());
					round.getPlayer2().setCash(round.getPlayer2().getCash() + round.getPot());
					log.info("Bot cash after win - " + round.getPlayer2().getCash());
					request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
					request.getSession().setAttribute("chips", round.getPlayer1().getCash());
				}else if (res.contains("Split pot")){
					log.info("NOBODY won and both will recieve - "+round.getPot() / 2);
					round.getPlayer2().setCash(round.getPlayer2().getCash() + round.getPot() / 2);
					round.getPlayer1().setCash(round.getPlayer1().getCash() + round.getPot() / 2);
					request.getSession().setAttribute("botChips", round.getPlayer2().getCash());
					request.getSession().setAttribute("chips", round.getPlayer1().getCash());
				}
				log.info("RESULT - " + round.getResult());
				botChips = round.getPlayer2().getCash();
			}
			round.setPot(round.getPlayer1Bet() + round.getPlayer2Bet());
		}else{
			game.setPokerGameRound(round);
			log.info("Pot - " + round.getPot());
			log.info("Sending game after raise - " + json.serialize(game));
			out.print(json.serialize(game));
			out.flush();
			return;
		}
		
		if(counter != 0){
			// Round to json
			
			game.setPokerGameRound(round);
			log.info("Pot - " + round.getPot());
			log.info("Sending game after raise - " + json.serialize(game));
			out.print(json.serialize(game));
			out.flush();
			//counter = 0;
		}
		
	}
}
