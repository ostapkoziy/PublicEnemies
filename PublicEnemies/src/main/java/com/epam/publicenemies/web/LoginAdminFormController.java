package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * 
 * @author I. Kostyrko
 *
 */
@Controller
@RequestMapping(value = "/superSecretAdminLoginPath")
public class LoginAdminFormController {
	@Autowired
	private IUserManagerService	userManagerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "adminLogin";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String tryLoginAsAdmin(HttpServletRequest request) {
		String aLogin = request.getParameter("adminEmail");
		String aPass = request.getParameter("adminPass");
		User aUser = userManagerService.getAdmin(aLogin, aPass); 
		if ( aUser == null) {
			return "redirect:superSecretAdminLoginPath.html";
		}
		request.getSession().setAttribute("userId", aUser.getUserId());
		request.getSession().setAttribute("admin", 1);
		
		return "redirect:adminPanel.html";
		
	}
}
