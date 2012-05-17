package com.epam.publicenemies.web.casino.roulette;

import java.util.Random;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.web.casino.poker.PokerGameController;


@Controller
@RequestMapping("/rouletteGame")
public class RouletteGameController{

	private Logger log = Logger.getLogger(PokerGameController.class); 
	
	final int ROULETTE_NUMBERS = 7;// 0..36

//	User user;
//	RouletteGameInfo gameInfo;

	private IProfileManagerService	profileManagerService;

	public void setProfileManagerService(IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRoulette(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		
		Profile prof = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		if (prof != null) {
			log.info("Profile has been fetched successfully");
		} else {
			log.info("USER NOT FOUND!");
		}
		
		mav.addObject("profile", prof); 

		
		mav.setViewName("rouletteGame"); 	
		
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		int rnd = new Random().nextInt(ROULETTE_NUMBERS);
//		gameInfo = (RouletteGameInfo) session.getAttribute("gameInfo");
//		user = (User) session.getAttribute("user");
		String unparsedBetNumbers = (String) request.getParameter("userBetNumbers");
		String[] betNumbers = unparsedBetNumbers.split(",");
		int money;
//		gameInfo.setMsg("");

//		gameInfo.setBetAmount(Integer.valueOf(request.getParameter("betVal")));
//		System.out.println("\nMoney before:" + user.getMoney()+"$ BET:"+ gameInfo.getBetAmount()+"$");
		
//		int betOnTable = betNumbers.length * gameInfo.getBetAmount(); // THIS IS Simple BET calculation
		
//		money = user.getMoney() - betOnTable;
		
		//Does RouletteTable bets empty?
		if ( betNumbers[0] == "" ) {
//			gameInfo.setMsg("Make your BET on Roulette table! "+unparsedBetNumbers);
			response.sendRedirect("RouletteGame");
//			return;
		}

		//Is money enough to make this BET?
//		if ( money < 0 ){
//			gameInfo.setMsg("You have not enough money to make this BET (BET on table:" + betOnTable +"$)");
			response.sendRedirect("RouletteGame");
//			return;
//		}

		
//		user.setMoney(money + calculatePrize(betNumbers,rnd));

		System.out.print("rnd = " + rnd + "\nBet on: "+ (String) request.getParameter("userBetNumbers"));

//		System.out.println(" Money after:" + user.getMoney() + "$");
		
		return new ModelAndView("rouletteGame");
	}
	
	private int calculatePrize(String[] betNumbers, int rnd){
		int prize=0;

		for (String s : betNumbers) {
			if (s.equals(String.valueOf(rnd))){
//				prize=gameInfo.getBetAmount()*(ROULETTE_NUMBERS-2);//Simple PRIZE calculation
				System.out.println("Number "+ s +" had WON!");
//				System.out.println("Bet is " + gameInfo.getBetAmount());
				System.out.println("Prize is " + prize);
			}
		}
		return prize;
	}

}
