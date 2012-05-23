package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;
import com.epam.publicenemies.web.validators.IValidator;

/**
 * @author Alexander Ivanov 22.04.2012 18:41:20
 */
@Controller
@RequestMapping(value = "/userLogin")
public class LoginUserFormController
{
	private Logger				log	= Logger.getLogger(LoginUserFormController.class);
	@Autowired
	private IUserManagerService	userManagerService;
	@Autowired
	@Qualifier("loginUserFormValidator")
	private IValidator			validator;
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		log.info("SHOW LOGIN FORM");
		model.put("userDto", new UserDto());
		return "userLogin";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute UserDto user, HttpServletRequest request, BindingResult result)
	{
		log.info("PROCESS FORM");
		validator.validate(user, result);
		if (result.hasErrors())
		{
			log.info("VALIDATING FALSE.....");
			return "userLogin";
		}
		// need to refactor. use getUserIdByEmail... (not implemented yet)
		UserDto user2 = userManagerService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		log.info("USER = " + user2.getEmail() + " SUCCESSFULLY LOGGED");
		// store user id into session
		request.getSession().setAttribute("userId", user2.getUserId());
		// old way
		request.getSession().setAttribute("user", user2);
		return "redirect:userStartPage.html";
	}
}
