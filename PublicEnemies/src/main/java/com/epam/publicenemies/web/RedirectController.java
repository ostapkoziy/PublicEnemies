package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.utils.Utils;

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
		Utils.isOldGameInSession((Fight) session.getAttribute("game"), session.getAttribute("gameRole"));
		session.removeAttribute("user");
		session.removeAttribute("admin");
		session.removeAttribute("game");
		session.removeAttribute("gameRole");
		session.removeAttribute("win");
		session.invalidate();
		return "index";
	}
}
