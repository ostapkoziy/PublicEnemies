package com.epam.publicenemies.domain;

/**
 * Aid object
 * 
 * @author Chetyrkin S.V.
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
