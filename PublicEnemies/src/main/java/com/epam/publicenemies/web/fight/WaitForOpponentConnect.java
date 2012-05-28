package com.epam.publicenemies.web.fight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.fight.Fight;
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
		log.info("WAIT FOR OPPONENT CONNECT");
		request.getSession().setAttribute("WFOC", true);
		long gameId = ((Fight) request.getSession().getAttribute("game")).getId();
		Fight fight = Utils.findGameById(gameId);
		/*
		 * Wait for opponent connect on Servel
		 */
		// waitOnServer(fight);
		/*
		 * 
		 */
		request.getSession().removeAttribute("WFOC");
		PrintWriter out = response.getWriter();
		out.print(fight.isGameStarted());
		out.flush();
	}
	private void waitOnServer(Fight fight)
	{
		log.info("SLEEP START");
		while (!fight.isGameStarted())
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		log.info("SLEEP END");
	}
}
