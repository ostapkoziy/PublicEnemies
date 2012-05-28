package com.epam.publicenemies.web.adminpanel;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.service.IAdminPanelManagerService;

/**
 * Allows to manage weapons table
 * 
 * @author I. Kostyrko
 * 
 */
@Controller
@RequestMapping(value = "/adminPanel/weapon")
public class WeaponManagerController implements IManageable {

	private Logger log = Logger.getLogger(WeaponManagerController.class);
	
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService;	
	
	@Override
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/addNewWeapon");
		
		return mav;
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String doAddNewOne(HttpServletRequest request) {
		
		adminPanelManagerService.addWeapon(
				request.getParameter("wName"), 
				Integer.parseInt(request.getParameter("wHP")), 
				request.getParameter("wPicturePath"), 
				Boolean.getBoolean(request.getParameter("wType")), 
				Integer.parseInt(request.getParameter("wPrice")), 
				request.getParameter("wDescription")
				);
		
		return "redirect:../weapons.html"; 		
	}
	

	@RequestMapping(value="edit/{ewid}", method = RequestMethod.GET)
	public ModelAndView editOne(@PathVariable Integer ewid) {
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("editUser"); 
		//mav.addObject("profile", profileManagerService.getProfileByUserId(euid)); 
		//mav.addObject("euid", euid);
		mav.setViewName("/adminPanel/editWeapon");
		
		return mav;

	}
	
	@RequestMapping(value="edit/{ewid}", method = RequestMethod.POST)	
	public String doEditOne(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		/*log.info("doEdit: ");
		log.info("   userId: " + Integer.parseInt(request.getParameter("userId")));
		log.info("   email: " + request.getParameter("email"));
		log.info("   nickname: " + request.getParameter("nickname"));
		log.info("   avatar: " + request.getParameter("avatar"));
		log.info("   money: " + Integer.parseInt(request.getParameter("money")));
		log.info("   profileId: " + Integer.parseInt(request.getParameter("profileId")));
		userManagerService.updateUserInfo(Integer.parseInt(request.getParameter("userId")), 
				request.getParameter("email"), 
				request.getParameter("nickname"), 
				request.getParameter("avatar"), 
				Integer.parseInt(request.getParameter("money")), 
				Integer.parseInt(request.getParameter("profileId")));
		
				//request.getParameter("pass")
		mav.setViewName("/adminPanel/editUser");
		*/
		return "redirect:../weapons.html"; 
	}
	

	@Override
	@RequestMapping(value="info/{iwid}")
	public ModelAndView detailInfo(@PathVariable Integer iwid) {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/detailWeaponInfo");

		return mav;
	}

	@Override
	@RequestMapping(value="delete/{dwid}", method = RequestMethod.GET)
	public ModelAndView deleteOne(@PathVariable Integer dwid) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/deleteWeapon"); 
		return mav;

	}

}
