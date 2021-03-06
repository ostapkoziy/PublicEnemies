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
import com.epam.publicenemies.domain.poker.HardBot;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerGameList;
import com.epam.publicenemies.domain.poker.PokerPlayer;
import com.epam.publicenemies.domain.poker.PokerRound;
import com.epam.publicenemies.service.IPokerStatisticsService;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.web.casino.blackjack.BlackJackEngine;
import com.epam.publicenemies.web.casino.blackjack.DealBlackJackController;
import com.google.gson.Gson;

import flexjson.JSONSerializer;

/**
 * @author Ostap Koziy
 */
@Controller
public class DealPokerController {
	private static Logger log = Logger.getLogger(DealPokerController.class);

	
	@Autowired	
	private IPokerStatisticsService pokerStatisticsService;
	public void setPokerStatisticsService(IPokerStatisticsService pokerStatisticsService)
	{
		this.pokerStatisticsService = pokerStatisticsService;
	}
	
	@Autowired	
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	
	@Autowired
	@Qualifier("pokerGames")
	private PokerGameList games;

	public void setGames(PokerGameList games) {
		this.games = games;
	}

	@RequestMapping("/dealPokerController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PokerCreateController.pokerStats.addPlayedGames();
		log.info("Poker stats - " + PokerCreateController.pokerStats.counters());
		
		
		// Get player bet
		Integer playerBet = Integer.valueOf(request.getParameter("playerBet"));

		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		
		savePokerStats(userId);
		
		Profile profile = (Profile) request.getSession().getAttribute("userProfile");
		
		Integer chips = (Integer) request.getSession().getAttribute("chips");

		//managing money
		profileManagerService.updateMoney(userId, profile.getMoney() + chips - PokerCreateController.playerStartChips);

		
		Integer botChips = (Integer) request.getSession().getAttribute("botChips");
		
		// Set round
		IPokerPlayer player1 = new PokerPlayer(profile.getNickName(), chips);
		
		String bot = (String) request.getSession().getAttribute("bot");
		IPokerPlayer player2;
		PokerRound round;
		if(bot.contains("easy")){
			player2 = new EasyBot("Dirty Sanzhez", botChips);
			player2.setAvatar("img/avatars/poker_easy.png");
			round = new PokerRound(player1, player2, 25, 50);
		}
		else{
			player2 = new HardBot("Sam Farha", botChips);
			player2.setAvatar("img/avatars/poker_hard.png");
			round = new PokerRound(player1, player2, 50, 100);
		}

		log.info("DIRTY SANCHEZ HAS - " + botChips);
		round.setDealer(false);
		round.initGame();
		RaisePokerController.counter = 0;
		
		log.info("PUSH PUSH PUSH PUSH PUSH - " + chips);
		
		// Get game
		PokerGame game = games.getGameById(userId);
		game.setPokerGameRound(round);

		// Round to json
		PrintWriter out = response.getWriter();
		JSONSerializer json = new JSONSerializer();
		log.info("Sending new round - " + json.serialize(game));
		out.print(json.serialize(game));
		out.flush();
	}
	
	public void savePokerStats(int userId) {
		int timesVpip = (PokerCreateController.pokerStats.getVpip() / 100) * PokerCreateController.pokerStats.getPlayedGames();
		int timesPfr = (PokerCreateController.pokerStats.getPfr() / 100) * PokerCreateController.pokerStats.getVpip();
		int times3bet = (PokerCreateController.pokerStats.get3bet() / 100) * PokerCreateController.pokerStats.getVpip();
		int timesf3bet = (PokerCreateController.pokerStats.getf3bet() / 100) * PokerCreateController.pokerStats.getPfr();
		
		timesVpip += PokerCreateController.pokerStats.getVpipCounter();
		timesPfr += PokerCreateController.pokerStats.getPfrCounter();
		times3bet += PokerCreateController.pokerStats.getTribetCounter();
		timesf3bet += PokerCreateController.pokerStats.getF3betCounter();
		
		if(timesPfr == 0){
			timesPfr = 1;
		}
		if(timesVpip == 0){
			timesVpip = 1;
		}
		if(times3bet == 0){
			times3bet = 1;
		}
		if(timesf3bet == 0){
			timesf3bet = 1;
		}
		
		int games = PokerCreateController.pokerStats.getPlayedGames();
		games += PokerCreateController.pokerStats.getPlayedGamesCounter();
		
		PokerCreateController.pokerStats.setPlayedGames(games);
		
		
		try {
			PokerCreateController.pokerStats.setVpip((timesVpip / games) * 100);
			if(PokerCreateController.pokerStats.getVpip() == 0){
				PokerCreateController.pokerStats.setVpip(1);
			}
			
			if((timesPfr / PokerCreateController.pokerStats.getVpip()) * 100 >= 100){
				timesPfr = PokerCreateController.pokerStats.getVpip();
			}
			PokerCreateController.pokerStats.setPfr((timesPfr / PokerCreateController.pokerStats.getVpip()) * 100);
			
			
			if((times3bet / PokerCreateController.pokerStats.getVpip()) * 100 >= 100){
				times3bet = PokerCreateController.pokerStats.get3bet();
			}
			PokerCreateController.pokerStats.set3bet((times3bet / PokerCreateController.pokerStats.getVpip()) * 100);
			
			
			if((timesf3bet / PokerCreateController.pokerStats.getPfr()) * 100 >= 100){
				timesf3bet = PokerCreateController.pokerStats.getPfr();
			}
			PokerCreateController.pokerStats.setf3bet((timesf3bet / PokerCreateController.pokerStats.getPfr()) * 100);
		} catch (ArithmeticException e) {
			pokerStatisticsService.updateVPIP(userId, (byte)25);
			pokerStatisticsService.updatePFR(userId, (byte)15);
			pokerStatisticsService.update3BET(userId, (byte)22);
			pokerStatisticsService.updateF3BET(userId, (byte)50);
		}
		
		pokerStatisticsService.updatePlayedGames(userId, PokerCreateController.pokerStats.getPlayedGames());
		pokerStatisticsService.updateVPIP(userId, PokerCreateController.pokerStats.getVpip());
		pokerStatisticsService.updatePFR(userId, PokerCreateController.pokerStats.getPfr());
		pokerStatisticsService.update3BET(userId, PokerCreateController.pokerStats.get3bet());
		pokerStatisticsService.updateF3BET(userId, PokerCreateController.pokerStats.getf3bet());

		PokerCreateController.pokerStats.setTribetCounter(0);
		PokerCreateController.pokerStats.setVpipCounter(0);
		PokerCreateController.pokerStats.setPfrCounter(0);
		PokerCreateController.pokerStats.setF3betCounter(0);
		PokerCreateController.pokerStats.setPlayedGamesCounter(0);
		
		
	}
}
