package com.epam.publicenemies.domain;

import com.epam.publicenemies.domain.fight.Level;

public class UCharacter
{
	private int			characterId;
	private boolean		sex;
	private int			experience;
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
	// not in database TODO make Stats Calculator
	private int			HP;
	private int			allUserHP;
	private int			damage;
	private int			defence;
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
		this.experience = experience;
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
		// not in DB
		this.allUserHP = 200 + strength * 10;
		this.HP = allUserHP;
		this.damage = 20 + agility * 3;
		this.defence = armor;
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
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
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
	public Profession getCharacterProfession() {
		return characterProfession;
	}
	public void setCharacterProfession(Profession characterProfession) {
		this.characterProfession = characterProfession;
	}
}
