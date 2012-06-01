package com.epam.publicenemies.web.adminpanel;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Weapon;
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
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/addNewWeapon");

		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String doAddNewOne(HttpServletRequest request) {

		adminPanelManagerService.addWeapon(request.getParameter("wName"),
				Integer.parseInt(request.getParameter("wHP")),
				request.getParameter("wPicturePath"),
				Boolean.getBoolean(request.getParameter("wType")),
				Integer.parseInt(request.getParameter("wPrice")),
				request.getParameter("wDescription"));

		return "redirect:/PublicEnemies/adminPanel/weapons.html";
	}

	@RequestMapping(value = "edit/{ewid}", method = RequestMethod.GET)
	public ModelAndView editOne(@PathVariable Integer ewid) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("weapon",
				(Weapon) adminPanelManagerService.getWeaponById(ewid));
		mav.setViewName("/adminPanel/editWeapon");

		return mav;
	}

	@RequestMapping(value = "edit/{ewid}", method = RequestMethod.POST)
	public String doEditOne(HttpServletRequest request) {
		adminPanelManagerService.updateWeaponInfo(
				Integer.parseInt(request.getParameter("weaponId")),
				request.getParameter("wName"),
				Integer.parseInt(request.getParameter("wHP")),
				request.getParameter("wPicturePath"),
				Boolean.getBoolean(request.getParameter("wType")),
				Integer.parseInt(request.getParameter("wPrice")),
				request.getParameter("wDescription"));
		return "redirect:/adminPanel/weapons.html";
	}

	@Override
	@RequestMapping(value = "info/{iwid}")
	public ModelAndView detailInfo(@PathVariable Integer iwid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("weapon",
				(Weapon) adminPanelManagerService.getWeaponById(iwid));
		mav.setViewName("/adminPanel/detailWeaponInfo");

		return mav;
	}

	@Override
	@RequestMapping(value = "delete/{dwid}", method = RequestMethod.GET)
	public ModelAndView deleteOne(@PathVariable Integer dwid) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/adminPanel/deleteWeapon");
		return mav;
	}

}
