package com.epam.publicenemies.domain;

/**
 * Basic item object
 * 
 * @author Chetyrkin S.V. 14.05.2012
 * 
 * */

public abstract class Item {
	private String itemName;
	private int itemPrice;
	private int itemId;
	private String itemPicture;
	
	/**
	 * Item non-default constructor
	 * @param itemId - id of item
	 * @param itemName - name of item
	 * @param itemPicture - path to picture
	 * @param itemPrice - item price
	 */
	public Item (int itemId, String itemName, String itemPicture, int itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPicture = itemPicture;
		this.itemPrice = itemPrice;
	}
	/**
	 * Item default constructor
	 */
	public Item() {
		itemName = new String();
		itemPicture = new String();
		itemId = 0;
		itemPrice = 0;
	}
	/**
	 * Get name of item
	 * @return name of item
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Set name of item
	 * @param itemName - name of item
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * Get item price
	 * @return item price
	 */
	public int getItemPrice() {
		return itemPrice;
	}
	
	/**
	 * Set price of item
	 * @param itemprice - price of item
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Get item id
	 * @return  item id
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Set id of item
	 * @param itemId - id of item
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * Get item picture
	 * @return item picture
	 */
	public String getItemPicture() {
		return itemPicture;
	}

	/**
	 * Set picture of item
	 * @param itemPicture - picture of item
	 */
	public void setItemPicture(String itemPicture) {
		this.itemPicture = itemPicture;
	}

}
