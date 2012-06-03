package com.epam.publicenemies.web.casino.roulette;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.roulette.RouletteGameInfo;
import com.epam.publicenemies.service.IProfileManagerService;

@Controller
@RequestMapping("/rouletteGame.html")
public class RouletteConnectController {
	private Logger log = Logger.getLogger(RouletteConnectController.class);
	final int DEFAULT_CHIPS_AMMOUNT = 1000;

	@Autowired
	private IProfileManagerService profileManagerService;

	private RouletteGameInfo rouletteGameInfo;

	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showRouletteGame() {
		log.debug("In da rouletteGameController, GET method.");
		return "rouletteGame";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();

		rouletteGameInfo = (RouletteGameInfo) session.getAttribute("rouletteGameInfo");
		log.debug("In " + RouletteConnectController.class + " POST processing method");
		if (session.getAttribute("rouletteGameInfo") == null) {
			createGameObjInSession(request);
			return "rouletteGame";
		}
		return "rouletteGame";
	}

	private void createGameObjInSession(HttpServletRequest request) {
		log.info("No " + RouletteGameController.class + " instance, creating new one for session.");
		HttpSession session = request.getSession();

		rouletteGameInfo = new RouletteGameInfo();

		Profile userProfile = profileManagerService.getProfileByUserId((Integer) session.getAttribute("userId"));
		try {
			if (userProfile.getMoney() >= Integer.valueOf(request.getParameter("chips")))
				rouletteGameInfo.setChips(Integer.valueOf(request.getParameter("chips")));
			else
				rouletteGameInfo.setChips(userProfile.getMoney());
		} catch (NumberFormatException e) {
			if (userProfile.getMoney() >= DEFAULT_CHIPS_AMMOUNT)
				rouletteGameInfo.setChips(DEFAULT_CHIPS_AMMOUNT);
			else
				rouletteGameInfo.setChips(userProfile.getMoney());
		} finally {
			userProfile.setMoney(userProfile.getMoney() - rouletteGameInfo.getChips());
			profileManagerService.updateMoney((Integer) session.getAttribute("userId"), userProfile.getMoney());

			rouletteGameInfo.setUserProfile(userProfile);
			session.setAttribute("rouletteGameInfo", rouletteGameInfo);
		}
	}
}
