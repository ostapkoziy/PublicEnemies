package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @author Ostap Koziy
 */
public class PokerCombination {
	private PokerCard card1;
	private PokerCard card2;
	private PokerCard card3;
	private PokerCard card4;
	private PokerCard card5;
	private String name;
	private int rank;

	/*
	 * rank is the "value" of the combination. 1 - Kicker; 2 - Pair; 3 - Two
	 * Pais; 4 - Set; 5 - Street; 6 - Flush; 7 - Full House; 8 - Quads; 9 -
	 * StreetFlush;
	 */

	public PokerCombination(List<PokerCard> arg) {
		this.card1 = arg.get(0);
		this.card2 = arg.get(1);
		this.card3 = arg.get(2);
		this.card4 = arg.get(3);
		this.card5 = arg.get(4);
	}

	public PokerCombination() {

	}

	private PokerCard[] PRIVATE_VALUES = { card1, card2, card3, card4, card5 };

	public List<PokerCard> VALUES = Collections.unmodifiableList(Arrays
			.asList(PRIVATE_VALUES));

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokerCard getCard1() {
		return card1;
	}

	public PokerCard getCard2() {
		return card2;
	}

	public PokerCard getCard3() {
		return card3;
	}

	public PokerCard getCard4() {
		return card4;
	}

	public PokerCard getCard5() {
		return card5;
	}

	public void setCard1(PokerCard card1) {
		this.card1 = card1;
	}

	public void setCard2(PokerCard card2) {
		this.card2 = card2;
	}

	public void setCard3(PokerCard card3) {
		this.card3 = card3;
	}

	public void setCard4(PokerCard card4) {
		this.card4 = card4;
	}

	public void setCard5(PokerCard card5) {
		this.card5 = card5;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "" + card1 + " " + card2 + " " + card3 + " " + card4 + " "
				+ card5;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PokerCombination))
			return false;
		PokerCombination pc = (PokerCombination) obj;
		List<PokerCard> list1 = new ArrayList<PokerCard>();
		List<PokerCard> list2 = new ArrayList<PokerCard>();
		list1.add(card1);
		list1.add(card2);
		list1.add(card3);
		list1.add(card4);
		list1.add(card5);
		list2.add(card1);
		list2.add(card2);
		list2.add(card3);
		list2.add(card4);
		list2.add(card5);
		Collections.sort(list1, new PokerCardComparator());
		Collections.sort(list2, new PokerCardComparator());
		return list1.get(0).equals(list2.get(0))
				&& list1.get(1).equals(list2.get(1))
				&& list1.get(2).equals(list2.get(2))
				&& list1.get(3).equals(list2.get(3))
				&& list1.get(4).equals(list2.get(4));
	}

	public static PokerCombination compare(PokerCombination arg0,
			PokerCombination arg1) {
		int result = arg0.getRank() - arg1.getRank();
		if (result > 0) {
			return arg0;
		} else if (result < 0) {
			return arg1;
		} else {
			if ((arg0.rank == 1) || (arg0.rank == 5) || (arg0.rank == 6)
					|| (arg0.rank == 9)) { // no combination or straight or flush or straightflush - 5 kickers
				if (arg0.getCard1().getValue().getRank() > arg1.getCard1()
						.getValue().getRank()) {
					return arg0;
				} else if (arg0.getCard1().getValue().getRank() < arg1
						.getCard1().getValue().getRank()) {
					return arg1;
				} else {
					if (arg0.getCard2().getValue().getRank() > arg1.getCard2()
							.getValue().getRank()) {
						return arg0;
					} else if (arg0.getCard2().getValue().getRank() < arg1
							.getCard2().getValue().getRank()) {
						return arg1;
					} else {
						if (arg0.getCard3().getValue().getRank() > arg1
								.getCard3().getValue().getRank()) {
							return arg0;
						} else if (arg0.getCard3().getValue().getRank() < arg1
								.getCard3().getValue().getRank()) {
							return arg1;
						} else {
							if (arg0.getCard4().getValue().getRank() > arg1
									.getCard4().getValue().getRank()) {
								return arg0;
							} else if (arg0.getCard4().getValue().getRank() < arg1
									.getCard4().getValue().getRank()) {
								return arg1;
							} else {
								if (arg0.getCard5().getValue().getRank() > arg1
										.getCard5().getValue().getRank()) {
									return arg0;
								} else if (arg0.getCard5().getValue().getRank() < arg1
										.getCard5().getValue().getRank()) {
									return arg1;
								} else {
									return null;
								}
							}
						}
					}
				}
			}
			if (arg0.rank == 2) { // 1 pair - three kickers
				if (arg0.getCard3().getValue().getRank() > arg1.getCard3()
						.getValue().getRank()) {
					return arg0;
				} else if (arg0.getCard3().getValue().getRank() < arg1
						.getCard3().getValue().getRank()) {
					return arg1;
				} else {
					if (arg0.getCard4().getValue().getRank() > arg1.getCard4()
							.getValue().getRank()) {
						return arg0;
					} else if (arg0.getCard4().getValue().getRank() < arg1
							.getCard4().getValue().getRank()) {
						return arg1;
					} else {
						if (arg0.getCard5().getValue().getRank() > arg1
								.getCard5().getValue().getRank()) {
							return arg0;
						} else if (arg0.getCard5().getValue().getRank() < arg1
								.getCard5().getValue().getRank()) {
							return arg1;
						} else {
							return null;
						}
					}
				}
			} else if (arg0.rank == 4) { // set - 2 kickers
				if (arg0.getCard4().getValue().getRank() > arg1.getCard4()
						.getValue().getRank()) {
					return arg0;
				} else if (arg0.getCard4().getValue().getRank() < arg1
						.getCard4().getValue().getRank()) {
					return arg1;
				} else {
					if (arg0.getCard5().getValue().getRank() > arg1.getCard5()
							.getValue().getRank()) {
						return arg0;
					} else if (arg0.getCard5().getValue().getRank() < arg1
							.getCard5().getValue().getRank()) {
						return arg1;
					} else {
						return null;
					}
				}
			} else if ((arg0.rank == 3) || (arg0.rank == 8)) { // set - 1 kicker
				if (arg0.getCard5().getValue().getRank() > arg1.getCard5()
						.getValue().getRank()) {
					return arg0;
				} else if (arg0.getCard5().getValue().getRank() < arg1
						.getCard5().getValue().getRank()) {
					return arg1;
				} else {
					return null;
				}
			}
		}
		return null;
	}
}
