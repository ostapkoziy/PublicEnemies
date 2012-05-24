package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.poker.PokerCard;
import com.epam.publicenemies.domain.poker.PokerCombination;
import com.epam.publicenemies.web.fight.HitServlet;

import flexjson.JSONSerializer;

/**
 * @author Ostap Koziy
 */
@Controller
public class PokerServlet {
	private Logger log = Logger.getLogger(HitServlet.class);
	private PokerGame pokerGame;
	static int partCounter = -1;
	private PokerCombination player1Combination, player2Combination;
	@RequestMapping("/PokerServlet")
	public void hit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean playerFolded = false;
		response.setContentType("text/html;charset=UTF-8");
		String userBet = new String(request.getParameter("userBet"));
		Integer chips = (Integer)request.getSession().getAttribute("chips");
		pokerGame = (PokerGame) request.getSession().getAttribute("pokerGame");
		log.info(pokerGame.getUser1Profile().getNickName() + " BET " + userBet);
		pokerGame.getPokerGameRound().move = !pokerGame.getPokerGameRound().move;
		int bet = 0;
		bet = Integer.valueOf(userBet);
		if(bet == -1){
			partCounter = 0;
		}
		bet += pokerGame.getPokerGameRound().getPlayer1Bet();
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		pokerGame.getUser1Profile().setMoney(chips);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		
		
		
		if(partCounter == 0){
			pokerGame.setComment("PreFlop");
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				
				try {
					botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
				} catch (FoldException e) {
					partCounter = -1;
					playerFolded = true;
					log.info("Bot folded");
					pokerGame.getPokerGameRound().setResult("Bot folded");
				}
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			log.info("BETS - " + pokerGame.getPokerGameRound().getPlayer1Bet() + " and " + pokerGame.getPokerGameRound().getPlayer2Bet());
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				log.info("Pre flop over");
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				partCounter ++;
				List<PokerCard> flop = pokerGame.getPokerGameRound().flop();
				log.info("Poker flop - " + flop);
			}
			log.info("Bot bet - " + botBet +" to make his bet a total of " + pokerGame.getPokerGameRound().getPlayer2Bet());
			sendData(request, response, bet);
		}
		
		else if (partCounter == 1){
			pokerGame.setComment("Flop");
			log.info("FLOP USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				try {
					botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
				} catch (FoldException e) {
					partCounter = -1;
					playerFolded = true;
					log.info("Bot folded");
					pokerGame.getPokerGameRound().setResult("Bot folded");
				}
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				partCounter ++;
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				PokerCard turn = pokerGame.getPokerGameRound().turn();
				log.info("Poker turn - " + turn);
				log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
			}
			sendData(request, response, bet);
		}
		
		else if(partCounter == 2){
			pokerGame.setComment("Turn");
			log.info("TURN USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				
				try {
					botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
				} catch (FoldException e) {
					partCounter = -1;
					playerFolded = true;
					log.info("Bot folded");
					pokerGame.getPokerGameRound().setResult("Bot folded");
				}
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				partCounter ++;
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				PokerCard river = pokerGame.getPokerGameRound().river();
				log.info("Poker river - " + river);
				
				log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
			}
			sendData(request, response, bet);
		}
		
		else if(partCounter == 3){
			pokerGame.setComment("River");
			log.info("RIVER USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				
				try {
					botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
				} catch (FoldException e) {
					partCounter = -1;
					playerFolded = true;
					log.info("Bot folded");
					pokerGame.getPokerGameRound().setResult("Bot folded");
				}
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
				log.info("Poker Showdown");
				pokerGame.setComment("Showdown");
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				pokerGame.getPokerGameRound().displayResults();
				log.info("RESULT - " + pokerGame.getPokerGameRound().getResult());
				sendData(request, response, bet);
				return;
			}
			sendData(request, response, bet);
		}

		if(playerFolded){
			pokerGame.getPokerGameRound().setResult("Player Folded");
			log.info(ser.serialize(pokerGame));
			out.print(ser.serialize(pokerGame));
			out.flush();
			return;
		}
		
		if (userBet.contains("-1")){
			log.info("Player folded");
			partCounter = -1;
			playerFolded = true;
			sendData(request, response, bet);
		}
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//+++++++++++++++++++++++++++++++++++++++++++++END OF GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	}
	
	private void sendData(HttpServletRequest request, HttpServletResponse response, int bet)
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		int money = pokerGame.getUser1Profile().getMoney();
		money -= bet;
		pokerGame.getUser1Profile().setMoney(money);
		log.info(ser.serialize(pokerGame));
		out.print(ser.serialize(pokerGame));
		out.flush();
	}

}
