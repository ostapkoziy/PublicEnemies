package com.epam.publicenemies.web.casino.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;

public class StandBlackJackController extends AbstractController {
	private Logger log = Logger.getLogger(StandBlackJackController.class);
	
	private BlackJackDeck deck;
	private BlackJackGameList games;
	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}	
	public void setGames(BlackJackGameList games) {
		this.games = games;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				return null;
}
}