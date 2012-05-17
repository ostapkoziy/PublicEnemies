package com.epam.publicenemies.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.publicenemies.domain.fight.Fight;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	public ViewServlet()
	{
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Fight game = (Fight) request.getSession().getAttribute("game");
		if (game == null)
		{
			return;
		}
		long gameId = game.getId();
		PrintWriter out = response.getWriter();
		/*
		 * 
		 */
		MessageList ml = MessageList.newInstanse();
		HashMap<Long, LinkedList<String>> allMessages = ml.getGameMessages();
		LinkedList<String> msListInGame = allMessages.get(gameId);
		/*
		 * MESSAGE
		 */
		if (msListInGame == null)
		{
			out.write("");
			out.flush();
		}
		else
		{
			StringBuilder resault = new StringBuilder();
			int k = 30;
			if (msListInGame.size() < k) k = msListInGame.size();
			while (k > 0)
			{
				k--;
				resault.append(msListInGame.get(k) + "<br/>");
			}
			out.write(resault.toString());
			out.flush();
		}
	}
}
