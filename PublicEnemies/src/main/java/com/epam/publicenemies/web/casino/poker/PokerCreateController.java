package com.epam.publicenemies.web.casino.poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.domain.poker.EasyBot;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerCard;
import com.epam.publicenemies.domain.poker.PokerCombination;
import com.epam.publicenemies.domain.poker.PokerGameList;
import com.epam.publicenemies.domain.poker.PokerPlayer;
import com.epam.publicenemies.domain.poker.PokerStats;
import com.epam.publicenemies.service.IPokerStatisticsService;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.utils.Utils;
import com.epam.publicenemies.web.fight.ConnectController;
import com.epam.publicenemies.web.fight.CreateGameController;

/**
 * @author Ostap Koziy
 */
@Controller
public class PokerCreateController {
	private Logger log = Logger.getLogger(PokerCreateController.class);
	
	public static PokerStats pokerStats = new PokerStats();
	public static int playerStartChips = 0;
	
	@Autowired
	@Qualifier("pokerGames")
	private PokerGameList games;

	public void setGames(PokerGameList games) {
		this.games = games;
	}

	@Autowired	
	private IPokerStatisticsService pokerStatisticsService;
	public void setPokerStatisticsService(IPokerStatisticsService pokerStatisticsService)
	{
		this.pokerStatisticsService = pokerStatisticsService;
	}
	
	
	@Autowired	
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	@RequestMapping("/createPokerGame.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile profile = profileManagerService.getProfileByUserId(userId);
		
/*		pokerStatisticsService.updatePlayedGames(userId, 1);
		pokerStatisticsService.updateVPIP(userId, (byte)1);
		pokerStatisticsService.updatePFR(userId, (byte)1);
		pokerStatisticsService.update3BET(userId, (byte)1);
		pokerStatisticsService.updateF3BET(userId, (byte)1);*/

		pokerStats.setPlayedGames(pokerStatisticsService.getTotalGames(userId));
		pokerStats.setVpip(pokerStatisticsService.getVPIP(userId));
		pokerStats.setPfr(pokerStatisticsService.getPFR(userId));
		pokerStats.set3bet(pokerStatisticsService.get3BET(userId));
		pokerStats.setf3bet(pokerStatisticsService.getF3BET(userId));
		

		
		Integer chips = 0;
		try{
			chips = Integer.valueOf(request.getParameter("chips"));
			playerStartChips = chips;
		}catch(NumberFormatException e){
			chips = 1000;
		}
	//	profileManagerService.updateMoney(userId, profile.getMoney() - chips);

		//==================CREATE GAME====================
		games.createNewGame(userId, userProfile);
		RaisePokerController.counter = 0;
		//==================CREATE GAME====================
		
		request.getSession().setAttribute("userProfile", profile);
		log.info("POKER GAME: " + userId + "  CREATED");
		request.getSession().setAttribute("chips", chips);
		request.getSession().setAttribute("botChips", 4000);
		Map<String, Object> objects = new HashMap<String, Object>();

		objects.put("chips", chips);

		return new ModelAndView("pokerGame", objects);
	}
	
	
}
