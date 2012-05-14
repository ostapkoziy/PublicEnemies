package com.epam.publicenemies.domain;

public class Aid extends Item {

	//private int aidId;
	//private String aidName;
	private String aidType;
	private int aidEffect;
//	private String aidPicture;
//	//private int aidPrice;
//	public int getAidId() {
//		return aidId;
//	}
//	public void setAidId(int aidId) {
//		this.aidId = aidId;
//	}
	
	public Aid() {
		super();
		aidType = new String();
		aidEffect = 0;
	}
	
	public Aid(int aidId, String aidName, String aidPicture, int aidPrice, String aidType, int aidEffect) {
		super(aidId, aidName, aidPicture, aidPrice);
		this.aidType = aidType;
		this.aidEffect = aidEffect;
	}
	
	public String getAidType() {
		return aidType;
	}
	public void setAidType(String aidType) {
		this.aidType = aidType;
	}
//	public String getAidName() {
//		return aidName;
//	}
//	public void setAidName(String aidName) {
//		this.aidName = aidName;
//	}
	public int getAidEffect() {
		return aidEffect;
	}
	public void setAidEffect(int aidEffect) {
		this.aidEffect = aidEffect;
	}
//	public String getAidPicture() {
//		return aidPicture;
//	}
//	public void setAidPicture(String aidPicture) {
//		this.aidPicture = aidPicture;
//	}
//	public int getAidPrice() {
//		return aidPrice;
//	}
//	public void setAidPrice(int aidPrice) {
//		this.aidPrice = aidPrice;
//	}
}
