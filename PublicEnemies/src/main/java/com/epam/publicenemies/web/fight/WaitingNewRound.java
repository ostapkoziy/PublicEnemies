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

import flexjson.JSONSerializer;

/**
 * @author Alexander Ivanov
 */
@Controller
public class WaitingNewRound
{
	private Logger	log	= Logger.getLogger(WaitingNewRound.class);
	@RequestMapping("/WaitingNewRound")
	public void newRound(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		String role = request.getSession().getAttribute("gameRole").toString();
		Fight fight = (Fight) request.getSession().getAttribute("game");
		Profile userProfile;
		if (role.equals("creator"))
		{
			userProfile = fight.getUser1profile();
			fight.setWhoIAm("user1");
		}
		else
		{
			userProfile = fight.getUser2profile();
			fight.setWhoIAm("user2");
		}
		// log.info(": WAIT FOR OPPONENT HIT");
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		if (fight.isGameEnd())
		{
			// log.info("USER: " + userProfile.getNickName() + " DELETE HIS ATTRIBUTE GAME");
			log.info("--------------GAME IS END FOR USER: " + userProfile.getNickName() + "----------------------");
			out.print(ser.exclude("*.class").serialize(fight));
			out.flush();
			return;
		}
		// log.info(ser.exclude("*.class").serialize(game));
		out.print(ser.exclude("*.class").serialize(fight));
		out.flush();
	}
}
