package com.epam.publicenemies.web.listeners;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.publicenemies.web.CreateTableController;

public class OnContextLoaderListener extends ContextLoaderListener  {	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		// could be commented after database were created
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		CreateTableController bean = context.getBean(CreateTableController.class);
		bean.createAllTables();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}


}
