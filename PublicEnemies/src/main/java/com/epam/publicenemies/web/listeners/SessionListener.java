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
	}
}