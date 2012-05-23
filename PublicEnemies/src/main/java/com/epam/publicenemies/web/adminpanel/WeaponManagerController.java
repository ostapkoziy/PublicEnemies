package com.epam.publicenemies.web.adminpanel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Allows to manage weapons table
 * 
 * @author I. Kostyrko
 * 
 */
public class WeaponManagerController implements IManageable {

	@Override
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();

		return mav;
	}

	public ModelAndView editOne(@PathVariable Integer euid) {
		ModelAndView mav = new ModelAndView();

		return mav;

	}

	public ModelAndView detailInfo(@PathVariable Integer iuid) {

		ModelAndView mav = new ModelAndView();

		return mav;
	}

	@Override
	public ModelAndView deleteOne(@PathVariable Integer duid) {
		ModelAndView mav = new ModelAndView();

		return mav;

	}

}
