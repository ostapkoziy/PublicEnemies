package com.epam.publicenemies.web.listeners;

/**
 * @author Danylo_Batyuk
 */
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.publicenemies.web.CreateTableController;

public class OnContextLoaderListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		// could NOT be commented after database were created
		// ne minjaty bljad'!!!!
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
		CreateTableController bean = context
				.getBean(CreateTableController.class);
		bean.createAllTables();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

}
