package com.epam.publicenemies.domain;

public abstract class Item {
	private String itemName;
	private int itemPrice;
	private int itemId;
	private String itemPicture;
	
	public Item (int itemId, String itemName, String itemPicture, int itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPicture = itemPicture;
		this.itemPrice = itemPrice;
	}
	
	public Item() {
		itemName = new String();
		itemPicture = new String();
		itemId = 0;
		itemPrice = 0;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemPicture() {
		return itemPicture;
	}
	public void setItemPicture(String itemPicture) {
		this.itemPicture = itemPicture;
	}
	
	
	

}
