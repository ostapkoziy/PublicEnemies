package com.epam.publicenemies.web.validators;

/**
 * @author Danylo_Batyuk
 */
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service(value = "casinoFormValidator")
public class CasinoFormValidator implements IValidator {
	private Logger				log	= Logger.getLogger(CasinoFormValidator.class);

	@Override
	public void validate(Object obj, Errors errors) {
		log.info("VALIDATING CASINO FORM...");
		
	}

	@Override
	public boolean supports(Class<?> clas) {
		// TODO Auto-generated method stub
		return false;
	}

}
