package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.publicenemies.dto.UserDTO;

public class CheckUserInSession
{
	public static boolean isUserInSession(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		return user != null;
	}
}
