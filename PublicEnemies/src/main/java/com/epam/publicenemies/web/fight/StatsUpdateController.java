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
		int id = new Integer(request.getSession().getAttribute("userId").toString());
		int strength = new Integer(request.getParameter("strength").toString());
		int agility = new Integer(request.getParameter("agility").toString());
		int inteligance = new Integer(request.getParameter("inteligance").toString());
		log.info("StatsUpdateController: " + strength + " " + agility + " " + inteligance);
		profileManagerService.updateStats(id, strength, agility, inteligance);
	}
}
