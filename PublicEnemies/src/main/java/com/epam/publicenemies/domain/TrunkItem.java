package com.epam.publicenemies.domain;

public class TrunkItem {
	
	private Item item;
	private boolean wearing;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public boolean isWearing() {
		return wearing;
	}
	public void setWearing(boolean wearing) {
		this.wearing = wearing;
	}

	public TrunkItem(Item item) {
		wearing = false;
		this.item = item;
	}
	
	
}
