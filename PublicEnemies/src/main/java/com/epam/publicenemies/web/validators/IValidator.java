package com.epam.publicenemies.web.validators;

import org.springframework.validation.Errors;

/**
 * @author Alexander Ivanov 22.04.2012 18:44:24
 */
public interface IValidator
{
	public void validate(Object obj, Errors errors);
	public boolean supports(Class<?> clas);
}
