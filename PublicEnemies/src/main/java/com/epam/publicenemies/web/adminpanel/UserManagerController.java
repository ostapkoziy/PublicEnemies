package com.epam.publicenemies.web.adminpanel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Allows to manage users table
 * 
 * @author I. Kostyrko
 *
 */
@Controller
@RequestMapping(value = "/adminPanel/user")
public class UserManagerController implements IManageable {

	@Override
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();
		
		return mav; 		
	}

	@RequestMapping(value="edit/{euid}", method = RequestMethod.GET)	
	public ModelAndView editOne(@PathVariable Integer euid) {
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("editUser"); 
		mav.addObject("euid", euid);
		mav.setViewName("/adminPanel/editUser");
		
		return mav; 		
	}
	
	@Override
	@RequestMapping(value="delete/{duid}", method = RequestMethod.GET)
	public ModelAndView deleteOne(@PathVariable Integer duid) {
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("editUser"); 
		mav.addObject("euid", duid);
		mav.setViewName("/adminPanel/deleteUser");
		
		return mav; 
		
	}

	@Override
	@RequestMapping(value="info/{iuid}")
	public ModelAndView detailInfo(@PathVariable Integer iuid) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("iuid", iuid);
		mav.setViewName("/adminPanel/detailUserInfo");
		
		return mav; 

		
	}

}
