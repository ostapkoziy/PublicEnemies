package com.epam.publicenemies.web;

import java.util.ArrayList;
import java.util.Enumeration;
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
 * 
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {
	
	private Logger log = Logger.getLogger(ShopController.class); 
	
	@Autowired
	private IShopManagerService shopManagerService;
	
	@Autowired
	private IProfileManagerService	profileManagerService;
	
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
		// fetch profile from db
		Profile pd = profileManagerService.getProfileByUserId((Integer) req
				.getSession().getAttribute("userId"));
		
		if (pd != null) {
			log.info("Profile has been fetched successfully");
		} else {
			// TODO: error page ?, unable to find profile for user
			log.info("Error while fetching. Deal with it!");
		}
		
		mav.addObject("money", pd.getMoney()); 
		mav.addObject("profile", pd);
		mav.addObject("profileInfo", pd);
		mav.addObject("aidsList", aids);
		mav.addObject("armorsList", armors);
		mav.addObject("weaponsList", weapons);		 
		
		mav.setViewName("shop"); 
		return mav;	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String approvePurchase(HttpServletRequest req) {
		log.info("ShopController: approvePurchase (post)"); 
		// fetch uid from session
		int uid = (Integer) req.getSession().getAttribute("userId"); 
				
		// lists of items needed to sell/buy
		List<Integer> weaponsToSell = new ArrayList<Integer>();
		List<Integer> armorsToSell = new ArrayList<Integer>();
		List<Integer> aidsToSell = new ArrayList<Integer>();
		
		List<Integer> weaponsToBuy = new ArrayList<Integer>();
		List<Integer> armorsToBuy = new ArrayList<Integer>();
		List<Integer> aidsToBuy = new ArrayList<Integer>();
				
		Enumeration<String> myenum = req.getParameterNames();
		// name of passed parameter through the form
		String parameterName = "";
		// to parse id of items
		String delimiter = "\\|"; 
		// for splitting
		String temp[];
		// numbers of items that need to buy
		int counterItem = 0;
		// analyze passed parameters		
		for (; myenum.hasMoreElements(); ) {			
		    // get the name of the attribute
			parameterName = (String)myenum.nextElement();
			log.info("param name = " + parameterName); 
			temp = parameterName.split(delimiter); 
			if (parameterName.matches("^sell_rweapon(.*)")) {
				weaponsToSell.add(Integer.parseInt(temp[1]));							
			} else if (parameterName.matches("^sell_rarmor(.*)")) {				
				armorsToSell.add(Integer.parseInt(temp[1]));
								
			} else if (parameterName.matches("^sell_raid(.*)")) {
				log.info("Try to sell raid =  " + temp[1]); 
				aidsToSell.add(Integer.parseInt(temp[1]));
				
			} else if (parameterName.matches("^buy_weapon(.*)")) {				
				counterItem = Integer.parseInt(req.getParameter("buy_weapon|" + temp[1]));
				for(int i = 0; i < counterItem; i++) {
					weaponsToBuy.add(Integer.parseInt(temp[1]));
				}
			} else if (parameterName.matches("^buy_armor(.*)")) {
				counterItem = Integer.parseInt(req.getParameter("buy_armor|" + temp[1]));
				for(int i = 0; i < counterItem; i++) {
					armorsToBuy.add(Integer.parseInt(temp[1]));
				}
			} else if (parameterName.matches("^buy_aid(.*)")) {
				counterItem = Integer.parseInt(req.getParameter("buy_aid|" + temp[1]));
				for(int i = 0; i < counterItem; i++) {
					aidsToBuy.add(Integer.parseInt(temp[1]));
				}
			} else {}		
		}
		
		/*log.info("to sell: ");
		for (Integer weapon : weaponsToSell) {
		    log.info("sell weapon id = " + weapon);
		}
		for (Integer armor : armorsToSell) {
		    log.info("sell armor id = " + armor);
		}
		for (Integer aid : aidsToSell) {
		    log.info("sell aid id = " + aid);
		}
		
		for (Integer weapon : weaponsToBuy) {
		    log.info("Buy weapon id = " + weapon);
		}
		for (Integer armor : armorsToBuy) {
		    log.info("Buy armor id = " + armor);
		}
		for (Integer aid : aidsToBuy) {
		    log.info("Buy aid id = " + aid);
		}*/
		
		if (weaponsToSell.size() > 0) {
			shopManagerService.sellWeaponsForUser(uid, weaponsToSell); 
		}
		if (armorsToSell.size() > 0) {
			shopManagerService.sellArmorsForUser(uid, armorsToSell); 
		}
		if (aidsToSell.size() > 0) {
			log.info("To shopManagerService for selling aid with id = " + aidsToSell.get(0)); 
			shopManagerService.sellAidsForUser(uid, aidsToSell);
		}
		if (weaponsToBuy.size() > 0) {
			shopManagerService.buyWeaponsForUser(uid, weaponsToBuy); 
		}
		if (armorsToBuy.size() > 0) {
			shopManagerService.buyArmorsForUser(uid, armorsToBuy); 
		}
		if (aidsToBuy.size() > 0) {
			shopManagerService.buyAidsForUser(uid, aidsToBuy); 
		}
		
		return "redirect:shop.html";	
	}
	
}
