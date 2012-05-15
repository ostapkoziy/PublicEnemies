package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
@Controller
public class RedirectController
{
	@RequestMapping("/index.html")
	public String showIndex()
	{
		return "index";
	}
	@RequestMapping("/logout.html")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "index";
	}
	@RequestMapping("/newJoinGame.html")
	public String newJoinGame(HttpServletRequest request)
	{
		return "newJoinGame";
	}
}
