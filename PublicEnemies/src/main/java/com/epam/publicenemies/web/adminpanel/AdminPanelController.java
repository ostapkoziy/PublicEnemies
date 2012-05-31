package com.epam.publicenemies.web.adminpanel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.service.IAdminPanelManagerService;

/**
 * Shows all information about site (users and items)
 * Allows to manage it (add/edit/delete)
 * 
 * @author Ivan Kostyrko
 *
 * Updated 20.05.12: just for testing
 * Updated 23.05.12: added user, weapon, armor and aid section
 * Updated 28.05.12: 90% ready
 */
@Controller
@RequestMapping(value = "/adminPanel")
public class AdminPanelController {

	//private Logger log = Logger.getLogger(AdminPanelController.class);
		
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService; 
	
	/* Just for redirecting. Facilitates access to AP*/
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminPage() {
		return "redirect:adminPanel/summary.html";	
	}
	
	/* Displays short administrative info about site */
	@RequestMapping(value = "summary", method = RequestMethod.GET)
	public ModelAndView showSummaryPage(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("amountOfUsers", (Integer) adminPanelManagerService.getUsersNumber());
		mav.addObject("amountOfWeapons", (Integer) adminPanelManagerService.getWeaponsNumber());
		mav.addObject("amountOfArmors", (Integer) adminPanelManagerService.getArmorsNumber());
		mav.addObject("amountOfAids", (Integer) adminPanelManagerService.getAidsNumber());
		mav.addObject("lastRegistered", (List<User>)adminPanelManagerService.get5LastRegisteredUsers());
		mav.setViewName("/adminPanel/summary"); 
		return mav; 
	}
	
	/* Displays all registered users on site */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.getAllUsers());
		mav.setViewName("/adminPanel/users");
		
		return mav; 
	}
	
	/* Displays all registered users on site */
	@RequestMapping(value="/usersOrderByRegDate", method = RequestMethod.GET)
	public ModelAndView showUsersSortedByRegDabe(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.sortUsersByRegDate());
		mav.setViewName("/adminPanel/users");
		
		return mav; 
	}
	
	/* Displays all registered users on site */
	@RequestMapping(value="/usersOrderByNickName", method = RequestMethod.GET)
	public ModelAndView showUsersSortedByNickName(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.sortUsersByNick());
		mav.setViewName("/adminPanel/users");
		
		return mav; 
	}
	
	
	@RequestMapping(value="/weapons", method = RequestMethod.GET)
	public ModelAndView showWeapons(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("weapons", (List<Weapon>)adminPanelManagerService.getAllWeapons()); 
		
		mav.setViewName("/adminPanel/weapons");
		return mav; 
	}
	
	@RequestMapping(value="/armors", method = RequestMethod.GET)
	public ModelAndView showArmors(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("armors", (List<Armor>)adminPanelManagerService.fetchAllArmors());
		
		mav.setViewName("/adminPanel/armors");
		return mav; 
	}
	
	@RequestMapping(value="/aids", method = RequestMethod.GET)
	public ModelAndView showAids(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("aids", (List<Aid>)adminPanelManagerService.getAllAids());
		
		mav.setViewName("/adminPanel/aids");
		return mav; 
	}
}