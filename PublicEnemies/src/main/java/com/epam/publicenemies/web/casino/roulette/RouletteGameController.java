package com.epam.publicenemies.web.casino.roulette;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.roulette.BetTypes;
import com.epam.publicenemies.domain.roulette.RouletteGameInfo;
import com.epam.publicenemies.service.IProfileManagerService;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/rouletteLogic.html")
public class RouletteGameController {

	private RouletteGameInfo rouletteGameInfo;

	private Logger log = Logger.getLogger(RouletteGameController.class);

	final int ROULETTE_NUMBERS = 48;// 0..36

	@RequestMapping(method = RequestMethod.POST)
	public void processForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		JSONSerializer serializer = new JSONSerializer();
		int rnd = new Random().nextInt(36);
		int chips = 0;

		response.setContentType("text/html;charset=UTF-8");

		log.debug("In da rouletteGameController, POST method.");

		HttpSession session = request.getSession();
		rouletteGameInfo = (RouletteGameInfo) session.getAttribute("rouletteGameInfo");

		if (request.getParameter("userBetNumbers") != "") {
			parseBetString(request.getParameter("userBetNumbers"));
		} else {
			rouletteGameInfo.setMsg("Make your BET on Roulette table! ");
			response.getWriter().print(serializer.serialize(rouletteGameInfo));
			return;
		}

		Integer[] bets = rouletteGameInfo.getBets();

		rouletteGameInfo.setBetAmount(0);
		for (int i = 0; i < bets.length; i++) {
			if (bets[i] != null)
				rouletteGameInfo.setBetAmount(rouletteGameInfo.getBetAmount() + bets[i]);
		}

		chips = rouletteGameInfo.getChips() - rouletteGameInfo.getBetAmount();

		// Is chips enough to make this BET?
		if (chips < 0) {
			rouletteGameInfo.setMsg("You have not enough money to make this BET (BET on table:" + rouletteGameInfo.getBetAmount() + " chips)");
			return;
		}

		int prize = 0;

		for (BetTypes betType : BetTypes.values()) {
			int betPrize = betType.getPrize(betType, rouletteGameInfo.getBets(), rnd);
			if (betPrize > 0){
				prize += betPrize;
				log.info(betType.name() + " award " + betPrize + " chips");
				}
		}

		rouletteGameInfo.setChips(chips + prize);

		log.info("Roulette number = " + rnd + "\nBet on: " + (String) request.getParameter("userBetNumbers"));
		log.info("Chips after:" + rouletteGameInfo.getChips());
		response.getWriter().print(serializer.serialize(rouletteGameInfo));
		response.getWriter().flush();
	}

	private void parseBetString(String unparsedStr) {
		String[] unparsedBets = unparsedStr.split(";");
		Integer[] bets = new Integer[ROULETTE_NUMBERS + 1];
		rouletteGameInfo.setMsg("");

		for (String s : unparsedBets) {
			String[] buf = s.split(":");
			bets[Integer.valueOf(buf[0])] = Integer.valueOf(buf[1]);
		}
		rouletteGameInfo.setBets(bets);
	}

}
