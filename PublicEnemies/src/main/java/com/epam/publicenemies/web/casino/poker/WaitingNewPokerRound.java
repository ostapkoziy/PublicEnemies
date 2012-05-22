package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.poker.EasyBot;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerHand;
import com.epam.publicenemies.domain.poker.PokerPlayer;

import flexjson.JSONSerializer;


/**
 * @author Ostap Koziy
 */
@Controller
public class WaitingNewPokerRound {
	private Logger	log	= Logger.getLogger(WaitingNewPokerRound.class);
	private JSONSerializer ser = new JSONSerializer();
	
	@RequestMapping("/WaitingNewPokerRound")
	public void newPokerRound(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PokerGame pokerGame = (PokerGame)request.getSession().getAttribute("pokerGame");
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		//log.info("GAME SERIALIZED - " + ser.exclude("*.class").serialize(pokerGame));
		out.print(ser.exclude("*.class").serialize(pokerGame));
		out.flush();
	}
}
