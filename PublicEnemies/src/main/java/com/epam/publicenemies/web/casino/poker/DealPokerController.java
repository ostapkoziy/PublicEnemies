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
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerGameList;
import com.epam.publicenemies.domain.poker.PokerPlayer;
import com.epam.publicenemies.domain.poker.PokerRound;
import com.epam.publicenemies.web.casino.blackjack.BlackJackEngine;
import com.epam.publicenemies.web.casino.blackjack.DealBlackJackController;
import com.google.gson.Gson;

import flexjson.JSONSerializer;


@Controller
public class DealPokerController {
	private static Logger log = Logger.getLogger(DealPokerController.class);

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
		
		// Get player bet
		Integer playerBet = Integer.valueOf(request.getParameter("playerBet"));

		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		
		Profile profile = (Profile) request.getSession().getAttribute("userProfile");
		
		// Set round
		IPokerPlayer player1 = new PokerPlayer(profile.getNickName(), profile.getMoney());
		IPokerPlayer player2 = new EasyBot("Dirty Sanzhez", RaisePokerController.botChips);
		PokerRound round = new PokerRound(player1, player2, 25, 50);
		log.info("DIRTY SANCHEZ HAS - " + RaisePokerController.botChips);
		round.setDealer(false);
		round.initGame();
		RaisePokerController.counter = 0;
		
		Integer chips = 0;
		log.info("PUSH PUSH" + chips);
		
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
}
