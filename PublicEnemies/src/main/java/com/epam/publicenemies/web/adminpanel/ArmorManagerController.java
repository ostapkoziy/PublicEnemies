package com.epam.publicenemies.web.adminpanel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Allow to manage armors table
 * 
 * @author I. Kostyrko
 *
 */
public class ArmorManagerController implements IManageable {

	@Override
	public ModelAndView addNewOne() {
		ModelAndView mav = new ModelAndView();
		
		return mav; 

		
	}

	public ModelAndView editOne(@PathVariable Integer uid) {
		ModelAndView mav = new ModelAndView();
		
		return mav; 

		
	}

	@Override
	public ModelAndView deleteOne(@PathVariable Integer uid) {
		ModelAndView mav = new ModelAndView();
		
		return mav; 

		
	}

	@Override
	public ModelAndView detailInfo(@PathVariable Integer uid) {
		ModelAndView mav = new ModelAndView();
		
		return mav; 

		
	}

}
