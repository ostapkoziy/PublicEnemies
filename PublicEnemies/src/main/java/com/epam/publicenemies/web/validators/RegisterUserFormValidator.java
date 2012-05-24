package com.epam.publicenemies.web.validators;

/**
 * @author Nikolay Krivenchuk 22.04.2012 23:18:20
 */
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

@Service(value = "registerUserFormValidator")
public class RegisterUserFormValidator implements IValidator
{
	private Logger				log	= Logger.getLogger(RegisterUserFormValidator.class);
	@Autowired
	private IUserManagerService	userManagerService;
	public boolean supports(Class<?> clazz)
	{
		return clazz.equals(UserDto.class);
	}
	public void validate(Object obj, Errors errors)
	{
		log.info("Validating REGISTER FORM...");
		if (!supports(obj.getClass()))
		{
			return;
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
		UserDto user = (UserDto) obj;
		UserDto userDTO = userManagerService.findUserByEmail(user.getEmail());
		if (userDTO != null)
		{
			log.error("USER WITH EMAIL: " + user.getEmail() + " ALREADY EXISTS");
			errors.rejectValue("email", "user.exist");
		}
	}
}
