package com.epam.publicenemies.web;

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

/**
 * Manages shop page
 * 
 * @author Ivan Kostyrko
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {
	
	private Logger log = Logger.getLogger(ShopController.class); 
	
	@Autowired
	@Qualifier("shopManagerService")
	private IShopManagerService shopManagerService;
	
	@Autowired
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	
	public void setShopManagerService(IShopManagerService isms) {
		this.shopManagerService = isms; 
	}
	

	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showShopForm(HttpServletRequest req) {
		log.info("Shop page is showing (get method)"); 
		ModelAndView mav = new ModelAndView(); 
		List<Aid> aids = shopManagerService.getAllAids();
		List<Armor> armors = shopManagerService.getAllArmors(); 
		List<Weapon> weapons = shopManagerService.getAllWeapons();
		if (aids == null) {
			log.info("aids doesn't existed"); 
		}		
		Profile pd = profileManagerService.getProfileByUserId((Integer) req.getSession().getAttribute("userId"));
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {
			// TODO: error page ?, unable to find profile for user
		}
		
		mav.addObject("profile", pd); 
		mav.addObject("aidsList", aids);
		mav.addObject("armorsList", armors);
		mav.addObject("weaponsList", weapons);
		mav.addObject("uid", pd.getUserId()); 
		
		mav.setViewName("shop"); 
		return mav;	
	}
}
