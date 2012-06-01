package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import flexjson.JSONSerializer;


/*
 * @author Ostap Koziy
 */
@Controller
public class selectPlayerPokerController {
	private Logger log = Logger.getLogger(selectPlayerPokerController.class);
	
	@RequestMapping("/selectPlayerPokerController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bot = request.getParameter("playerAvatar");
		
		if(bot.contains("hard")){
			request.getSession().setAttribute("bot", "hard");
		}else if(bot.contains("easy")){
			request.getSession().setAttribute("bot", "easy");
		}


		// Round to json
		PrintWriter out = response.getWriter();
		JSONSerializer json = new JSONSerializer();
		out.print(json.serialize(bot));
		out.flush();
	}

}
