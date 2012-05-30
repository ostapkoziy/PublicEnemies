package com.epam.publicenemies.web.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.utils.Utils;

/**
 * Counts open sessions
 * 
 * @author Alexander Ivanov
 */
public class SessionListener implements HttpSessionListener
{
	@Autowired
	private IProfileManagerService profileManagerService;

	public void setProfileManagerService(
			IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}

	@Autowired
	@Qualifier("games")
	private BlackJackGameList games;

	public void setGames(BlackJackGameList games) {
		this.games = games;
	}
	private static Logger	log	= Logger.getLogger(SessionListener.class);
	public void sessionCreated(HttpSessionEvent event)
	{
		log.info("SESSION CREATED: " + event.getSession().getId());
	}
	public void sessionDestroyed(HttpSessionEvent event)
	{
		log.info("SESSION DESTROYED");
		Fight fight = (Fight) event.getSession().getAttribute("game");
		String role = (String) event.getSession().getAttribute("gameRole");
		Utils.isOldGameInSession(fight, role);
//		BlackJack Game Remove
		Integer userId = (Integer) event.getSession().getAttribute("userId");
		Profile profile = profileManagerService.getProfileByUserId(userId);
		BlackJackGame game = games.getGameById(userId);
		profileManagerService.updateMoney(userId,
				profile.getMoney() + game.getChips());
		log.info("BLACKJACK GAME: " + userId + "  DESTROYED");
		games.removeGame(userId);
	}
}