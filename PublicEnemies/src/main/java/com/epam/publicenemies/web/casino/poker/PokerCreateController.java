package com.epam.publicenemies.web.casino.poker;

import java.util.ArrayList;
import java.util.List;
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
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.domain.poker.EasyBot;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerCard;
import com.epam.publicenemies.domain.poker.PokerCombination;
import com.epam.publicenemies.domain.poker.PokerPlayer;
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
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	@RequestMapping("/createPokerGame.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		PokerGame pokerGame = new PokerGame();
		pokerGame.setId(new Random().nextInt());
		
		log.info("POKER GAME: " + pokerGame.getId() + "  CREATED");
		
		pokerGame.setUser1Profile(userProfile);

		IPokerPlayer player1 = new PokerPlayer(pokerGame.getUser1Profile().getNickName(), pokerGame.getUser1Profile().getMoney());
		IPokerPlayer player2 = new EasyBot("Dirty Sanzhez", 3000);
		pokerGame.setPokerGameRound(new PokerRound(player1, player2, 25, 50));
		pokerGame.getPokerGameRound().initGame();
		PokerServlet.partCounter = 0;
		/*
		 * SESSION_SETUP
		 */
		request.getSession().setAttribute("pokerGame", pokerGame);
		ModelAndView mav = new ModelAndView(new RedirectView("pokerGame.html"));
		String chips = request.getParameter("chips");
		mav.addObject("chips", chips);
		return mav;
	}
	
}
