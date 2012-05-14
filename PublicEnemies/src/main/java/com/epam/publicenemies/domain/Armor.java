package com.epam.publicenemies.domain;


/**
 * Armor object
 * 
 * @author Chetyrkin S.V.
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
	public Armor (int armorId, String armorName, String armorPicture, int armorPrice, int armorProtection) {
		super(armorId, armorName, armorPicture, armorPrice);
		this.armorProtection = armorProtection;
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