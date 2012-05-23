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
	@RequestMapping("/PokerServlet")
	public void hit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userBet = new String(request.getParameter("userBet"));
		pokerGame = (PokerGame) request.getSession().getAttribute("pokerGame");
		log.info(pokerGame.getUser1Profile().getNickName() + " BET " + userBet);
		pokerGame.getPokerGameRound().move = !pokerGame.getPokerGameRound().move;
		int bet = Integer.valueOf(userBet);
		bet += pokerGame.getPokerGameRound().getPlayer1Bet();
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if(partCounter == 0){
			pokerGame.setComment("PreFlop");
			
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				int botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			partCounter ++;
			log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
		}
		
		else if (partCounter == 1){
			pokerGame.setComment("Flop");
			List<PokerCard> flop = pokerGame.getPokerGameRound().flop();
			log.info("Poker flop - " + flop);
			pokerGame.getPokerGameRound().getTable().setFlop(flop);
			//bot calls
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				int botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			partCounter ++;
			log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
		}
		
		else if(partCounter == 2){
			pokerGame.setComment("Turn");
			PokerCard turn = pokerGame.getPokerGameRound().turn();
			log.info("Poker turn - " + turn);
			pokerGame.getPokerGameRound().getTable().setTurn(turn);
			//bot calls
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				int botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			partCounter ++;
			log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
		}
		
		else if(partCounter == 3){
			pokerGame.setComment("River");
			PokerCard river = pokerGame.getPokerGameRound().river();
			log.info("Poker river - " + river);
			pokerGame.getPokerGameRound().getTable().setRiver(river);
			//bot calls
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				int botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet); 
			}
			partCounter ++;
			log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
		}
		else if(partCounter == 4){
			pokerGame.setComment("PostRiver");

			//bot calls
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				int botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet); 
			}
			log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
			pokerGame.setComment("Showdown");
			log.info("Showdown");
		}

		
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//+++++++++++++++++++++++++++++++++++++++++++++END OF GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		int money = pokerGame.getUser1Profile().getMoney();
		money -= Integer.valueOf(userBet);
		pokerGame.getUser1Profile().setMoney(money);
		log.info(ser.serialize(pokerGame));
		out.print(ser.serialize(pokerGame));
		out.flush();
	}

}
