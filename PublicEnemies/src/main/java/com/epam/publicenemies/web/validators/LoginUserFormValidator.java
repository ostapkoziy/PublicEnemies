package com.epam.publicenemies.web.validators;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * @author Alexander Ivanov 22.04.2012 18:43:23
 */
@Service(value = "loginUserFormValidator")
public class LoginUserFormValidator implements IValidator
{
	private Logger				log	= Logger.getLogger(LoginUserFormValidator.class);
	@Autowired
	private IUserManagerService	userManagerService;
	@Override
	public void validate(Object obj, Errors errors)
	{
		log.info("VALIDATING LOGIN FORM....");
		if (!supports(obj.getClass()))
		{
			return;
		}
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
		if (errors.hasErrors()) return;
		User uDomain = userManagerService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		log.info("**********DOMAIN: " + uDomain);
		if (uDomain == null)
		{
			log.error("USER WITH EMAIL: " + user.getEmail() + " AND PASSWORD: " + user.getPassword() + " NOT FOUND");
			errors.rejectValue("password", "user.not-found");
		}
	}
	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz.equals(User.class);
	}
}
