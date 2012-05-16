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

import com.epam.publicenemies.domain.fight.Game;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	// TODO Servlet into Controller
	public MessageServlet()
	{
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String mess = request.getParameter("mess").replace('\'', '`');
		Game game = ((Game) request.getSession().getAttribute("game"));
		String role = request.getSession().getAttribute("gameRole").toString();
		long gameId = game.getId();
		String autor;
		if (role.equals("creator"))
		{
			autor = game.getUser1profile().getNickName();
		}
		else
		{
			autor = game.getUser2profile().getNickName();
		}
		PrintWriter pw = response.getWriter();
		/*
		 * 
		 */
		MessageList ml = MessageList.newInstanse();
		HashMap<Long, LinkedList<String>> allMessages = ml.getGameMessages();
		/*
		 * MESSEGES IN GAME
		 */
		LinkedList<String> msListInGame = allMessages.get(gameId);
		if (msListInGame == null)
		{
			msListInGame = new LinkedList<String>();
			msListInGame.addFirst("<b>" + autor + ":</b> " + mess);
			ml.getGameMessages().put(gameId, msListInGame);
		}
		else
		{
			msListInGame.addFirst("<b>" + autor + ":</b> " + mess);
		}
		/*
		 * RESAULT
		 */
		StringBuilder resault = new StringBuilder();
		int k = 30;
		if (msListInGame.size() < k) k = msListInGame.size();
		while (k > 0)
		{
			k--;
			resault.append(msListInGame.get(k) + "<br/>");
		}
		pw.write(resault.toString());
		pw.flush();
	}
}
