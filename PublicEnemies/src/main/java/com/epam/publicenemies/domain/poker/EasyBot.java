package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.publicenemies.web.casino.poker.PokerGame;

/**
 * @author Ostap Koziy
 */
public class EasyBot implements IPokerPlayer {

	public String name;
	public int cash;
	public boolean initiative = false;
	private PokerGame pokerGame;
	private PokerStats stats;
	private String avatar;
	
	
	
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
	
	
	
	
	
	public EasyBot(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	public String getName() {
		return name;
	}
	public int getCash() {
		return cash;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
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
		boolean isDryBoard = false;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);
		if(initiative){
			List<PokerCard> allCards = new ArrayList<PokerCard>();
			allCards.addAll(deck.getTable());
			allCards.add(hand.getCard1());
			allCards.add(hand.getCard2());
			isDryBoard = CombinationChecker.isDryBoard(allCards);
			
			if(isDryBoard){
				Random random = new Random();
				int val = random.nextInt(100);
				if(val <= 65){
					result = this.bet(pokerGame);
					return result;
				}
			}
			if((combo.getRank() == 2) && (combo.getCard3().getValue().getRank() >= 11)){
				result = this.bet(pokerGame);
				return result;
			}
			if(combo.getRank() > 2){
				result = this.bet(pokerGame);
				return result;
			}
			if(CombinationChecker.checkForFlushDraw(deck.getTable(), hand)){
				result = this.bet(pokerGame);
				return result;
			}
			if(CombinationChecker.checkForStraightDraw(deck.getTable(), hand)){
				result = this.bet(pokerGame);
				return result;
			}
			
			result = this.check(deck);
		}else if (!initiative){
			if(combo.getRank() >= 3){
				result = this.bet(pokerGame);
				return result;
			}
			if(CombinationChecker.checkForFlushDraw(deck.getTable(), hand)){
				result = this.bet(pokerGame);
				return result;
			}
			/*if(CombinationChecker.checkForStraightDraw(deck.getTable(), hand)){
				result = this.bet(pokerGame);
				return result;
			}*/

			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				return this.check(deck);
			}
			return this.fold();
		}
		
		return result;
	}
	
	private int makeMoveTurn(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		CombinationChecker cChecker = new CombinationChecker();
		PokerCombination combo = null;
		boolean isDryBoard = false;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);
		if(initiative){
			List<PokerCard> allCards = new ArrayList<PokerCard>();
			allCards.addAll(deck.getTable());
			allCards.add(hand.getCard1());
			allCards.add(hand.getCard2());
			isDryBoard = CombinationChecker.isDryBoard(allCards);
			
			if(isDryBoard){
				result = this.bet(pokerGame);
				return result;
			}
			if((combo.getRank() >= 3) && (true /*TPTK*/)){
				result = this.bet(pokerGame);
				return result;
			}
			
			result = this.check(deck);
		}else if (!initiative){
			
			if(combo.getRank() >= 3){
				result = this.bet(pokerGame);
				return result;
			}

			//if TPTK = call
			if(pokerGame.getPokerGameRound().getPlayer1Bet() == pokerGame.getPokerGameRound().getPlayer2Bet()){
				return this.check(deck);
			}
			return this.fold();
		}
		
		return result;
	}
	
	private int makeMoveRiver(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		CombinationChecker cChecker = new CombinationChecker();
		PokerCombination combo = null;
		combo = cChecker.checkForCombinations(deck.getTable(), hand);
		if(initiative){
			List<PokerCard> allCards = new ArrayList<PokerCard>();
			allCards.addAll(deck.getTable());
			allCards.add(hand.getCard1());
			allCards.add(hand.getCard2());

			if(combo.getRank() >= 4){
				result = this.bet(pokerGame);
				return result;
			}
			
			result = this.check(deck);
		
		}else if (!initiative){
			
			if(combo.getRank() >= 5){
				result = this.bet(pokerGame);
				return result;
			}

			if((combo.getRank() == 3) || (combo.getRank() == 4)){
				result = this.call(deck);
				return result;
			}
	/*		if(deck.getPlayer1Bet() == deck.getPlayer2Bet()){
				return this.check(deck);
			}*/
			return this.fold();
		}
		
		return result;
	}
	
	private int makeMovePreFlop(PokerTable deck, PokerHand hand,
			boolean isSmallBlind) throws FoldException {
		int result = 0;
		if (isSmallBlind){
			//top 30% of spectrum
			List<String> raiseCondition = new ArrayList<String>();
			raiseCondition.add("55+");
			raiseCondition.add("98s+");
			raiseCondition.add("A2s+");
			raiseCondition.add("A7o+");
			raiseCondition.add("T9o+");
			//bottom 30% of spectrum
			List<String> foldCondition = new ArrayList<String>();
			foldCondition.add("T5o-");
			foldCondition.add("J4o-");
			foldCondition.add("Q2o-");
			foldCondition.add("82s-");
			
			if(SpectrumAnalyzer.getInstance().inRange(hand, raiseCondition)){
				result = this.bet(pokerGame);
			}else if (SpectrumAnalyzer.getInstance().inRange(hand, foldCondition)){
				if (pokerGame.getPokerGameRound().getPlayer1Bet() - pokerGame.getPokerGameRound().getPlayer2Bet() == 0){
					result = this.check(deck);
				}else{
					this.fold();				
				}
		}else{
			this.setInitiative(false);
			result = this.call(deck);
			}	
		/*}else{
			//top 2-3% of spectrum
			List<String> triBetCondition = new ArrayList<String>();
			triBetCondition.add("TT+");
			triBetCondition.add("AKs+");
			List<String> callCondition = new ArrayList<String>();
			callCondition.add("44+");
			callCondition.add("K2s+");
			callCondition.add("87s+");
			callCondition.add("Q4s+");
			callCondition.add("A3o+");
			callCondition.add("J8o+");
			if(SpectrumAnalyzer.getInstance().inRange(hand, triBetCondition)){
				result = this.triBet(deck);
			}else if (SpectrumAnalyzer.getInstance().inRange(hand, callCondition)){
				result = this.call(deck);
			}else{
				if (deck.getPlayer1Bet() - deck.getPlayer2Bet() == 0){
					System.out.println("CHECK");
					result = this.check(deck);
				}else{
					System.out.println("FOLD");
					this.fold();
				}
			}*/
		}
		
		return result;
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
	
/*	private boolean countOdds(PokerTable deck){
		double potOdds = (deck.getPlayer1Bet() - deck.getPlayer2Bet())/(deck.getPlayer1Bet() + deck.getPlayer2Bet());
		double combinationOdds = 0.0;
		
		return potOdds < combinationOdds ? true : false ; 
	}*/
}
