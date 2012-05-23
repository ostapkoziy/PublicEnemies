package com.epam.publicenemies.web.adminpanel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.service.IAdminPanelManagerService;

/**
 * Shows all information about site (users and items)
 * Allows to manage it (add/edit/delete)
 * 
 * @author Ivan Kostyrko
 *
 * Updated 20.05.12: just for testing
 */
@Controller
@RequestMapping(value = "/adminPanel")
public class AdminPanelController {
	private Logger log = Logger.getLogger(AdminPanelController.class);
		
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminPage(HttpServletRequest req) {
		return "redirect:adminPanel/summary.html";	
	}
	
	@RequestMapping(value = "summary", method = RequestMethod.GET)
	public ModelAndView showSummaryPage(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		//List<User> lastRegistered = adminPanelManagerService.get5LastRegisteredUsers(); 
		
		mav.addObject("amountOfUsers", (Integer) adminPanelManagerService.getUsersNumber());
		mav.addObject("lastRegistered", (List<User>)adminPanelManagerService.get5LastRegisteredUsers());
		
		mav.setViewName("/adminPanel/summary"); 
		return mav; 
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/users");
		
		return mav; 
	}
	
	@RequestMapping(value="/weapons", method = RequestMethod.GET)
	public ModelAndView showWeapons(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/weapons");
		
		return mav; 
	}
	
	@RequestMapping(value="/armors", method = RequestMethod.GET)
	public ModelAndView showArmors(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/armors");
		
		return mav; 
	}
	
	@RequestMapping(value="/aids", method = RequestMethod.GET)
	public ModelAndView showAids(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/aids");
		
		return mav; 
	}

}
