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
import com.epam.publicenemies.web.listeners.SessionListener;

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
		
		mav.addObject("usersOnline", (Integer) SessionListener.getCounter());
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
	
	/* Displays all registered users on site sorted by regDate */
	@RequestMapping(value="/usersOrderByRegDate", method = RequestMethod.GET)
	public ModelAndView showUsersSortedByRegDabe(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.sortUsersByRegDate());
		mav.setViewName("/adminPanel/users");
		
		return mav; 
	}
	
	// TO EDIT USER
	/* Displays form for selecting users */
	@RequestMapping(value="/selectUserToEdit", method = RequestMethod.GET)
	public ModelAndView redirectToEdit(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.getAllUsers());
		mav.setViewName("/adminPanel/selectUser");
		
		return mav; 
	}
	
	/* Redirect to edit user */
	@RequestMapping(value="/selectUserToEdit", method = RequestMethod.POST)
	public String showSelectUsers(HttpServletRequest req) {
		return "redirect:user/edit/" + Integer.parseInt(req.getParameter("selected_user")) + ".html";
		
	}
	
	// TO DELETE USER
	/* Displays form for selecting users */
	@RequestMapping(value="/selectUserToDelete", method = RequestMethod.GET)
	public ModelAndView redirectToDelete(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allUsers", (List<User>)adminPanelManagerService.getAllUsers());
		mav.setViewName("/adminPanel/selectUser");
		
		return mav; 
	}
	
	/* Redirect to edit user */
	@RequestMapping(value="/selectUserToDelete", method = RequestMethod.POST)
	public String showSelectUsersToDelete(HttpServletRequest req) {
		return "redirect:user/delete/" + Integer.parseInt(req.getParameter("selected_user")) + ".html";		
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
	
	// TO EDIT WEAPON
	/* Displays form for selecting weapon */
	@RequestMapping(value="/selectWeaponToEdit", method = RequestMethod.GET)
	public ModelAndView redirectToEditWeapon(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("weapons", (List<Weapon>)adminPanelManagerService.getAllWeapons());		
		mav.setViewName("/adminPanel/selectWeapon");
		
		return mav; 
	}
	
	/* Redirect to edit weapon */
	@RequestMapping(value="/selectWeaponToEdit", method = RequestMethod.POST)
	public String showSelectedWeapon(HttpServletRequest req) {
		return "redirect:weapon/edit/" + Integer.parseInt(req.getParameter("selected_weapon")) + ".html";
	}
	
	@RequestMapping(value="/armors", method = RequestMethod.GET)
	public ModelAndView showArmors(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("armors", (List<Armor>)adminPanelManagerService.fetchAllArmors());
		mav.setViewName("/adminPanel/armors");
		return mav; 
	}
	
	// TO EDIT ARMOR
	/* Displays form for selecting armor */
	@RequestMapping(value="/selectArmorToEdit", method = RequestMethod.GET)
	public ModelAndView redirectToEditArmor(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("armors", (List<Armor>)adminPanelManagerService.fetchAllArmors());		
		mav.setViewName("/adminPanel/selectArmor");
		
		return mav; 
	}
	
	/* Redirect to edit user */
	@RequestMapping(value="/selectArmorToEdit", method = RequestMethod.POST)
	public String showSelectedArmor(HttpServletRequest req) {
		return "redirect:armor/edit/" + Integer.parseInt(req.getParameter("selected_armor")) + ".html";
	}
	
	@RequestMapping(value="/aids", method = RequestMethod.GET)
	public ModelAndView showAids(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("aids", (List<Aid>)adminPanelManagerService.getAllAids());
		
		mav.setViewName("/adminPanel/aids");
		return mav; 
	}
	
	// TO EDIT AID
	/* Displays form for selecting aid */
	@RequestMapping(value="/selectAidToEdit", method = RequestMethod.GET)
	public ModelAndView redirectToEditAid(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("aids", (List<Aid>)adminPanelManagerService.getAllAids());		
		mav.setViewName("/adminPanel/selectAid");
		
		return mav; 
	}
	
	/* Redirect to edit aid */
	@RequestMapping(value="/selectAidToEdit", method = RequestMethod.POST)
	public String showSelectedAid(HttpServletRequest req) {
		return "redirect:aid/edit/" + Integer.parseInt(req.getParameter("selected_aid")) + ".html";
	}
}