package com.epam.publicenemies.web.casino.blackjack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DealBlackJackController {
	private static Logger	log	= Logger.getLogger(DealBlackJackController.class);
	
	@RequestMapping("/DealBlackJackController")
	public void deal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		String userBet = new String(request.getParameter("userBet"));
	}
}
