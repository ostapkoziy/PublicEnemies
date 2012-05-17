package com.epam.publicenemies.web.casino.blackjack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class StartBlackJackController extends AbstractController {
	private Logger log = Logger.getLogger(StartBlackJackController.class);
	
	private Deck deck;
	

	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info(deck.getCard().toString());
		return new ModelAndView("blackJackGame");
	}

}
