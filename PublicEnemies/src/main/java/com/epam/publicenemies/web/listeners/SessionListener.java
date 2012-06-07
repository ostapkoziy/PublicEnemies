package com.epam.publicenemies.web.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.utils.Utils;

/**
 * Counts open sessions
 * 
 * @author Alexander Ivanov
 */
public class SessionListener implements HttpSessionListener
{
	private static Logger	log		= Logger.getLogger(SessionListener.class);
	private static int		counter	= 0;
	public void sessionCreated(HttpSessionEvent event)
	{
		log.info("SESSION CREATED: " + event.getSession().getId());
		synchronized (this)
		{
			counter++;
		}
		log.info("TOTAL SESSIONS: " + getCounter());
	}
	public void sessionDestroyed(HttpSessionEvent event)
	{
		synchronized (this)
		{
			counter--;
		}
		log.info("SESSION DESTROYED");
		log.info("TOTAL SESSIONS: " + getCounter());
		Fight fight = (Fight) event.getSession().getAttribute("game");
		Object oldRole = event.getSession().getAttribute("gameRole");
		Utils.isOldGameInSession(fight, oldRole);
		// BlackJack Game Remove
		// ServletContext servContext = event.getSession().getServletContext();
		// WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servContext);
		//
		// BlackJackGameList games = webAppContext.getBean(BlackJackGameList.class);
		// IProfileManagerService profileManagerService = webAppContext.getBean(ProfileManagerServiceImpl.class);
		// Integer userId = (Integer) event.getSession().getAttribute("userId");
		// Profile profile = profileManagerService.getProfileByUserId(userId);
		// BlackJackGame game = games.getGameById(userId);
		// if (game != null)
		// {
		// profileManagerService.updateMoney(userId, profile.getMoney() + game.getChips());
		// log.info("BLACKJACK GAME: " + userId + "  DESTROYED");
		// games.removeGame(userId);
		// }
	}
	public static int getCounter()
	{
		return counter;
	}
}