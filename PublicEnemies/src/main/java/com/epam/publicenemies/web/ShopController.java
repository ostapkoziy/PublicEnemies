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
	
	public void setShopManagerService(IShopManagerService isms) {
		this.shopManagerService = isms; 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showShopForm(HttpServletRequest req) {
		log.info("Shop page is showing (get method)"); 
		ModelAndView mav = new ModelAndView(); 
		shopManagerService.voidMethod(); 
		List<Aid> aids = shopManagerService.getAllAids(); 
		if (aids == null) {
			log.info("aids doesn't existed"); 
		}
		//log.info("Aids have been fetched. Size = " + aids.size());
		
		mav.addObject("aidsList", aids);
		mav.addObject("uid", (Integer) req.getSession().getAttribute("userId")); 
		
		mav.setViewName("shop"); 
		return mav;	
	}
}
