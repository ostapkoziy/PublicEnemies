package com.epam.publicenemies.domain;

public class Weapon extends Item {

//	private int weaponId;
//	private String weaponName;
	private int hitPoints;
//	private String weaponPicture;
	private boolean weaponType;
//	private int weaponPrice;
//	public int getWeaponId() {
//		return weaponId;
//	}
//	public void setWeaponId(int weaponId) {
//		this.weaponId = weaponId;
//	}
//	public String getWeaponName() {
//		return weaponName;
//	}
//	public void setWeaponName(String weaponName) {
//		this.weaponName = weaponName;
//	}
	public Weapon (int id, String name, int hitPoints, String picture, boolean weaponType, int price){
		super(id, name, picture, price);
		this.hitPoints = hitPoints;
		this.weaponType = weaponType;		
	}
	
	public Weapon(){
		super();
		hitPoints = 0;
		weaponType = false;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
//	public String getWeaponPicture() {
//		return weaponPicture;
//	}
//	public void setWeaponPicture(String weaponPicture) {
//		this.weaponPicture = weaponPicture;
//	}
	public boolean isWeaponType() {
		return weaponType;
	}
	public void setWeaponType(boolean weaponType) {
		this.weaponType = weaponType;
	}
//	public int getWeaponPrice() {
//		return weaponPrice;
//	}
//	public void setWeaponPrice(int weaponPrice) {
//		this.weaponPrice = weaponPrice;
//	}
	
}