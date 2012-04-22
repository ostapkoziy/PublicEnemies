package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * @author Alexander Ivanov
 * @since 21.04.2012
 */
@Controller
@RequestMapping(value = "/userLogin")
public class LoginUserFormController
{
	private Logger				log	= Logger.getLogger(LoginUserFormController.class);
	@Autowired
	@Qualifier("userManagerService")
	private IUserManagerService	userManagerService;
	@Autowired
	@Qualifier("loginUserFormValidator")
	private Validator			validator;
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	public void setValidator(Validator validator)
	{
		this.validator = validator;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		log.info("SHOW LOGIN FORM");
		model.put("user", new User());
		return "userLogin";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute User user, HttpServletRequest request, BindingResult result, ModelMap model)
	{
		validator.validate(user, result);
		if (result.hasErrors())
		{
			log.info("VALIDATING FALSE.....");
			return "userLogin";
		}
		log.info("PROCESS FORM");
		UserDto user2 = userManagerService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		log.info("USER = " + user2.getEmail() + " SUCCESSFULLY LOGGED");
		request.getSession().setAttribute("user", user2);
		return "redirect:userStartPage.html";
	}
}
