package com.epam.publicenemies.web.validators;

/**
 * @author Danylo_Batyuk
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.service.IProfileManagerService;
import com.google.gson.Gson;

@Controller
public class CasinoFormValidator {
	private Logger log = Logger.getLogger(CasinoFormValidator.class);

	@Autowired
	private IProfileManagerService profileManagerService;

	public void setProfileManagerService(
			IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}

	@RequestMapping("/validateCasino")
	public void validate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		log.info("VALIDATING CASINO FORM...");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile profile = profileManagerService.getProfileByUserId(userId);

		String error = null;
		Integer chips = 0;
		try{
			chips = Integer.valueOf(request.getParameter("playerChips"));
		}catch (NumberFormatException e){
			error = "Invalid number format!";
		}	
		if (profile.getMoney() < chips) {
			error = "You don`t have enough money!";
		}
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(error));
		out.flush();

	}
}
