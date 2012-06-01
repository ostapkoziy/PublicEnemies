package com.epam.publicenemies.web;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.IUserRatingService;

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
	
	private Logger log = Logger.getLogger(ProfileInfoController.class);
	
	@Autowired
	private IProfileManagerService	profileManagerService;
	
	@Autowired
	private IUserRatingService userRatingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showProfile(HttpServletRequest request)	{
		ModelAndView mav = new ModelAndView(); 
		
		mav.addObject("profile", (Profile) profileManagerService
				.getProfileByUserId((Integer) request.getSession()
						.getAttribute("userId")));
		List<Map<String, Object>> top10ByExp = userRatingService.sortUsersByExperience();	
		
		if (top10ByExp.size() < 10) {
				mav.addObject("usersListSortedByExp", top10ByExp);
		} else {
			mav.addObject("usersListSortedByExp", top10ByExp.subList(0, 10));
		}
		
		List<Map<String, Object>> top10ByMoney = userRatingService.sortUsersByMoney();
		
		if (top10ByMoney.size() < 10) {
			mav.addObject("usersListSortedByMoney", top10ByMoney);
		} else {
			mav.addObject("usersListSortedByMoney", top10ByMoney.subList(0, 10));
		}
		
		mav.setViewName("profile");		
		return mav; 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String changeProfileTrunk(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		
		int uid = (Integer) request.getSession().getAttribute("userId");
		
		
		// name of passed parameter through the form
		String parameterName = "";
		// to parse id of items
		String delimiter = "_"; 
		// for splitting
		String temp[];
		
		Enumeration<String> myenum = request.getParameterNames();
		for (; myenum.hasMoreElements(); ) {			
		    // get the name of the attribute
			parameterName = (String)myenum.nextElement();
			
			temp = parameterName.split(delimiter);
			
			if (parameterName.matches("^undressWeapon1(.*)")) {
				profileManagerService.undressWeapon1(uid);
			} else if (parameterName.matches("^undressWeapon2(.*)")) {
				profileManagerService.undressWeapon2(uid);
			} else if (parameterName.matches("^undressArmor(.*)")) {	
				profileManagerService.undressArmor(uid);								
			} else if (parameterName.matches("^undressAid(.*)")) {
				profileManagerService.undressAid(uid);				
			} else if (parameterName.matches("^dressWeapon(.*)")) {		
				if (profileManagerService.isEmptyWeapon2(uid)) {
					profileManagerService.dressWeapon2(uid, Integer.parseInt(temp[1]));
				} else {
					//profileManagerService.undressWeapon1(uid);
					profileManagerService.dressWeapon1(uid, Integer.parseInt(temp[1]));
				}
			} else if (parameterName.matches("^dressArmor(.*)")) {
				//profileManagerService.undressArmor(uid);
				profileManagerService.dressArmor(uid, Integer.parseInt(temp[1]));
			} else if (parameterName.matches("^dressAid(.*)")) {
				//profileManagerService.undressAid(uid);
				profileManagerService.dressAid(uid, Integer.parseInt(temp[1]));
			} else {}
			
			/*log.info("ProfileInfoController: passed value = " + parameterName);
			log.info("part 1 = " + temp[0]);
			log.info("part 2 = " + temp[1]);*/
		}
		return "redirect:profile.html"; 
	}
}
