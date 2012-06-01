package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.publicenemies.web.casino.poker.PokerGame;

/**
 * @author Ostap Koziy
 */
public class HardBot implements IPokerPlayer {

	public String name;
	public int cash;
	public boolean initiative = false;
	private PokerGame pokerGame;
	private PokerStats stats;
	public String avatar;
	
	
	
	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public PokerStats getStats() {
		return stats;
	}



	public void setStats(PokerStats stats) {
		this.stats = stats;
	}



	public HardBot(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	
	
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCash() {
		return this.cash;
	}

	@Override
	public void setCash(int i) {
		this.cash = i;

	}

	@Override
	public int makeMove(PokerGame game) throws FoldException {
		int result = 0;
		pokerGame = game;
		PokerTable deck = game.getPokerGameRound().getTable();
		PokerHand hand = game.getPokerGameRound().getPlayer2Hand();
		boolean isSmallBlind  = !game.getPokerGameRound().isDealer() ;
		if(isPreFlop(deck)){		//PREFLOP
			result = this.makeMovePreFlop(deck, hand, isSmallBlind);
		} else if (isFlop(deck)){	//FLOP
			try{
				result = this.makeMoveFlop(deck, hand, isSmallBlind);
			}catch(FoldException e){
				throw new FoldException();
			}
		} else if (isTurn(deck)){	//TURN
			try{
				result = this.makeMoveTurn(deck, hand, isSmallBlind);
			}catch(FoldException e){
				throw new FoldException();
			}
		} else if (isRiver(deck)){	//RIVER
			try{
				result = this.makeMoveRiver(deck, hand, isSmallBlind);
			}catch(FoldException e){
				throw new FoldException();
			}
		}
			
	
		return result;
	}

	private int makeMoveFlop(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		CombinationChecker cChecker = new CombinationChecker();
		PokerCombination combo = null;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);

		if((stats.getVpip() < 10) && (combo.getRank() > 4)){
			result = this.bet(pokerGame);
			return result;
		}
		if((stats.getVpip() < 25) && (combo.getRank() > 3)){
			result = this.bet(pokerGame);
			return result;
		}
		if((stats.getVpip() < 100) && (combo.getRank() > 2)){
			result = this.bet(pokerGame);
			return result;
		}
		
		result = this.call(deck);
		
		return result;
	}
	
	private int makeMoveTurn(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		CombinationChecker cChecker = new CombinationChecker();
		PokerCombination combo = null;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);
		if(stats.getPfr() < 8){
			if(combo.getRank() > 1){
				this.call(deck);
			}else if(combo.getRank() >= 3){
				this.triBet(pokerGame);
			}
		}else if(stats.getPfr() < 20){
			this.bet(pokerGame);
		}else if(stats.getPfr() < 100){
			this.triBet(pokerGame);
		}
		
		return call(deck);
	}
	
	private int makeMoveRiver(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		CombinationChecker cChecker = new CombinationChecker();
		PokerCombination combo = null;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);
		if((stats.get3bet() < 10) || (stats.getf3bet() > 40)){
			this.triBet(pokerGame);
		}
		else{
			this.call(deck);
		}
		return result;
	}
	
	private int makeMovePreFlop(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		Random random = new Random();
		int temp = random.nextInt(100);
		
		if(temp <= 10){
			return bet(pokerGame);
		}else if(temp <= 80){
			return call(deck);
		}else{
			return fold();
		}

	}
	

	private int call(PokerTable deck) {
		int toCall = pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet();
		if(toCall > 0){
			if(toCall > cash){
				this.allIn();
			}
			this.cash -=toCall;
		}
		else if (toCall == 0){
			System.out.println("Check!");
		}
		return toCall;
	}

	private int check(PokerTable deck) throws FoldException {
		if ( pokerGame.getPokerGameRound().getPlayer1Bet() ==  pokerGame.getPokerGameRound().getPlayer2Bet()){
			return 0;
		}
		throw new FoldException();
	}

	private int allIn() {
		return this.cash;
	}

	private int bet(PokerGame game) {
		this.setInitiative(true);	//initiative +
		int raise = (game.getPokerGameRound().getPlayer1Bet() - game.getPokerGameRound().getPlayer2Bet()) * 3;
		if(cash > raise){
			this.cash -= raise;
		}else{
			this.allIn();
		}
		return raise;
	}
	
	private int triBet(PokerGame game){
		this.setInitiative(true);	//initiative +
		int raise = (game.getPokerGameRound().getPlayer1Bet() - game.getPokerGameRound().getPlayer2Bet()) * 9;
		return raise;
	}

	private int fold() throws FoldException {
		this.setInitiative(false);
		throw new FoldException();
	}
	public void setInitiative(boolean initiative) {
		this.initiative = initiative;
	}
	
	private boolean isFlop(PokerTable deck){
		boolean result = false;
		if((deck.getFlop() != null) && (deck.getTurn() == null)){
			result = true;
		}
		return result;
	}
	private boolean isTurn(PokerTable deck){
		boolean result = false;
		if((deck.getTurn() != null) && (deck.getRiver() == null)){
			result = true;
		}
		return result;
	}
	private boolean isRiver(PokerTable deck){
		boolean result = false;
		if(deck.getRiver() != null){
			result = true;
		}
		return result;
	}
	private boolean isPreFlop(PokerTable deck){
		boolean result = false;
		if(deck.getFlop().size() == 0){
			result = true;
		}
		return result;
	}
	
}
