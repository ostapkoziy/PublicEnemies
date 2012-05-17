package com.epam.publicenemies.web.casino.blackjack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class BlackJackGameController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String chips = request.getParameter("chips") + " $";
		
		Map<String, String> objects = new HashMap<String, String>();
		objects.put("chips", chips);
		
		return new ModelAndView("blackJackGame",objects);
	}

}
