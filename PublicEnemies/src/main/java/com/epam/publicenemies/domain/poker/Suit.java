package com.epam.publicenemies.domain.poker;

public class Suit {
	private final String name;
	private Suit(String name) {this.name = name; }
	public String toString() {return name; }
	
	public static final Suit CLUBS = new Suit("c");
	public static final Suit DIAMONDS = new Suit("d");
	public static final Suit HEARTS = new Suit("h");
	public static final Suit SPADES = new Suit("s");
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Suit))
			return false;
		Suit suit = (Suit) obj;
		return suit.getName().equals(name);
	}
	public String getName() {
		return name;
	}
	
	
}
