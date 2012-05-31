package com.epam.publicenemies.web.adminpanel;

import javax.servlet.http.HttpServletRequest;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.service.IAdminPanelManagerService;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * Allows to manage users table
 * 
 * @author I. Kostyrko
 *
 */
@Controller
@RequestMapping(value = "/adminPanel/user")
public class UserManagerController implements IManageable {
	
	//private Logger log = Logger.getLogger(UserManagerController.class);
	
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService; 

	@Autowired
	private IProfileManagerService profileManagerService; 

	@Autowired
	private IUserManagerService userManagerService; 
	
	@Override
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/addNewUser"); 
		
		return mav; 		
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String doAddNewOne(HttpServletRequest request) {
		
		adminPanelManagerService.addUser(
				request.getParameter("email"), 
				request.getParameter("pass"),
				request.getParameter("nickname"),
				Integer.parseInt(request.getParameter("money")),
				request.getParameter("avatar"));
		return "redirect:../users.html"; 		
	}

	@RequestMapping(value="edit/{euid}", method = RequestMethod.GET)	
	public ModelAndView editOne(@PathVariable Integer euid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("profile", profileManagerService.getProfileByUserId(euid)); 
		
		mav.setViewName("/adminPanel/editUser");
		
		return mav; 		
	}
	
	@RequestMapping(value="edit/{euid}", method = RequestMethod.POST)	
	public String doEditOne(HttpServletRequest request) {
		userManagerService.updateUserInfo( Integer.parseInt(request.getParameter("userId")),
				request.getParameter("email"), 
				request.getParameter("nickname"), 
				request.getParameter("avatar"), 
				Integer.parseInt(request.getParameter("money")), 
				Integer.parseInt(request.getParameter("profileId")));	
		
		return "redirect:../../users.html"; 
	}
	
	@Override
	@RequestMapping(value="delete/{duid}", method = RequestMethod.GET)
	public ModelAndView deleteOne(@PathVariable Integer duid) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("euid", duid);
		mav.setViewName("/adminPanel/deleteUser");
		
		return mav; 
	}
	
	@RequestMapping(value="delete/{duid}", method = RequestMethod.POST)
	public String doDeleteUser(HttpServletRequest request) {
		adminPanelManagerService.deleteUser(Integer.parseInt(request.getParameter("duid"))); 
		return "redirect:../../users.html"; 
	}

	@Override
	@RequestMapping(value="info/{iuid}")
	public ModelAndView detailInfo(@PathVariable Integer iuid) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("profile", profileManagerService.getProfileByUserId(iuid)); 
		
		mav.setViewName("/adminPanel/detailUserInfo");
		
		return mav;	
	}

}