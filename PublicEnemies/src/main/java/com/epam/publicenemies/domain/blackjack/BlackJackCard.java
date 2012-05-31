package com.epam.publicenemies.domain.blackjack;

/**
 * @author Danylo_Batyuk
 */

public class BlackJackCard {
	public enum Rank {
		TWO(2,"2"), THREE(3,"3"), FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"), EIGHT(8,"8"), NINE(9,"9"), TEN(
				10,"T"), JACK(10,"J"), QUEEN(10,"Q"), KING(10,"K"), ACE(11,"A");
		private final int value;
		private final String name;

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		private Rank(int value, String name) {
			this.value = value;
			this.name = name;
		}
		
	}

	public enum Suit {
		CLUBS("c"), DIAMONDS("d"), HEARTS("h"), SPADES("s");

		private final String name;

		public String getName() {
			return name;
		}

		private Suit(String name) {
			this.name = name;
		}
	}

	private final Rank rank;
	private final Suit suit;
	private final String image;

	public BlackJackCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.image = "img/cards/"+toString()+".png";
	}

	public Rank rank() {
		return rank;
	}

	public Suit suit() {
		return suit;
	}

	public String image() {
		return image;
	}

	public String toString() {		
		return rank.getName() + suit.getName();
	}

}