package com.epam.publicenemies.domain;

public class Profession {

	private byte professionId;
	private String professionName;
	private String professionAvatar;
	
	public Profession() {
		professionId = 1;
		professionName = "Butcher";
		professionAvatar = "./img/avatars/default.png";
	}
	
	public Profession(byte professionId, String professionName, String professionAvatar) {
		this.professionId = professionId;
		this.professionName = professionName;
		this.professionAvatar = professionAvatar;
	}
	
	public byte getProfessionId() {
		return professionId;
	}
	public void setProfessionId(byte professionId) {
		this.professionId = professionId;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getProfessionAvatar() {
		return professionAvatar;
	}
	public void setProfessionAvatar(String professionAvatar) {
		this.professionAvatar = professionAvatar;
	}
}
