package com.epam.publicenemies.web.fight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.fight.Game;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
@Controller
public class WaitForOpponentConnect
{
	private Logger	log	= Logger.getLogger(WaitForOpponentConnect.class);
	@RequestMapping("/WaitForOpponent")
	public void waitForOpponent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * Гра точно існує бо вже створена User1
		 */
		long gameId = ((Game) request.getSession().getAttribute("game")).getId();
		Game game = Utils.findGameById(gameId);
		// log.info(game.getUser1profile().getNickName() + " WAIT WHEN OPPONENT CONNECT TO GAME: " + gameId);
		PrintWriter out = response.getWriter();
		out.print(game.isGameStarted());
		out.flush();
	}
}
