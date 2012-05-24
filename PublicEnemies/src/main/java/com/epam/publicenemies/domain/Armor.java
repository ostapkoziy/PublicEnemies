package com.epam.publicenemies.domain;


/**
 * Armor object
 * 
 * @author Chetyrkin S.V.
 * Updated Chetyrkin S.V. 17.05.2012 - added getters and setters for basic object parameters
 * 
 */
public class Armor extends Item {

	private int armorProtection;
	
	/**
	 * Default armor constructor
	 */
	public Armor () {
		super();
		armorProtection = 0;
	}
	
	/**
	 * Non-default constructor
	 * @param armorId - id of armor
	 * @param armorName - name of armor
	 * @param armorPicture - picture of armor
	 * @param armorPrice - price of armor
	 * @param armorProtection - protection of armor
	 */
	public Armor (int armorId, String armorName, String armorPicture, int armorPrice, int armorProtection, String description) {
		super(armorId, armorName, armorPicture, armorPrice, description);
		this.armorProtection = armorProtection;
	}
	
	/**
	 * Get Armor name
	 * @return - Armor name
	 */
	public String getArmorName() {
		return super.getItemName();
	}
	
	/**
	 * Set Armor name
	 * @param armorName - Armor name
	 */
	public void setArmorName(String armorName) {
		super.setItemName(armorName);
	}
	
	/**
	 * Get id of Armor
	 * @return - id of Armor
	 */
	public int getArmorId() {
		return super.getItemId();
	}
	
	/**
	 * Set id of Armor
	 * @param armorId - id of Armor
	 */
	public void setArmorId(int armorId) {
		super.setItemId(armorId);
	}
	
	/**
	 * Get price of Armor
	 * @return - price of Armor
	 */
	public int getArmorPrice() {
		return super.getItemPrice();
	}
	
	/**
	 * Set price of Armor
	 * @param armorPrice - price of Armor
	 */
	public void setArmorPrice(int armorPrice) {
		super.setItemPrice(armorPrice);
	}
	
	/**
	 * Get picture of Armor
	 * @return - picture of Armor
	 */
	public String getArmorPicture() {
		return super.getItemPicture();
	}
	
	/**
	 * Set picture of Armor
	 * @param armorPicture - picture of Armor
	 */
	public void setArmorPicture(String armorPicture) {
		super.setItemPicture(armorPicture);
	}	
	
	/**
	 * Get Armor protection
	 * @return armor protection
	 */
	public int getArmorProtection() {
		return armorProtection;
	}
	
	/**
	 * Set Armor protection
	 * @param armorProtection - protection of armor
	 */
	public void setArmorProtection(int armorProtection) {
		this.armorProtection = armorProtection;
	}

}