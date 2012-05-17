package com.epam.publicenemies.domain;

/**
 * Aid object
 * 
 * @author Chetyrkin S.V.
 * Updated Chetyrkin S.V. 17.05.2012 - added getters and setters for basic object parameters
 *
 */
public class Aid extends Item {

	private String aidType;
	private int aidEffect;
	
	/**
	 * Default Aid constructor
	 */
	public Aid() {
		super();
		aidType = new String();
		aidEffect = 0;
	}
	
	/**
	 * Non-default constructor
	 * @param aidId - id of Aid
	 * @param aidName - name of Aid
	 * @param aidPicture - picture of Aid
	 * @param aidPrice - price of Aid
	 * @param aidType - type of Aid
	 * @param aidEffect - effect of Aid
	 */
	public Aid(int aidId, String aidName, String aidPicture, int aidPrice, String aidType, int aidEffect) {
		super(aidId, aidName, aidPicture, aidPrice);
		this.aidType = aidType;
		this.aidEffect = aidEffect;
	}
	
	
	/**
	 * Get name of Aid
	 * @return name of Aid
	 */
	public String getAidName() {
		return super.getItemName();
	} 
	
	/**
	 * Get id of Aid
	 * @return id of Aid
	 */
	public int getAidId() {
		return super.getItemId();
	}
	
	/**
	 * Get price of Aid
	 * @return price of Aid
	 */
	public int getAidPrice() {
		return super.getItemPrice();
	}
	
	/**
	 * Get picture of Aid
	 * @return picture of Aid
	 */
	public String getAidPicture() {
		return super.getItemPicture();
	}
	
	/**
	 * Set name of Aid
	 * @param aidName - name of Aid
	 */
	public void setAidName (String aidName) {
		super.setItemName(aidName);
	}
	
	/**
	 * Set id of Aid
	 * @param aidId - id of Aid
	 */
	public void setAidId (int aidId) {
		super.setItemId(aidId);
	}
	
	/**
	 * Set price of Aid
	 * @param aidPrice - price of Aid
	 */
	public void setAidPrice (int aidPrice) {
		super.setItemPrice(aidPrice);
	}

	/**
	 * Set picture of Aid
	 * @param aidPicture - picture of Aid
	 */
	public void setAidPicture(String aidPicture) {
		super.setItemPicture(aidPicture);
	}
	
	/**
	 * Get Aid type
	 * @return - type of Aid
	 */
	public String getAidType() {
		return aidType;
	}
	
	/**
	 * Set Aid type
	 * @param aidType - type of Aid
	 */
	public void setAidType(String aidType) {
		this.aidType = aidType;
	}

	/**
	 * Get Aid effect
	 * @return Aid effect
	 */
	public int getAidEffect() {
		return aidEffect;
	}
	
	/**
	 * Set Aid effect
	 * @param aidEffect - effect of Aid
	 */
	public void setAidEffect(int aidEffect) {
		this.aidEffect = aidEffect;
	}
}
