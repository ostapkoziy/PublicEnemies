package com.epam.publicenemies.web.casino.roulette;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.roulette.BetTypes;
import com.epam.publicenemies.domain.roulette.RouletteGameInfo;


@Controller
@RequestMapping("/rouletteGame.html")
public class RouletteGameController{
	
	RouletteGameInfo rouletteGameInfo;

	private Logger log = Logger.getLogger(RouletteGameController.class); 
	
	final int ROULETTE_NUMBERS = 48;// 0..36
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRouletteGame(){
		log.debug("In da rouletteGameController, GET method.");
		return "rouletteGame";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(HttpServletRequest request){

		int rnd = new Random().nextInt(36);
		int chips;

		log.debug("In da rouletteGameController, POST method.");
		
		HttpSession session = request.getSession();
		rouletteGameInfo = (RouletteGameInfo)session.getAttribute("rouletteGameInfo");
		if ((session.getAttribute("rouletteGameInfo")==null)||(request.getParameter("userBetNumbers")==null)) 
		{
			//old way getting user
			log.debug("No "+ RouletteGameController.class +" instance, creating new one for session.");
			rouletteGameInfo = new RouletteGameInfo();
			
			if (request.getParameter("chips")!=null) rouletteGameInfo.setChips(Integer.valueOf(request.getParameter("chips")));
			else rouletteGameInfo.setChips(0);
			
			session.setAttribute("rouletteGameInfo", rouletteGameInfo);
			return "rouletteGame";
		}
		else
		{
			String[] unparsedBets = request.getParameter("userBetNumbers").split(";");
			log.info(request.getParameter("userBetNumbers"));
			Integer[] bets = new Integer[ROULETTE_NUMBERS + 1];
			rouletteGameInfo.setMsg("");
		
			if ( request.getParameter("userBetNumbers") == "" ) {
				rouletteGameInfo.setMsg("Make your BET on Roulette table! ");
				return "rouletteGame";
			}

			for(String s:unparsedBets){
				String[] buf = s.split(":");
//				log.debug("buf[0]=" + buf[0] + "buf[1]="+buf[1]);
				bets[Integer.valueOf(buf[0])] = Integer.valueOf(buf[1]);
			}
			
			rouletteGameInfo.setBets(bets);
			
			rouletteGameInfo.setBetAmount(0);
			for(int i=0; i<bets.length; i++){
				if (bets[i]!=null) rouletteGameInfo.setBetAmount(rouletteGameInfo.getBetAmount() + bets[i]); 
			}
			
			chips = rouletteGameInfo.getChips() - rouletteGameInfo.getBetAmount();


		//Is money enough to make this BET?
		if ( chips < 0 ){
			rouletteGameInfo.setMsg("You have not enough money to make this BET (BET on table:" + rouletteGameInfo.getBetAmount() +" chips)");
			return "rouletteGame";
		}
			
	}

//	rouletteGameInfo.setChips(chips + calculatePrize( rouletteGameInfo.getBets(), rnd ));
	int prize = 0;
	log.info("Roulette number = "+ rnd);
	
	for (BetTypes betType: BetTypes.values()){
		prize += betType.getPrize(betType, rouletteGameInfo.getBets(), rnd);
		if (prize>0) log.info(betType.name()+" award "+ prize +" chips");
	}
	
	rouletteGameInfo.setChips(chips + prize);

	log.info("rnd = " + rnd + "\nBet on: "+ (String) request.getParameter("userBetNumbers"));

	log.info(" Chips after:" + rouletteGameInfo.getChips());

		return "rouletteGame";
	}
}
