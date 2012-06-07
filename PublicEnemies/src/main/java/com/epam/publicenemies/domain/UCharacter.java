package com.epam.publicenemies.domain;

import com.epam.publicenemies.domain.fight.Level;

public class UCharacter
{
	private int			characterId;
	private boolean		sex;
	private int			strength;
	private int			agility;
	private int			intellect;
	private Profession	characterProfession;
	private int			fightsTotal;
	private int			fightsWon;
	// id of items
	private int			weapon1;
	private int			weapon2;
	private int			armor;
	private int			aid;
	private int			HP;
	private int			allUserHP;
	private int			damage;
	private int			defence;
	private int 		missRate;
	private Level		level;
	public UCharacter()
	{
	}
	/*
	 * Order as in 'characters' table
	 */
	public UCharacter(int characterId, boolean sex, int experience, int strength, int agility, int intelect, Profession characterProfession,
			int fightsTotal, int fightsWon, int weapon1, int weapon2, int armor, int aid)
	{
		this.characterId = characterId;
		this.sex = sex;
		level = new Level(experience);
		this.strength = strength;
		this.agility = agility;
		this.intellect = intelect;
		this.characterProfession = characterProfession;
		this.fightsTotal = fightsTotal;
		this.fightsWon = fightsWon;
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.armor = armor;
		this.aid = aid;
	}
	public int getCharacterId()
	{
		return characterId;
	}
	public void setCharacterId(int characterId)
	{
		this.characterId = characterId;
	}
	public boolean isSex()
	{
		return sex;
	}
	public void setSex(boolean sex)
	{
		this.sex = sex;
	}
	public int getExperience()
	{
		return level.getAllExpirience();
	}
	public void setExperience(int experience)
	{
		this.level.setAllExpirience(experience);
	}
	public int getStrength()
	{
		return strength;
	}
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	public int getAgility()
	{
		return agility;
	}
	public void setAgility(int agility)
	{
		this.agility = agility;
	}
	public int getIntellect()
	{
		return intellect;
	}
	public void setIntellect(int intellect)
	{
		this.intellect = intellect;
	}
	public int getFightsTotal()
	{
		return fightsTotal;
	}
	public void setFightsTotal(int fightsTotal)
	{
		this.fightsTotal = fightsTotal;
	}
	public int getFightsWon()
	{
		return fightsWon;
	}
	public void setFightsWon(int fightsWon)
	{
		this.fightsWon = fightsWon;
	}
	public int getWeapon1()
	{
		return weapon1;
	}
	public void setWeapon1(int weapon1)
	{
		this.weapon1 = weapon1;
	}
	public int getWeapon2()
	{
		return weapon2;
	}
	public void setWeapon2(int weapon2)
	{
		this.weapon2 = weapon2;
	}
	public int getArmor()
	{
		return armor;
	}
	public void setArmor(int armor)
	{
		this.armor = armor;
	}
	public int getAid()
	{
		return aid;
	}
	public void setAid(int aid)
	{
		this.aid = aid;
	}
	public int getHP()
	{
		return HP;
	}
	public void setHP(int hP)
	{
		HP = hP;
	}
	public int getAllUserHP()
	{
		return allUserHP;
	}
	public void setAllUserHP(int allUserHP)
	{
		this.allUserHP = allUserHP;
	}
	public int getDamage()
	{
		return damage;
	}
	public int getDefence()
	{
		return defence;
	}
	public Level getLevel()
	{
		return level;
	}
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	public void setDefence(int defence)
	{
		this.defence = defence;
	}
	public void setLevel(Level level)
	{
		this.level = level;
	}
	public Profession getCharacterProfession()
	{
		return characterProfession;
	}
	public void setCharacterProfession(Profession characterProfession)
	{
		this.characterProfession = characterProfession;
	}
	public int getMissRate() {
		return missRate;
	}
	public void setMissRate(int missRate) {
		this.missRate = missRate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + HP;
		result = prime * result + agility;
		result = prime * result + aid;
		result = prime * result + allUserHP;
		result = prime * result + armor;
		result = prime * result + characterId;
		result = prime
				* result
				+ ((characterProfession == null) ? 0 : characterProfession
						.hashCode());
		result = prime * result + damage;
		result = prime * result + defence;
		result = prime * result + fightsTotal;
		result = prime * result + fightsWon;
		result = prime * result + intellect;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + missRate;
		result = prime * result + (sex ? 1231 : 1237);
		result = prime * result + strength;
		result = prime * result + weapon1;
		result = prime * result + weapon2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UCharacter other = (UCharacter) obj;
		if (HP != other.HP)
			return false;
		if (agility != other.agility)
			return false;
		if (aid != other.aid)
			return false;
		if (allUserHP != other.allUserHP)
			return false;
		if (armor != other.armor)
			return false;
		if (characterId != other.characterId)
			return false;
		if (characterProfession == null) {
			if (other.characterProfession != null)
				return false;
		} else if (!characterProfession.equals(other.characterProfession))
			return false;
		if (damage != other.damage)
			return false;
		if (defence != other.defence)
			return false;
		if (fightsTotal != other.fightsTotal)
			return false;
		if (fightsWon != other.fightsWon)
			return false;
		if (intellect != other.intellect)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (missRate != other.missRate)
			return false;
		if (sex != other.sex)
			return false;
		if (strength != other.strength)
			return false;
		if (weapon1 != other.weapon1)
			return false;
		if (weapon2 != other.weapon2)
			return false;
		return true;
	}
}
