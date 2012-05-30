package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class CombinationChecker {

	public PokerCombination checkForCombinations(List<PokerCard> cards,
			PokerHand playerCards) {
		PokerCombination test = null;
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(cards);
		allCards.add(playerCards.getCard1());
		allCards.add(playerCards.getCard2());
		Collections.sort(allCards, new PokerCardComparator());
		PokerCombination result = new PokerCombination();
		result.setName("Kicker - " + allCards.get(0).getValue());
		result.setRank(1);

		test = this.checkForStraightFlush(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkForQuads(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkForFullHouse(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkForFlush(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkForStraight(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkForSet(allCards);
		if (test != null) {
			return test;
		}
		test = this.checkFor2Pairs(allCards);
		if (test != null) {
			return test;
		}
		if (this.checkForPair(allCards) != null) {
			return this.checkForPair(allCards);
		}
		return result;
	}

	private PokerCombination checkForPair(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		PokerCombination result = new PokerCombination();
		boolean isPair = false;
		for (int i = 1; i < allCards.size(); i++) {
			if (allCards.get(i).getValue() == allCards.get(i - 1).getValue()) {
				result.setCard1(allCards.get(i - 1));
				result.setCard2(allCards.get(i));
				allCards.remove(i);
				allCards.remove(i - 1);
				isPair = true;
				break;
			}
		}
		if (isPair) {
			result.setCard3(allCards.get(0));
			result.setCard4(allCards.get(1));
			result.setCard5(allCards.get(2));
			result.setName("Pair of " + result.getCard1().getValue());
			result.setRank(2);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkFor2Pairs(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		PokerCombination result = new PokerCombination();
		boolean is2Pairs = false;
		int pairCount = 0;
		for (int i = 1; i < allCards.size(); i++) {
			if (allCards.get(i - 1).getValue() == allCards.get(i).getValue()) {
				result.setCard1(allCards.get(i - 1));
				result.setCard2(allCards.get(i));
				allCards.remove(i);
				allCards.remove(i - 1);
				pairCount++;
				break;
			}
		}

		for (int i = 1; i < allCards.size(); i++) {
			if (allCards.get(i - 1).getValue() == allCards.get(i).getValue()) {
				result.setCard3(allCards.get(i - 1));
				result.setCard4(allCards.get(i));
				allCards.remove(i);
				allCards.remove(i - 1);
				pairCount++;
				break;
			}
		}
		if (pairCount == 2) {
			is2Pairs = true;
		}

		if (is2Pairs) {
			result.setCard5(allCards.get(0));
			result.setName("2 pairs of " + result.getCard1().getValue()
					+ " and " + result.getCard3().getValue());
			result.setRank(3);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkForSet(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		PokerCombination result = new PokerCombination(allCards);
		boolean isSet = false;
		for (int i = 2; i < allCards.size(); i++) {
			if ((allCards.get(i).getValue() == allCards.get(i - 1).getValue())
					&& (allCards.get(i).getValue() == allCards.get(i - 2)
							.getValue())) {

				result.setCard1(allCards.get(i - 2));
				result.setCard2(allCards.get(i - 1));
				result.setCard3(allCards.get(i));
				allCards.remove(i);
				allCards.remove(i - 1);
				allCards.remove(i - 2);
				isSet = true;
				break;
			}
		}
		if (isSet) {
			result.setCard4(allCards.get(0));
			result.setCard5(allCards.get(1));
			result.setName("Set of " + result.getCard1().getValue());
			result.setRank(4);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkForStraight(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		List<PokerCard> list = new ArrayList<PokerCard>();
		list.addAll(arg);
		for(int i = 1; i < list.size(); i++){
			if(list.get(i).getValue() == list.get(i-1).getValue()){
				list.remove(i);		//excluding pairs
				i = i-1;
			}
		}
		PokerCombination result = new PokerCombination();
		allCards.addAll(list);
		boolean isStreet = false;
		for (int i = 0; i < allCards.size() - 4; i++) {
			if ((allCards.get(i).getValue().getRank() == allCards.get(i + 1)
					.getValue().getRank() + 1)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 2).getValue().getRank() + 2)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 3).getValue().getRank() + 3)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 4).getValue().getRank() + 4)) {
				result.setCard1(allCards.get(i));
				result.setCard2(allCards.get(i + 1));
				result.setCard3(allCards.get(i + 2));
				result.setCard4(allCards.get(i + 3));
				result.setCard5(allCards.get(i + 4));
				isStreet = true;
				break;
			}
		}
		
		//case of A-5 street
		for (int i = allCards.size() - 1; i > 0; i--) {
			if ((allCards.get(i).getValue().getRank() == 2) && 
					(allCards.get(i - 1).getValue().getRank() == 3) && 
					(allCards.get(i - 2).getValue().getRank() == 4) &&
					(allCards.get(i - 3).getValue().getRank() == 5) &&
					(allCards.get(0).getValue().getRank() == 14)) {
				result.setCard1(allCards.get(i - 3));
				result.setCard2(allCards.get(i - 2));
				result.setCard3(allCards.get(i - 1));
				result.setCard4(allCards.get(i));
				result.setCard5(allCards.get(0));
				
				isStreet = true;
				break;
			}
		}

		if (isStreet) {
			result.setName(result.getCard1().getValue() + " high straight");
			result.setRank(5);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkForFlush(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		
		Set<Suit> suits = new HashSet<Suit>();
		for(PokerCard i : allCards){
			suits.add(i.getSuit());		//get all suits
		}
		
		PokerCombination result = new PokerCombination();
		boolean isFlush = false;
		int suitCounter = 0;
		for (Suit i : suits){
			for(PokerCard j : allCards){
				if (j.getSuit() == i){
					suitCounter++;
				}
			}
			if(suitCounter >= 5){
				List<PokerCard> temp = new ArrayList<PokerCard>();
				for(PokerCard c : allCards){
					if (c.getSuit() == i){
						temp.add(c);
					}
				}
				result.setCard1(temp.get(0));
				result.setCard2(temp.get(1));
				result.setCard3(temp.get(2));
				result.setCard4(temp.get(3));
				result.setCard5(temp.get(4));
				isFlush = true;
				break;
			}else{
				suitCounter = 0;
			}
				
		}
		if (isFlush) {
			result.setName(result.getCard1().getValue()+" high flush ");
			result.setRank(6);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkForFullHouse(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		List<PokerCard> temp = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		temp.addAll(arg);
		boolean isFull = false;
		boolean isSet = false;
		PokerCombination result = new PokerCombination();
		PokerCombination setResult = new PokerCombination();
		
		setResult = this.checkForSet(allCards);
		if(setResult != null){
			result.setCard1(setResult.getCard1());
			result.setCard2(setResult.getCard2());
			result.setCard3(setResult.getCard3());
			temp.remove(setResult.getCard1());
			temp.remove(setResult.getCard2());
			temp.remove(setResult.getCard3());
			isSet = true;
		}
		if(isSet){
			for (int i = 1; i < temp.size(); i++) {
				if (temp.get(i).getValue() == temp.get(i - 1).getValue()) {
					result.setCard4(temp.get(i - 1));
					result.setCard5(temp.get(i));
					isFull = true;
					break;
				}
			}
		}
		if (isFull) {
			result.setName("Full House of "+result.getCard1().getValue()+
						" and "+result.getCard4().getValue());
			result.setRank(7);
		} else {
			return null;
		}
		return result;
	}

	private PokerCombination checkForQuads(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		PokerCombination result = new PokerCombination();
		boolean isQuads = false;
		for (int i = 0; i < allCards.size() - 3; i++) {
			if ((allCards.get(i).getValue() == allCards.get(i+1).getValue()) &&
					(allCards.get(i).getValue() == allCards.get(i+2).getValue()) &&
					(allCards.get(i).getValue() == allCards.get(i+3).getValue())){ 
				result.setCard1(allCards.get(i));
				result.setCard2(allCards.get(i + 1));
				result.setCard3(allCards.get(i + 2));
				result.setCard4(allCards.get(i + 3));
				allCards.remove(i + 3);
				allCards.remove(i + 2);
				allCards.remove(i + 1);
				allCards.remove(i);
				result.setCard5(allCards.get(0));
				isQuads = true;
			}
		}
				
		if (isQuads) {
			result.setName("Quads of "+result.getCard1().getValue());
			result.setRank(8);
		} else {
			return null;
		}
		return result;
	}


	private PokerCombination checkForStraightFlush(List<PokerCard> arg) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(arg);
		PokerCombination result = new PokerCombination();
		PokerCombination straight = new PokerCombination();
		PokerCombination flush = new PokerCombination();
		boolean isStraightFlush = false;
		
		straight = this.checkForStraight(allCards);
		flush = this.checkForFlush(allCards);
		
		if((straight != null) && (flush != null)){
			if(straight.equals(flush)){
				result = straight;
				isStraightFlush = true;
			}
		}
			
		if (isStraightFlush) {
			result.setName(result.getCard1().getValue()+" high straightflush");
			result.setRank(9);
		} else {
			return null;
		}
		return result;
	}

	public static boolean checkForFlushDraw(List<PokerCard> cards,
			PokerHand playerCards) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(cards);
		allCards.add(playerCards.getCard1());
		allCards.add(playerCards.getCard2());
		
		Set<Suit> suits = new HashSet<Suit>();
		for(PokerCard i : allCards){
			suits.add(i.getSuit());		//get all suits
		}
		
		boolean isFlushDraw = false;
		int suitCounter = 0;
		for (Suit i : suits){
			for(PokerCard j : allCards){
				if (j.getSuit() == i){
					suitCounter++;
				}
			}
			if(suitCounter >= 4){
				isFlushDraw = true;
			}else{
				suitCounter = 0;
			}		
		}
		return isFlushDraw;
	}
	
	public static boolean checkForStraightDraw(List<PokerCard> cards,
			PokerHand playerCards) {
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(cards);
		allCards.add(playerCards.getCard1());
		allCards.add(playerCards.getCard2());
		boolean isStraightDraw = false;
		
		for(int i = 1; i < allCards.size(); i++){
			if(allCards.get(i).getValue() == allCards.get(i-1).getValue()){
				allCards.remove(i);		//excluding pairs
				i = i-1;
			}
		}
		for (int i = 0; i < allCards.size() - 4; i++) {
			if ((allCards.get(i).getValue().getRank() == allCards.get(i + 1)
					.getValue().getRank() + 1)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 2).getValue().getRank() + 2)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 3).getValue().getRank() + 3)) {
				isStraightDraw = true;
				break;
			}
		}
		
		//case of A-5 street
		for (int i = allCards.size() - 1; i > 0; i--) {
			if ((allCards.get(i).getValue().getRank() == 2) && 
					(allCards.get(i - 1).getValue().getRank() == 3) && 
					(allCards.get(i - 2).getValue().getRank() == 4) &&
					(allCards.get(i - 3).getValue().getRank() == 5)) {
				
				isStraightDraw = true;
				break;
			}
			if ((allCards.get(i - 1).getValue().getRank() == 3) && 
					(allCards.get(i - 2).getValue().getRank() == 4) &&
					(allCards.get(i - 3).getValue().getRank() == 5) &&
					(allCards.get(0).getValue().getRank() == 14)) {
					
				isStraightDraw = true;
				break;
			}
		}
		return isStraightDraw;
	}
	
	public static boolean isDryBoard(List<PokerCard> cards){
	
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(cards);
		
		boolean result = false;
		Set<Suit> suits = new HashSet<Suit>();
		for(PokerCard i : allCards){
			suits.add(i.getSuit());		//get all suits
		}
		boolean noSuits = false;
		if(suits.size() == 3){
			noSuits = true;
		}
		boolean isStraightDraw = false;
		
		for(int i = 1; i < allCards.size(); i++){
			if(allCards.get(i).getValue() == allCards.get(i-1).getValue()){
				allCards.remove(i);		//excluding pairs
				i = i-1;
			}
		}
		for (int i = 0; i < allCards.size() - 4; i++) {
			if ((allCards.get(i).getValue().getRank() == allCards.get(i + 1)
					.getValue().getRank() + 1)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 2).getValue().getRank() + 2)
					&& (allCards.get(i).getValue().getRank() == allCards
							.get(i + 3).getValue().getRank() + 3)) {
				isStraightDraw = true;
				break;
			}
		}
		
		//case of A-5 street
		for (int i = allCards.size() - 1; i > 0; i--) {
			if ((allCards.get(i).getValue().getRank() == 2) && 
					(allCards.get(i - 1).getValue().getRank() == 3) && 
					(allCards.get(i - 2).getValue().getRank() == 4) &&
					(allCards.get(i - 3).getValue().getRank() == 5)) {
				
				isStraightDraw = true;
				break;
			}
			if ((allCards.get(i - 1).getValue().getRank() == 3) && 
					(allCards.get(i - 2).getValue().getRank() == 4) &&
					(allCards.get(i - 3).getValue().getRank() == 5) &&
					(allCards.get(0).getValue().getRank() == 14)) {
					
				isStraightDraw = true;
				break;
			}
		}
		if((noSuits) && (!isStraightDraw)){
			result = true;
		}
		
		return result;
	}
	
	public boolean isTptk(List<PokerCard> table, PokerHand player){
		boolean result = false;
		CombinationChecker cChecker = new CombinationChecker();
		List<PokerCard> allCards = new ArrayList<PokerCard>();
		allCards.addAll(table);
		allCards.add(player.getCard1());
		allCards.add(player.getCard2());
		PokerCombination pc = cChecker.checkForCombinations(table, player);
		if(pc.getRank() == 2){
			//pair
		}
		if(pc.getCard1().equals(player.getCard1())){
			if(pc.getCard3().equals(player.getCard2())){
				result = true;
			}
		}else if(pc.getCard1().equals(player.getCard2())){
			if(pc.getCard3().equals(player.getCard1())){
				result = true;
			}
		}		

		return result;
	}
}
