package com.epam.publicenemies.web.validators;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * @author Alexander Ivanov 22.04.2012 18:44:24
 */
public class LoginUserFormValidator implements IValidator
{
	private Logger				log	= Logger.getLogger(LoginUserFormValidator.class);
	private IUserManagerService	userManagerService;
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	public void validate(Object obj, Errors errors)
	{
		log.info("VALIDATING LOGIN FORM....");
		if (!supports(obj.getClass()))
		{
			return;
		}
		UserDto user = (UserDto) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
		if (errors.hasErrors()) return;
		UserDto uDTO = userManagerService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if (uDTO == null)
		{
			log.error("USER WITH EMAIL: " + user.getEmail() + " AND PASSWORD: " + user.getPassword() + " NOT FOUND");
			errors.rejectValue("password", "user.not-found");
		}
	}
	@Override
	public boolean supports(Class<?> clas)
	{
		return clas.equals(UserDto.class);
	}
}
