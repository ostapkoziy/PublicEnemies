package com.epam.publicenemies.dto;

import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;

public class ProfileDto {

	private User pUser;
//	private int userId; 
//	private int profileId;
//	private int money;
//	private String avatar;
//	private String nickName;
	// character fields
	private UCharacter pCharacter;
//	private boolean sex;
//	private String profession;
//	private int fightsTotal;
//	private int experience;
//	private int strength;
//	private int agility;
//	private int intellect;
//	private int fightsWon;
	// id of items
	private Armor pArmor;
	private Aid pAid;
	private Weapon pWeapon1;
	private Weapon pWeapon2;
//	private int weapon1Id;
//	private int weapon2Id;
//	private int armorId;
//	private int aidId;
	
	public ProfileDto() {
		pUser = new User();
		pCharacter = new UCharacter();
		pArmor = new Armor();
		pAid = new Aid();
		pWeapon1 = new Weapon();
		pWeapon2 = new Weapon();
	}
	
	public ProfileDto(User user, UCharacter character) {
		this.pUser = user;
		this.pCharacter = character;
		
	}

	public int getUserId() {
		return pUser.getUserId();
	}
	public void setUserId(int userId) {
		pUser.setUserId(userId);
	}
	public boolean isSex() {
		return pCharacter.isSex();
	}
	public void setSex(boolean sex) {
		pCharacter.setSex(sex);
	}
	public int getMoney() {
		return pUser.getMoney();
	}

	public void setMoney(int money) {
		pUser.setMoney(money);
	}
	public int getExperience() {
		return pCharacter.getExperience();
	}
	public void setExperience(int experience) {
		pCharacter.setExperience(experience);
	}
	public int getStrength() {
		return pCharacter.getStrength();
	}
	public void setStrength(int strength) {
		pCharacter.setStrength(strength);
	}
	public int getAgility() {
		return pCharacter.getAgility();
	}
	public void setAgility(int agility) {
		pCharacter.setAgility(agility);
	}
	public int getIntellect() {
		return pCharacter.getIntellect();
	}
	public void setIntellect(int intellect) {
		pCharacter.setIntellect(intellect);
	}
	public int getWeapon1Id() {
		return pWeapon1.getItemId();
	}
	public void setWeapon1Id(int weapon1Id) {
		pWeapon1.setItemId(weapon1Id);
	}
	public int getWeapon2Id() {
		return pWeapon2.getItemId();
	}
	public void setWeapon2Id(int weapon2Id) {
		pWeapon2.setItemId(weapon2Id);
	}
	public int getArmorId() {
		return pArmor.getItemId();
	}
	public void setArmorId(int armorId) {
		pArmor.setItemId(armorId);
	}
	public int getAidId() {
		return pAid.getItemId();
	}
	public void setAidId(int aidId) {
		pAid.setItemId(aidId);
	}
	public int getProfileId() {
		return pUser.getCharacterId();
	}
	public void setProfileId(int profileId) {
		pUser.getCharacterId();
	}
	public String getNickName() {
		return pUser.getNickName();
	}
	public void setNickName(String nickName) {
		pUser.setNickName(nickName);
	}
	public String getAvatar() {
		return pUser.getAvatar();
	}
	public void setAvatar(String avatar) {
		pUser.setAvatar(avatar);
	}
	
	public String getProfession() {
		return pCharacter.getProfession();
	}
	public void setProfession(String profession) {
		pCharacter.setProffesion(profession);
	}
	public int getFightsTotal() {
		return pCharacter.getFightsTotal();
	}
	public void setFightsTotal(int fightsTotal) {
		pCharacter.setFightsTotal(fightsTotal);
	}
	public int getFightsWon() {
		return pCharacter.getFightsWon();
	}
	public void setFightsWon(int fightsWon) {
		pCharacter.setFightsWon(fightsWon);
	}
}
