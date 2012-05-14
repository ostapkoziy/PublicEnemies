package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * TODO: use annotations
 */

public class UserStartPageController implements Controller {
	
	private Logger log	= Logger.getLogger(UserStartPageController.class);
	
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	
	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(); 
		log.info("Showing userStartPage");
		//log.info("Session: userId = " + request.getSession().getAttribute("userId"));		
		//ProfileDto pd = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		Profile pd = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {			
			// TODO: error page ?, unable to find profile for user
			log.info("Can't find profile with such user id - " + request.getSession().getAttribute("userId"));
		}
		mav.addObject("profileInfo", pd);
		mav.setViewName("userStartPage"); 
		return mav;
	}
}
