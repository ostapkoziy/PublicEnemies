package com.epam.publicenemies.web.casino.poker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.poker.IPokerPlayer;
import com.epam.publicenemies.domain.poker.PokerCard;
import com.epam.publicenemies.domain.poker.PokerCombination;
import com.epam.publicenemies.service.IProfileManagerService;

import flexjson.JSONSerializer;

/**
 * @author Ostap Koziy
 */
@Controller
public class PokerServlet {
	private Logger log = Logger.getLogger(PokerServlet.class);
	private PokerGame pokerGame;
	static int partCounter = -1;
	private boolean dealer = false;
	private PokerCombination player1Combination, player2Combination;
	
	@Autowired	
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	
	@RequestMapping("/PokerServlet")
	public void hit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		boolean playerFolded = false;
		response.setContentType("text/html;charset=UTF-8");
		String userBet = new String(request.getParameter("userBet"));
		String computerBet = new String(request.getParameter("botBet"));
		Integer chips = (Integer)request.getSession().getAttribute("chips");
		pokerGame = (PokerGame) request.getSession().getAttribute("pokerGame");

		log.info("GAME - " + ser.serialize(pokerGame));
		
		log.info(pokerGame.getUser1Profile().getNickName() + " BET " + userBet);
		pokerGame.getPokerGameRound().move = !pokerGame.getPokerGameRound().move;
		int bet = 0;
		int bet2 = 0;
		bet2 = Integer.valueOf(computerBet);
		bet = Integer.valueOf(userBet);
		
		if((bet2 == -2)){
			resetGame(request, response);
			pokerGame.getPokerGameRound().setResult("New Round");
			log.info("New Round!");
			sendData(request, response, -1);
			if(pokerGame.getPokerGameRound().isDealer() == false){
				return;
			}else{
				//sendData(request, response, -1);
				
				pokerGame.getPokerGameRound().setResult("none");
				return;
			}
			
		}
		
		if(bet == -1){
			partCounter = 0;
			bet = 0;
		}
		
