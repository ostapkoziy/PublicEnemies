package com.epam.publicenemies.web.casino.roulette;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.publicenemies.domain.roulette.RouletteGameInfo;


@Controller
@RequestMapping("/rouletteGame.html")
public class RouletteGameController{
	
	RouletteGameInfo rouletteGameInfo;

	private Logger log = Logger.getLogger(RouletteGameController.class); 
	
	final int ROULETTE_NUMBERS = 7;// 0..36
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRouletteGame(){
		log.debug("In da rouletteGameController, GET method.");
		return "rouletteGame";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(HttpServletRequest request){

		int rnd = new Random().nextInt(ROULETTE_NUMBERS);
		int chips;

		log.debug("In da rouletteGameController, POST method.");
		
		HttpSession session = request.getSession();
		rouletteGameInfo = (RouletteGameInfo)session.getAttribute("rouletteGameInfo");
		if ((session.getAttribute("rouletteGameInfo")==null)||(request.getParameter("userBetNumbers")==null)) 
		{
			//old way getting user
			log.debug("Creating new rouletteGameInfo for session");
			rouletteGameInfo = new RouletteGameInfo();
			rouletteGameInfo.setChips(Integer.valueOf(request.getParameter("chips")));
			session.setAttribute("rouletteGameInfo", rouletteGameInfo);
			return "rouletteGame";
		}else{
			String unparsedBetNumbers = request.getParameter("userBetNumbers");
			String[] betNumbers = unparsedBetNumbers.split(",");
			rouletteGameInfo.setBetNumbers(betNumbers);
			rouletteGameInfo.setMsg("");
			rouletteGameInfo.setBetAmount(Integer.valueOf(request.getParameter("betVal")));
			int betOnTable = betNumbers.length * rouletteGameInfo.getBetAmount(); // THIS IS Simple BET calculation
			
			chips = rouletteGameInfo.getChips() - betOnTable;
			//Does RouletteTable bets empty?
			if ( betNumbers[0] == "" ) {
				rouletteGameInfo.setMsg("Make your BET on Roulette table! ");
				return "rouletteGame";
			}

			//Is money enough to make this BET?
			if ( chips < 0 ){
//				gameInfo.setMsg("Money:"+user.getMoney()+" BET:"+ gameInfo.getBetAmount() +" Money without bet:" + money);
				rouletteGameInfo.setMsg("You have not enough money to make this BET (BET on table:" + betOnTable +"$)");
				return "rouletteGame";
			}
			
		}

		rouletteGameInfo.setChips(chips + calculatePrize( rouletteGameInfo.getBetNumbers(), rnd ));

		log.debug("rnd = " + rnd + "\nBet on: "+ (String) request.getParameter("userBetNumbers"));

		log.debug(" Chips after:" + rouletteGameInfo.getChips() + "$");

		return "rouletteGame";
	}

	private int calculatePrize(String[] betNumbers, int rnd){
		int prize=0;

		for (String s : betNumbers) {
			if (s.equals(String.valueOf(rnd))){
				prize=rouletteGameInfo.getBetAmount()*(ROULETTE_NUMBERS-2);//Simple PRIZE calculation
				log.debug("Number "+ s +" had WON!");
				log.debug("Bet is " + rouletteGameInfo.getBetAmount());
				log.debug("Prize is " + prize);
			}
		}
		return prize;
	}
}
