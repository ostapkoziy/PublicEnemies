package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * @author Ostap Koziy
 */
public class PokerRound {
	private Logger log = Logger.getLogger(PokerRound.class);
	
	private PokerHand player1Hand = null;
	private PokerHand player2Hand = null;
	private CardDeck deck = CardDeck.getInstance();
	private PokerTable table = new PokerTable();
	private int pot;
	private IPokerPlayer player1;
	private IPokerPlayer player2;
	private int player1Bet;
	private int player2Bet;
	private CombinationChecker combinationChecker = new CombinationChecker();
	private PokerCombination player1Combination;
	private PokerCombination player2Combination;
	private boolean dealer = false;	// TRUE if player1 is dealer,
								   // FALSE if player2 is dealer
	private boolean gameFinished = false; // fold flag
	public boolean move = true; //TRUE if player1 has to make move 
	private String result;
	
	public PokerRound(IPokerPlayer arg1, IPokerPlayer arg2, int sb, int bb) {
		this.player1 = arg1;
		this.player2 = arg2;
		table.setSmallBlind(sb);
		table.setBigBlind(bb);
		pot = 0;
		result = "none";
	}
	
	public int getPlayer1Bet() {
		return player1Bet;
	}
	public int getPlayer2Bet() {
		return player2Bet;
	}
	public void setPlayer1Bet(int player1Bet) {
		this.player1Bet = player1Bet;
	}
	public void setPlayer2Bet(int player2Bet) {
		this.player2Bet = player2Bet;
	}
	public void initGame(){
		List<PokerHand> result = new ArrayList<PokerHand>();
		deck.shuffleDeck(); // shuffle the deck
		gameFinished = false; // no one folded yet
		PokerCard card1 = null;
		PokerCard card2 = null;

		card1 = this.getUniqueCard();
		card2 = this.getUniqueCard();
		player1Hand = new PokerHand(card1, card2);
		card1 = null;
		card2 = null;
		card1 = this.getUniqueCard();
		card2 = this.getUniqueCard();
		player2Hand = new PokerHand(card1, card2);
		result.add(player1Hand);
		result.add(player2Hand);
		
		if (dealer) {
			player1.setCash(player1.getCash() - table.getBigBlind());
			player2.setCash(player2.getCash() - table.getSmallBlind());
			this.setPlayer1Bet(table.getBigBlind());
			this.setPlayer2Bet(table.getSmallBlind());
		} else {
			player1.setCash(player1.getCash() - table.getSmallBlind());
			player2.setCash(player2.getCash() - table.getBigBlind());
			this.setPlayer1Bet(table.getSmallBlind());
			this.setPlayer2Bet(table.getBigBlind());
		}
		log.info("PokerRound player1bet - " + getPlayer1Bet());
		log.info("PokerRound player2bet - " + getPlayer2Bet());
		pot += player1Bet;
		pot += player2Bet;
	}

	public List<PokerCard> flop(){
		PokerCard card1, card2, card3;
		card1 = this.getUniqueCard();
		card2 = this.getUniqueCard();
		card3 = this.getUniqueCard();
		List<PokerCard> flop = new ArrayList<PokerCard>();
		flop.add(card1);
		flop.add(card2);
		flop.add(card3);
		table.setFlop(flop);
		player1Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer1Hand());
		player2Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer2Hand());
		
		return flop;
	}
	
	public PokerCard turn() {
		PokerCard card1;
		card1 = this.getUniqueCard();
		table.setTurn(card1);
		player1Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer1Hand());
		player2Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer2Hand());
		return card1;
	}

	public PokerCard river() {
		PokerCard card1;
		card1 = this.getUniqueCard();
		table.setRiver(card1);
		player1Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer1Hand());
		player2Combination = getCombinationChecker().checkForCombinations(getTable().getTable(), getPlayer2Hand());
		return card1;
	}
	
