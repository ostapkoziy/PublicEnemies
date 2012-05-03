package com.epam.publicenemies.web;

/**
 * @author Nikolay Krivenchuk 22.04.2012 23:18:20
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;
import com.epam.publicenemies.web.validators.IValidator;

@Controller
@RequestMapping(value = "/userRegistration")
public class RegisterUserFormController
{
	private Logger	log	= Logger.getLogger(RegisterUserFormController.class);
	@Autowired
	@Qualifier("userManagerService")
	private IUserManagerService	userManagerService;
	@Autowired
	@Qualifier("registerUserFormValidator")
	private IValidator validator;
	
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView onGetRequest(){
		log.debug("Showing registration form.");
		return new ModelAndView("userRegistration", "userDto", new UserDto());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected ModelAndView onSubmit(UserDto userToRegister, HttpServletRequest request, BindingResult result)
			throws Exception
	{
		validator.validate(userToRegister, result);
		if (result.hasErrors()){
			log.debug("Validation of REGISTRATION FORM FAILED.");
			return new ModelAndView("userRegistration");
		}
		log.info("Registration form validation successful");
		
		// register new user based on passed parameters: email, pass, nickName
		// nickName passed as email. need to fix this (? create 3-d field in register form?)
		// could be refactored. pass just 3 or 2 parameters. not whole object
		log.info("Try to register new user with attributs: email - " + 
				((UserDto) userToRegister).getEmail() + " and pass - " +
				((UserDto) userToRegister).getPassword() );
		
		UserDto user = userManagerService.registerNewUser(
				((UserDto) userToRegister).getEmail(), 
				((UserDto) userToRegister).getPassword(), 
				((UserDto) userToRegister).getEmail()
				);
		// store user id into session
		request.getSession().setAttribute("userId", user.getUserId());
		// old way
		request.getSession().setAttribute("user", user);
		log.info("NEW USER REGISTERED: EMAIL:" + user.getEmail() + 
				" PASS: "+ user.getPassword() + 
				" NICKNAME: " + user.getNickName() + 
				" MONEY: " + user.getMoney() + 
				" AVATAR_PATH: " + user.getAvatar()
				);
		return new ModelAndView(new RedirectView("editProfile.html"));
	}
}
