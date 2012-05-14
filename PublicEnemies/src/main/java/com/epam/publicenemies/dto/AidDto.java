package com.epam.publicenemies.dto;

public class AidDto {

	private int aidId;
	private String aidName;
	private String aidType;
	private int aidEffect;
	private String aidPicture;
	private int aidPrice;
	public int getAidId() {
		return aidId;
	}
	public void setAidId(int aidId) {
		this.aidId = aidId;
	}
	public String getAidType() {
		return aidType;
	}
	public void setAidType(String aidType) {
		this.aidType = aidType;
	}
	public String getAidName() {
		return aidName;
	}
	public void setAidName(String aidName) {
		this.aidName = aidName;
	}
	public int getAidEffect() {
		return aidEffect;
	}
	public void setAidEffect(int aidEffect) {
		this.aidEffect = aidEffect;
	}
	public String getAidPicture() {
		return aidPicture;
	}
	public void setAidPicture(String aidPicture) {
		this.aidPicture = aidPicture;
	}
	public int getAidPrice() {
		return aidPrice;
	}
	public void setAidPrice(int aidPrice) {
		this.aidPrice = aidPrice;
	}
}
