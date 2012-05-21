package com.epam.publicenemies.web.casino.poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Value {
	private final String name;
	private final int rank;
	
	private Value(String name) {
		this.name = name;
		if (name == "T"){
			this.rank = 10;
		}else if (name == "J"){
			this.rank = 11;
		}
		else if (name == "Q"){
			this.rank = 12;
		}
		else if (name == "K"){
			this.rank = 13;
		}
		else if (name == "A"){
			this.rank = 14;
		}else{
			this.rank = Integer.valueOf(name);
		}
	}

	public String toString() {
		return name;
	}

	public static final Value TWO = new Value("2");
	public static final Value THREE = new Value("3");
	public static final Value FOUR = new Value("4");
	public static final Value FIVE = new Value("5");
	public static final Value SIX = new Value("6");
	public static final Value SEVEN = new Value("7");
	public static final Value EIGHT = new Value("8");
	public static final Value NINE = new Value("9");
	public static final Value TEN = new Value("T");
	public static final Value JACK = new Value("J");
	public static final Value QUEEN = new Value("Q");
	public static final Value KING = new Value("K");
	public static final Value ACE = new Value("A");

	private static final Value[] PRIVATE_VALUES = { TWO, THREE, FOUR, FIVE,
			SIX, SEVEN, NINE, TEN, JACK, QUEEN, KING, ACE };

	public static final List<Value> VALUES = Collections.unmodifiableList(Arrays
			.asList(PRIVATE_VALUES));

	public int getRank(){
		return this.rank;
	}
	

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Value))
			return false;
		Value val = (Value) obj;
		return val.getName().equals(name);
	}
	
	
}
