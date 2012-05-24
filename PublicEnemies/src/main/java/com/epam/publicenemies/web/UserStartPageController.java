package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * TODO: use annotations
 */
@Controller
@RequestMapping(value = "/userStartPage")
public class UserStartPageController {
	
	private Logger log	= Logger.getLogger(UserStartPageController.class);
	
	@Autowired	
	private IProfileManagerService	profileManagerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(); 
		log.info("Showing userStartPage");
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
