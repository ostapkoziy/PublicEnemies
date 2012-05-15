package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		ModelAndView mav = new ModelAndView(); 
		
		return mav; 
	}
}