private PokerCard getUniqueCard() {
		PokerCard result = null;
		Random random = new Random();
		while (result == null) {
			int num = random.nextInt(deck.getDeck().size());
			if (!deck.getDeck().get(num).isUsed()) {
				result = deck.getDeck().get(num); // possible fail
				deck.getDeck().get(num).setUsed(true);
			} else {
				continue;
			}
		}
		return result;
	}
	
	public String displayResults() {
	//	if(!gameFinished){
		log.info("player1combo - " + player1Combination.getName());
		log.info("player2combo - " + player2Combination.getName());
			try{
				if (PokerCombination.compare(player1Combination, player2Combination) == player1Combination){
					result = player1.getName()+" won with "+ player1Combination.getName();
				}else if(PokerCombination.compare(player1Combination, player2Combination) == player2Combination){
					result = player2.getName()+" won with "+ player2Combination.getName();
				}
			}catch (NullPointerException e){
				result = "Split pot";
				return result;
			}

		return result;
	}


	/*public int getSbMove() {
	int bet = 0;
	if(dealer){
		try {
			bet = player2.makeMove(table, player2Hand, dealer);
		} catch (FoldException e) {
			System.out.println(player2.getName()+" FOLDED!");
			gameFinished = true;
			return -1;
		}
		table.setPlayer2Bet(table.getPlayer2Bet() + bet);
	}else{
		try {
			bet = player1.makeMove(table, player2Hand, dealer);
		} catch (FoldException e) {
			System.out.println(player1.getName()+" FOLDED!");
			gameFinished = true;
			return -1;
		}
		table.setPlayer1Bet(table.getPlayer1Bet() + bet);
	}
	return bet;
}

public int getBbMove() {
	int bet = 0;
	if(dealer){
		try {
			bet = player1.makeMove(table, player2Hand, dealer);
		} catch (FoldException e) {
			System.out.println(player1.getName()+" FOLDED!");
			gameFinished = true;
			return -1;
		}
	}else{
		try {
			bet = player2.makeMove(table, player2Hand, dealer);
		} catch (FoldException e) {
			System.out.println(player2.getName()+" FOLDED!");
			gameFinished = true;
			return -1;
		}
	}
	return bet;
}

public void getMoves(){
	int result, count = 0;
	do{
		result = this.getSbMove();
		if(result < 0){
			return;
		}
		if((table.getPlayer1Bet() == table.getPlayer2Bet()) && (count > 0)){
			return;
		}
		result = this.getBbMove();
		if(result < 0){
			return;
		}
		count ++;
	}while(table.getPlayer1Bet() != table.getPlayer2Bet());
	
}

public void preflop() {

	this.getMoves();
	
}





public void showDown() {
	System.out.println("SHOWDOWN");

}*/

	public IPokerPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(IPokerPlayer player1) {
		this.player1 = player1;
	}

	public IPokerPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(IPokerPlayer player2) {
		this.player2 = player2;
	}

	public PokerHand getPlayer1Hand() {
		return player1Hand;
	}

	public void setPlayer1Hand(PokerHand player1Hand) {
		this.player1Hand = player1Hand;
	}

	public PokerHand getPlayer2Hand() {
		return player2Hand;
	}

	public void setPlayer2Hand(PokerHand player2Hand) {
		this.player2Hand = player2Hand;
	}

	public CardDeck getDeck() {
		return deck;
	}

	public void setDeck(CardDeck deck) {
		this.deck = deck;
	}

	public PokerTable getTable() {
		return table;
	}

	public void setTable(PokerTable table) {
		this.table = table;
	}

	public CombinationChecker getCombinationChecker() {
		return combinationChecker;
	}

	public void setCombinationChecker(CombinationChecker combinationChecker) {
		this.combinationChecker = combinationChecker;
	}

	public PokerCombination getPlayer1Combination() {
		return player1Combination;
	}

	public void setPlayer1Combination(PokerCombination player1Combination) {
		this.player1Combination = player1Combination;
	}

	public PokerCombination getPlayer2Combination() {
		return player2Combination;
	}

	public void setPlayer2Combination(PokerCombination player2Combination) {
		this.player2Combination = player2Combination;
	}

	public boolean isDealer() {
		return dealer;
	}

	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPot() {
		return pot;
	}

	public void setPot(int pot) {
		this.pot = pot;
	}
	
	
}
