package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.service.IUserRatingService;

/**
 * Generates rating list based on experience level and money
 * 
 * @author I. Kostyrko
 * 
 */
@Controller
public class RatingController {

	@Autowired
	private IUserRatingService userRatingService;

	@RequestMapping(value = "/ratingByExp")
	public ModelAndView showRatingByExp(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("usersList", userRatingService.sortUsersByExperience());

		mav.addObject("sortLabel", new Integer(0));
		mav.setViewName("rating");

		return mav;
	}

	@RequestMapping(value = "/ratingByMoney")
	public ModelAndView showRatingBymoney(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("usersList", userRatingService.sortUsersByMoney());
		// 0 == sort by exp, 1 == sort by money
		mav.addObject("sortLabel", new Integer(1));
		mav.setViewName("rating");

		return mav;
	}

}