		bet += pokerGame.getPokerGameRound().getPlayer1Bet();
		pokerGame.getPokerGameRound().setPlayer1Bet(bet);
		pokerGame.getUser1Profile().setMoney(chips);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		if(partCounter == 0){
			log.info("PreFlop");
			pokerGame.setComment("PreFlop");
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				/*try {
				botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
			} catch (FoldException e) {
				partCounter = -1;
				playerFolded = true;
				log.info("Bot folded");
				pokerGame.getPokerGameRound().setResult("Bot folded");
			}*/
			botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
			if(pokerGame.getPokerGameRound().isDealer()== true){
				if(bet == 0){
					botBet+=50;
					log.info("bot bulls");
				}
			}
			pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			log.info("BETS - " + pokerGame.getPokerGameRound().getPlayer1Bet() + " and " + pokerGame.getPokerGameRound().getPlayer2Bet());
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				log.info("Pre flop over");
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				partCounter ++;
				List<PokerCard> flop = pokerGame.getPokerGameRound().flop();
				log.info("Poker flop - " + flop);
			}
			log.info("on preflop Bot bet - " + botBet +" to make his bet a total of " + pokerGame.getPokerGameRound().getPlayer2Bet());
			sendData(request, response, bet);
		}
		
		else if (partCounter == 1){
			pokerGame.setComment("Flop");
			log.info("FLOP USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				/*try {
					botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
				} catch (FoldException e) {
					partCounter = -1;
					playerFolded = true;
					log.info("Bot folded");
					pokerGame.getPokerGameRound().setResult("Bot folded");
				}*/
				botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
				if(pokerGame.getPokerGameRound().isDealer()== true){
					if(bet == 0){
						botBet+=50;
						log.info("bot bulls");
					}
					
				}
				pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				partCounter ++;
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				PokerCard turn = pokerGame.getPokerGameRound().turn();
				log.info("Poker turn - " + turn);
				log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
			}
			log.info("on flop Bot bet - " + botBet +" to make his bet a total of " + pokerGame.getPokerGameRound().getPlayer2Bet());
			sendData(request, response, bet);
		}
		
		else if(partCounter == 2){
			pokerGame.setComment("Turn");
			log.info("TURN USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				/*try {
				botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
			} catch (FoldException e) {
				partCounter = -1;
				playerFolded = true;
				log.info("Bot folded");
				pokerGame.getPokerGameRound().setResult("Bot folded");
			}*/
			botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
			if(pokerGame.getPokerGameRound().isDealer()== true){
				if(bet == 0){
					botBet+=50;
					log.info("bot bulls");
				}
			}
			pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				partCounter ++;
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				PokerCard river = pokerGame.getPokerGameRound().river();
				log.info("Poker river - " + river);
				
				log.info("Bot bet - " + pokerGame.getPokerGameRound().getPlayer2Bet());
			}
			log.info("on turn Bot bet - " + botBet +" to make his bet a total of " + pokerGame.getPokerGameRound().getPlayer2Bet());
			sendData(request, response, bet);
		}
		
		else if(partCounter == 3){
			pokerGame.setComment("River");
			log.info("RIVER USER BET IS - " + bet);
			int botBet = 0;
			if(pokerGame.getPokerGameRound().getPlayer1Bet() > pokerGame.getPokerGameRound().getPlayer2Bet()){
				/*try {
				botBet = pokerGame.getPokerGameRound().getPlayer2().makeMove(pokerGame);
			} catch (FoldException e) {
				partCounter = -1;
				playerFolded = true;
				log.info("Bot folded");
				pokerGame.getPokerGameRound().setResult("Bot folded");
			}*/
			botBet = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
			if(pokerGame.getPokerGameRound().isDealer()== true){
				if(bet == 0){
					botBet+=50;
					log.info("bot bulls");
				}
			}
			pokerGame.getPokerGameRound().setPlayer2Bet(pokerGame.getPokerGameRound().getPlayer2Bet() + botBet);
			}
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				log.info("on river Bot bet - " + botBet +" to make his bet a total of " + pokerGame.getPokerGameRound().getPlayer2Bet());
				log.info("Poker Showdown");
				pokerGame.setComment("Showdown");
				pokerGame.getPokerGameRound().setPot(pokerGame.getPokerGameRound().getPlayer1Bet() + pokerGame.getPokerGameRound().getPlayer2Bet());
				String res = pokerGame.getPokerGameRound().displayResults();
				
				if(res.contains(pokerGame.getPokerGameRound().getPlayer1().getName())){
					log.info("PLAYER 1 won and will recieve - "+pokerGame.getPokerGameRound().getPot());
					pokerGame.getPokerGameRound().getPlayer1().setCash(pokerGame.getPokerGameRound().getPlayer1().getCash() + pokerGame.getPokerGameRound().getPot());
				}
				else if(res.contains(pokerGame.getPokerGameRound().getPlayer2().getName())){
					log.info("PLAYER 2 won and will recieve - "+pokerGame.getPokerGameRound().getPot());
					pokerGame.getPokerGameRound().getPlayer2().setCash(pokerGame.getPokerGameRound().getPlayer2().getCash() + pokerGame.getPokerGameRound().getPot());
				}else if (res.contains("Split pot")){
					log.info("NOBODY won and both will recieve - "+pokerGame.getPokerGameRound().getPot() / 2);
					pokerGame.getPokerGameRound().getPlayer2().setCash(pokerGame.getPokerGameRound().getPlayer2().getCash() + pokerGame.getPokerGameRound().getPot() / 2);
					pokerGame.getPokerGameRound().getPlayer1().setCash(pokerGame.getPokerGameRound().getPlayer1().getCash() + pokerGame.getPokerGameRound().getPot() / 2);
				}
				log.info("RESULT - " + pokerGame.getPokerGameRound().getResult());
				sendData(request, response, bet);
				return;
			}
			sendData(request, response, bet);
		}

		if(playerFolded){
			pokerGame.getPokerGameRound().setResult("Player Folded");
			log.info(ser.serialize(pokerGame));
			out.print(ser.serialize(pokerGame));
			out.flush();
			return;
		}
		
		if (userBet.contains("-1")){
			log.info("Player folded");
			partCounter = -1;
			playerFolded = true;
			sendData(request, response, bet);
		}
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//+++++++++++++++++++++++++++++++++++++++++++++END OF GAME PROCESSING+++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	}
	
	private void sendData(HttpServletRequest request, HttpServletResponse response, int bet)
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		JSONSerializer ser = new JSONSerializer();
		if((bet >= 0) && (bet != -1)){
			pokerGame.getPokerGameRound().setPlayer1Bet(bet);
			int money = pokerGame.getUser1Profile().getMoney();
			money -= bet;
			pokerGame.getUser1Profile().setMoney(money);
		}
		log.info(ser.serialize(pokerGame));
		out.print(ser.serialize(pokerGame));
		out.flush();
	}

	
	private void resetGame(HttpServletRequest request, HttpServletResponse response){
		JSONSerializer ser = new JSONSerializer();
		
		IPokerPlayer p1 = pokerGame.getPokerGameRound().getPlayer1();
		IPokerPlayer p2 = pokerGame.getPokerGameRound().getPlayer2();
		int sb1 = pokerGame.getPokerGameRound().getTable().getSmallBlind();
		int bb1 = pokerGame.getPokerGameRound().getTable().getBigBlind();
		int money1 = pokerGame.getUser1Profile().getMoney();
		int money2 = pokerGame.getPokerGameRound().getPlayer2().getCash();
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		pokerGame = new PokerGame();
		pokerGame.setComment("PreFlop");
		pokerGame.setId(new Random().nextInt());
		pokerGame.setUser1Profile(userProfile);
		pokerGame.setPokerGameRound(new PokerRound(p1, p2, sb1, bb1));
		dealer = !dealer;
		pokerGame.getPokerGameRound().setDealer(true);
		pokerGame.getPokerGameRound().setResult("none");
		pokerGame.getPokerGameRound().getPlayer1().setCash(money1);
		pokerGame.getPokerGameRound().getPlayer2().setCash(money2);
		pokerGame.getPokerGameRound().setPlayer1Bet(0);
		pokerGame.getPokerGameRound().initGame();
		log.info("game inited here - " + ser.serialize(pokerGame));
		partCounter = 0;
		request.getSession().setAttribute("pokerGame", pokerGame);
		request.getSession().setAttribute("userBet", 0);
		request.getSession().setAttribute("botBet", 0);
		Integer chips = money1;
		request.getSession().setAttribute("chips", chips);
	}
}
