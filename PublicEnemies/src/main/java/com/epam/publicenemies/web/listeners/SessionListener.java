package com.epam.publicenemies.web.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Counts open sessions
 * 
 * @author Alexander Ivanov
 */
public class SessionListener implements HttpSessionListener
{
	private static Logger	log				= Logger.getLogger(SessionListener.class);
	private int				sessionCount	= 0;
	public void sessionCreated(HttpSessionEvent event)
	{
		log.info("Session Created: " + event.getSession().getId());
		log.info("Total Sessions: " + sessionCount);
		synchronized (this)
		{
			sessionCount++;
		}
	}
	public void sessionDestroyed(HttpSessionEvent event)
	{
		log.info("Session Destroyed");
		log.info("Total Sessions: " + sessionCount);
		synchronized (this)
		{
			sessionCount--;
		}
	}
}