package com.epam.publicenemies.web.casino.roulette;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.roulette.RouletteGameInfo;
import com.epam.publicenemies.service.IProfileManagerService;

@Controller
@RequestMapping("/rouletteRedirectController.html")
public class RouletteRedirectController {
	
	@Autowired	
	private IProfileManagerService	profileManagerService;
	
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String setMoneyAndRedirect(HttpServletRequest request){
		HttpSession session = request.getSession();
		RouletteGameInfo rouletteGameInfo = (RouletteGameInfo) session.getAttribute("rouletteGameInfo");
		profileManagerService.updateMoney((Integer) session.getAttribute("userId"), rouletteGameInfo.getUserMoney() + rouletteGameInfo.getChips());
		
		session.removeAttribute("rouletteGameInfo");
		
		return "redirect:userStartPage.html";
	}
}
