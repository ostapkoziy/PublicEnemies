package com.epam.publicenemies.web.casino.poker;

public class PokerHand {
	private PokerCard card1;
	private PokerCard card2;
	
	public PokerHand(PokerCard card1, PokerCard card2){
		this.card1 = card1;
		this.card2 = card2;
	}

	public PokerCard getCard1() {
		return card1;
	}

	public PokerCard getCard2() {
		return card2;
	}

	@Override
	public String toString() {
		return ""+getCard1() + " "
				+ getCard2();
	}
	
	public String getNotation(){
		String result = "";
		boolean isPair = false;
		if(card1.getValue().getRank() > card2.getValue().getRank()){
			result += card1.getValue();
			result += card2.getValue();
		}else if(card1.getValue().getRank() < card2.getValue().getRank()){
			result += card2.getValue();
			result += card1.getValue();
		}else if(card1.getValue().getRank() == card2.getValue().getRank()){
			result += card1.getValue();
			result += card1.getValue();
			isPair = true;
		}
		
		if((card1.getSuit() == card2.getSuit()) && (!isPair)){
			result += "s";
		}else if((card1.getSuit() != card2.getSuit()) && (!isPair)){
			result += "o";
		}
		return result;
	}
}
