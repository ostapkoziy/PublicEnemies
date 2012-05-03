package com.epam.publicenemies.dto;

import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;

public class ProfileDto {
	// user fields
	private int userId; 
	private int profileId;
	private int money;
	private String avatar;
	private String nickName;
	// character fields
	private boolean sex;
	private String profession;
	private int fightsTotal;
	private int experience;
	private int strength;
	private int agility;
	private int intellect;
	private int fightsWon;
	// id of items
	private int weapon1Id;
	private int weapon2Id;
	private int armorId;
	private int aidId;
	
	public ProfileDto() {}
	
	public ProfileDto(User user, UCharacter userChar) {
		userId 		= user.getUserId();
		money 		= user.getMoney(); 
		nickName 	= user.getNickName();
		avatar 		= user.getAvatar();
		
		profileId 	= userChar.getCharacterId();
		sex 		= userChar.isSex();
		profession 	= userChar.getProfession();
		fightsTotal = userChar.getFightsTotal();
		experience 	= userChar.getExperience();
		strength 	= userChar.getStrength();
		agility 	= userChar.getAgility();
		intellect 	= userChar.getIntellect();
		fightsWon 	= userChar.getFightsWon();
		weapon1Id 	= userChar.getWeapon1();
		weapon2Id 	= userChar.getWeapon2();
		armorId 	= userChar.getArmor();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntellect() {
		return intellect;
	}
	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}
	public int getWeapon1Id() {
		return weapon1Id;
	}
	public void setWeapon1Id(int weapon1Id) {
		this.weapon1Id = weapon1Id;
	}
	public int getWeapon2Id() {
		return weapon2Id;
	}
	public void setWeapon2Id(int weapon2Id) {
		this.weapon2Id = weapon2Id;
	}
	public int getArmorId() {
		return armorId;
	}
	public void setArmorId(int armorId) {
		this.armorId = armorId;
	}
	public int getAidId() {
		return aidId;
	}
	public void setAidId(int aidId) {
		this.aidId = aidId;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getFightsTotal() {
		return fightsTotal;
	}
	public void setFightsTotal(int fightsTotal) {
		this.fightsTotal = fightsTotal;
	}
	public int getFightsWon() {
		return fightsWon;
	}
	public void setFightsWon(int fightsWon) {
		this.fightsWon = fightsWon;
	}
}
