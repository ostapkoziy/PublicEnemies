package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserStartPageController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		if (CheckUserInSession.isUserInSession(request) == false)
		{
			return new ModelAndView("index");
		}
		return new ModelAndView("userStartPage");
	}
}
