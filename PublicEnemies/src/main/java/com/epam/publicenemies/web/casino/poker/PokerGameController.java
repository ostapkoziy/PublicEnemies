package com.epam.publicenemies.web.casino.poker;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.IShopManagerService;



/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class PokerGameController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		return new ModelAndView("pokerGame");
	}

}
*/
/**
 * Manages shop page
 * 
 * @author Ostap Koziy
 */
@Controller
@RequestMapping("/pokerGame")
public class PokerGameController {
	
	private Logger log = Logger.getLogger(PokerGameController.class); 
	
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	

	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showShopForm(HttpServletRequest req) {
		log.info("Poker page is showing (get method)"); 
		ModelAndView mav = new ModelAndView(); 

		Profile pd = profileManagerService.getProfileByUserId((Integer) req.getSession().getAttribute("userId"));
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {
			log.info("USER NOT FOUND!");
		}
		
		mav.addObject("profile", pd); 

		
		mav.setViewName("pokerGame"); 
		return mav;	
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postPoker(HttpServletRequest req) {
		log.info("Poker page is showing (get method)"); 
		ModelAndView mav = new ModelAndView(); 
		String chips = req.getParameter("chips");
		mav.addObject("chips",chips);
		Profile pd = profileManagerService.getProfileByUserId((Integer) req.getSession().getAttribute("userId"));
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {
			log.info("USER NOT FOUND!");
		}
		
		mav.addObject("profile", pd); 

		
		mav.setViewName("pokerGame"); 
		return mav;	
	}
}
