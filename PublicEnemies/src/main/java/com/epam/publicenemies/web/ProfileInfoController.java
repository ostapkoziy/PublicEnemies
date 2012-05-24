package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * This controller allows users to see their character
 * such as basic stats, items, played games, money etc.
 * Contains a link to change/customize the profile (editProfile)
 *   
 * @author Ivan Kostyrko
 *
 */
@Controller
@RequestMapping("/profile")
public class ProfileInfoController {
	
	@Autowired
	private IProfileManagerService	profileManagerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showProfile(HttpServletRequest request)	{
		ModelAndView mav = new ModelAndView(); 
		
		mav.addObject("profile", (Profile) profileManagerService
				.getProfileByUserId((Integer) request.getSession()
						.getAttribute("userId")));
		
		mav.setViewName("profile");		
		return mav; 
	}
}
