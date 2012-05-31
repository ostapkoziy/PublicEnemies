package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.service.IProfileManagerService;

/**
 * @author Alexander Ivanov
 */
@Controller
public class StatsUpdateController
{
	private Logger					log	= Logger.getLogger(StatsUpdateController.class);
	@Autowired
	private IProfileManagerService	profileManagerService;
	@RequestMapping("/statsUpdate.html")
	public void statsUpdate(HttpServletRequest request, HttpServletResponse response)
	{
		String strenght = request.getParameter("strength");
		String agility = request.getParameter("agility");
		String inteligance = request.getParameter("inteligance");
		log.info("StatsUpdateController: " + strenght + " !!!!" + agility + " !!!!" + inteligance);
	}
}
