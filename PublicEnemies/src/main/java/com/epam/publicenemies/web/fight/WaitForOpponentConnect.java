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
		 */
		Fight fight = ((Fight) request.getSession().getAttribute("game"));
		PrintWriter out = response.getWriter();
		out.print(fight.isGameStarted());
		out.flush();
	}
}
