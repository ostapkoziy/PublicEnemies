package com.epam.publicenemies.web.fight;

import java.io.IOException;
import java.io.PrintWriter;

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
	public void newRound(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException
	{
		response.setContentType("text/html;charset=UTF-8");
		String role = request.getSession().getAttribute("gameRole").toString();
		Fight fight = (Fight) request.getSession().getAttribute("game");
		/*
		 * 
		 */
		Profile userProfile = fight.getProfile(role);
		fight.setWhoIAm(role);
		/*
		 * 
		 */
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		startEngineIfOpponentNotHit(fight, role);
		if (fight.isGameEnd())
		{
			log.info("--------------GAME IS END FOR USER: " + userProfile.getNickName() + "----------------------");
			out.print(ser.exclude("*.class").serialize(fight));
			out.flush();
			return;
		}
		out.print(ser.exclude("*.class").serialize(fight));
		out.flush();
	}
	/**
	 * Запускати Engine якщо хоча б один online(тобто не закрив вкладку чи браузер)
	 * 
	 */
	private synchronized void startEngineIfOpponentNotHit(Fight fight, String role)
	{
		if ((System.currentTimeMillis() / 1000) > (fight.getRound().getRoundBeginTime() + 30) && !fight.isGameEnd())
		{
			FightEngine engine = fight.getEngine();
			engine.startEngine(fight);
			engine.setStarted(true);
		}
	}
}
