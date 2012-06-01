package com.epam.publicenemies.domain.poker;

/**
 * @author Ostap Koziy
 */
public class PokerCard {
	private Suit suit;
	private Value value;
	private boolean used;
	private  String path;
		
	public PokerCard(Suit suit, Value value, boolean used) {
		this.suit = suit;
		this.value = value;
		this.used = used;
		this.path = "img/cards/"+this.toString()+".png";
	}
	
	@Override
	public String toString() {
		return ""+value+""+suit;
	}


	public Suit getSuit() {
		return suit;
	}
	public Value getValue() {
		return value;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PokerCard))
			return false;
		PokerCard pc = (PokerCard) obj;
		return pc.getValue().equals(value) && pc.getSuit().equals(suit);
	}

	
}
