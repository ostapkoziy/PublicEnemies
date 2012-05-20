package com.epam.publicenemies.web.adminpanel;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.service.IAdminPanelManagerService;

/**
 * Shows all information about site (users and items)
 * Allows to manage it (add/edit/delete)
 * 
 * @author Ivan Kostyrko
 *
 * Updated 20.05.12: just for testing
 */
@Controller
@RequestMapping(value = "/adminPanel")
public class AdminPanelController {
	private Logger log = Logger.getLogger(AdminPanelController.class);
		
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAdminPage(HttpServletRequest req) {
		log.info("AdminPanelController: get method"); 
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("passedValue", adminPanelManagerService.getUsersNumber()); 
		
		mav.setViewName("adminPanel"); 
		
		return mav; 
	}

}
