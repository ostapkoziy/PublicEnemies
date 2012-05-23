package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.poker.EasyBot;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerHand;
import com.epam.publicenemies.web.fight.HitServlet;
import com.google.gson.Gson;

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
		int bet = Integer.valueOf(userBet);
		bet += pokerGame.getPokerGameRound().getPlayer1Bet();
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		
		if(partCounter == 0){
			//preflop
			int botBet = 0;
		}
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		int money = pokerGame.getUser1Profile().getMoney();
		money -= Integer.valueOf(userBet);
		pokerGame.getUser1Profile().setMoney(money);
		log.info(ser.serialize(pokerGame));
		out.print(ser.serialize(pokerGame));
		out.flush();
	}

}
