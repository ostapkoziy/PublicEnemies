package com.epam.publicenemies.domain;

/**
 * Weapon object
 * @author Chetyrkin S.V. 
 *
 */
public class Weapon extends Item {

	private int hitPoints;
	private boolean weaponType;
	
	/**
	 * Non-default Weapon constructor
	 * @param id - Weapon id
	 * @param name - Weapon name
	 * @param hitPoints - Weapon hit points
	 * @param picture - Weapon picture
	 * @param weaponType - type of Weapon
	 * @param price - Weapon price
	 */
	public Weapon (int id, String name, int hitPoints, String picture, boolean weaponType, int price){
		super(id, name, picture, price);
		this.hitPoints = hitPoints;
		this.weaponType = weaponType;		
	}
	
	/**
	 * Default Weapon constructor
	 */
	public Weapon(){
		super();
		hitPoints = 0;
		weaponType = false;
	}
	
	/**
	 * Get Weapon hit points
	 * @return Weapon hit points
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Set Weapon hit points
	 * @param hitPoints - Weapon hit points
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	/**
	 * Get Weapon type
	 * @return Weapon type
	 */
	public boolean isWeaponType() {
		return weaponType;
	}

	/**
	 * Set Weapon type
	 * @param weaponType - Weapon type
	 */
	public void setWeaponType(boolean weaponType) {
		this.weaponType = weaponType;
	}
	
}