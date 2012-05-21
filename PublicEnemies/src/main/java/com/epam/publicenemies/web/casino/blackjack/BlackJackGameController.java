package com.epam.publicenemies.web.casino.blackjack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;

public class BlackJackGameController extends AbstractController {

	private BlackJackGameList games;
	public void setGames(BlackJackGameList games) {
		this.games = games;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = (Integer) request.getSession().getAttribute("userId");
		String chips = request.getParameter("chips");
		games.createNewGame(id,Integer.valueOf(chips));
		
		Map<String, String> objects = new HashMap<String, String>();
		objects.put("chips", chips + " $");
		objects.put("hit_state", "disabled=\"disabled\"");
		objects.put("stand_state", "disabled=\"disabled\"");
		objects.put("doubledown_state", "disabled=\"disabled\"");
		objects.put("split_state", "disabled=\"disabled\"");
		
		return new ModelAndView("blackJackGame",objects);
	}

}
