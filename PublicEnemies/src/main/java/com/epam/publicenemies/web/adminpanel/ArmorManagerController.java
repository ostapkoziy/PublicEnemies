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
 * Allow to manage armors table
 * 
 * @author I. Kostyrko
 *
 */
@Controller
@RequestMapping(value = "/adminPanel/armor")
public class ArmorManagerController implements IManageable {
	
	private Logger log = Logger.getLogger(ArmorManagerController.class);
	
	@Autowired
	private IAdminPanelManagerService adminPanelManagerService;	
	
	@Override
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/addNewArmor");
		
		return mav;
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String doAddNewOne(HttpServletRequest request) {
		adminPanelManagerService.addArmor(
				request.getParameter("aName"), 
				request.getParameter("aPicturePath"), 
				Integer.parseInt(request.getParameter("aProtection")), 
				Integer.parseInt(request.getParameter("aPrice")), 
				request.getParameter("aDescription"));
		
		return "redirect:../armors.html"; 		
	}
	

	@RequestMapping(value="edit/{eaid}", method = RequestMethod.GET)
	public ModelAndView editOne(@PathVariable Integer eaid) {
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("editUser"); 
		//mav.addObject("profile", profileManagerService.getProfileByUserId(euid)); 
		//mav.addObject("euid", euid);
		mav.setViewName("/adminPanel/editArmor");
		
		return mav;

	}
	
	@RequestMapping(value="edit/{eaid}", method = RequestMethod.POST)	
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
		return "redirect:../armors.html"; 
	}
	

	@Override
	@RequestMapping(value="info/{iaid}")
	public ModelAndView detailInfo(@PathVariable Integer iaid) {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/adminPanel/detailArmorInfo");

		return mav;
	}

	@Override
	@RequestMapping(value="delete/{daid}", method = RequestMethod.GET)
	public ModelAndView deleteOne(@PathVariable Integer daid) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/deleteArmor"); 
		return mav;

	}

}
