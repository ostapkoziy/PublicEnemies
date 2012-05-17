package com.epam.publicenemies.web.casino.blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.epam.publicenemies.domain.blackjack.Deck;

public class StartBlackJackController extends AbstractController {
	private Logger log = Logger.getLogger(StartBlackJackController.class);
	
	private Deck deck;
	

	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String chips = request.getParameter("chips") + " $";
		String dealer_card = deck.getCard().image();
		
		
		Map<String, String> objects = new HashMap<String, String>();
		objects.put("chips", chips);
		
		return new ModelAndView("blackJackGame",objects);
	}

}
