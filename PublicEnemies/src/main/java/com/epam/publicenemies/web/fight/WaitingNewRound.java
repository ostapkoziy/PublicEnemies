package com.epam.publicenemies.web.fight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightEngine;

import flexjson.JSONSerializer;

/**
 * @author Alexander Ivanov
 */
@Controller
public class WaitingNewRound
{
	private Logger	log	= Logger.getLogger(WaitingNewRound.class);
	@RequestMapping("/WaitingNewRound")
	public void newRound(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException, ServletException
	{
		response.setContentType("text/html;charset=UTF-8");
		String role = request.getSession().getAttribute("gameRole").toString();
		Fight fight = (Fight) request.getSession().getAttribute("game");
		/*
		 * 
		 */
		startEngine(fight, role);
		Profile userProfile = fight.getProfile(role);
		fight.setWhoIAm(role);
		/*
		 */
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		if (fight.isGameEnd())
		{
			log.info("--------------GAME IS END FOR USER: " + userProfile.getNickName() + "----------------------");
			out.print(ser.exclude("*.class").serialize(fight));
			out.flush();
		}
		else
		{
			out.print(ser.exclude("*.class").serialize(fight));
			out.flush();
		}
	}
	private synchronized void startEngine(Fight fight, String role)
	{
		if ((System.currentTimeMillis() / 1000) > (fight.getRound().getRoundBeginTime() + 30) && !fight.isGameEnd())
		{
			log.info(role + ": INSIDE IN START ENGINE IF OPPONENT NOT HIT");
			FightEngine engine = fight.getEngine();
			engine.startEngine(fight);
		}
	}
}
