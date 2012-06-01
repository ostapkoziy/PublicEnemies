package com.epam.publicenemies.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.impl.ProfileManagerServiceImpl;
import com.epam.publicenemies.utils.Utils;
import com.epam.publicenemies.web.CreateTableController;

/**
 * Counts open sessions
 * 
 * @author Alexander Ivanov
 */

public class SessionListener implements HttpSessionListener {

	private static Logger log = Logger.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent event) {
		log.info("SESSION CREATED: " + event.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent event)
	{
		log.info("SESSION DESTROYED");
		Fight fight = (Fight) event.getSession().getAttribute("game");
		String role = (String) event.getSession().getAttribute("gameRole");
		Utils.isOldGameInSession(fight, role);
		// BlackJack Game Remove
//		ServletContext servContext = event.getSession().getServletContext();
//		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servContext);
//
//		BlackJackGameList games = webAppContext.getBean(BlackJackGameList.class);
//		IProfileManagerService profileManagerService = webAppContext.getBean(ProfileManagerServiceImpl.class);
		
//		Integer userId = (Integer) event.getSession().getAttribute("userId");
//		Profile profile = profileManagerService.getProfileByUserId(userId);
//		BlackJackGame game = games.getGameById(userId);
//		if (game != null)
//		{
//			profileManagerService.updateMoney(userId, profile.getMoney() + game.getChips());
//			log.info("BLACKJACK GAME: " + userId + "  DESTROYED");
//			games.removeGame(userId);
//		}
	}
}