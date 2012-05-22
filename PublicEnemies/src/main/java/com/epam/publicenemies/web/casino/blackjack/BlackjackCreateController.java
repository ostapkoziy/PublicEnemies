package com.epam.publicenemies.web.casino.blackjack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * @author Danylo Batyuk
 */
@Controller
public class BlackjackCreateController {
	private Logger log = Logger.getLogger(BlackjackCreateController.class);
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	
	@Autowired
	@Qualifier("games")
	private BlackJackGameList games;
	public void setGames(BlackJackGameList games){
		this.games = games;
	}
	
	@RequestMapping("/createBlackJackGame.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		log.info("heeeeeeeeelooooooooo");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile userProfile = profileManagerService.getProfileByUserId(userId);
	
		Integer chips = Integer.valueOf(request.getParameter("chips"));
		userProfile.setMoney(userProfile.getMoney() - chips);
		
		log.info(chips);
		
		games.createNewGame(userId, chips);
		
		log.info("BLACKJACK GAME: " + userId + "  CREATED");
		Map<String,Object> objects = new HashMap<String, Object>();
		
		objects.put("chips", chips);
		
		ModelAndView mav = new ModelAndView(new RedirectView("blackJackGame.html"));
		mav.addObject("chips", chips);
		return new ModelAndView("blackJackGame",objects);
	}
}
