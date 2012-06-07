package com.epam.publicenemies.domain;

/**
 * Weapon object
 * 
 * @author Chetyrkin S.V. 
 * Updated Chetyrkin S.V. 17.05.2012 - added getters and setters for basic object parameters
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
	public Weapon (int id, String name, int hitPoints, String picture, boolean weaponType, int price, String description){
		super(id, name, picture, price, description);
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
	 * Get Weapon name
	 * @return - Weapon name
	 */
	public String getWeaponName() {
		return super.getItemName();
	}
	
	/**
	 * Get id of weapon
	 * @return - id of Weapon
	 */
	public int getWeaponId() {
		return super.getItemId();
	}
	
	/**
	 * Get price of Weapon 
	 * @return - price of Weapon
	 */
	public int getWeaponPrice() {
		return super.getItemPrice();
	}
	
	/**
	 * Get picture of Weapon
	 * @return - picture of Weapon
	 */
	public String getWeaponPicture() {
		return super.getItemPicture();
	}
	
	/**
	 * Set Weapon name
	 * @param weaponName - name of Weapon 
	 */
	public void setWeaponName(String weaponName) {
		super.setItemName(weaponName);
	}
	
	/**
	 * Set id of Weapon
	 * @param weaponId - id of Weapon
	 */
	public void setWeaponId(int weaponId) {
		super.setItemId(weaponId);
	}
	
	/**
	 * Set price of Weapon
	 * @param weaponPrice - price of Weapon
	 */
	public void setWeaponPrice(int weaponPrice) {
		super.setItemPrice(weaponPrice);
	}
	
	/**
	 * Set picture of Weapon
	 * @param weaponPicture - picture of Weapon
	 */
	public void setWeaponPicture(String weaponPicture) {
		super.setItemPicture(weaponPicture);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + hitPoints;
		result = prime * result + (weaponType ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (hitPoints != other.hitPoints)
			return false;
		if (weaponType != other.weaponType)
			return false;
		return true;
	}
	
}