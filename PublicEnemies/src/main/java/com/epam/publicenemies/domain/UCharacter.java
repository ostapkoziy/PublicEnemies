package com.epam.publicenemies.domain;

public class UCharacter
{
	private int		characterId;
	private boolean	sex;
	private int		experience;
	private int		strength;
	private int		agility;
	private int		intellect;
	private String	profession;
	private int		fightsTotal;
	private int		fightsWon;
	// id of items
	private int		weapon1;
	private int		weapon2;
	private int		armor;
	private int		aid;
	// not in database
	private int		currentHP;
	private int		allUserHP;
	public UCharacter()
	{
	}
	/*
	 * Order as in 'characters' table
	 */
	public UCharacter(int characterId, boolean sex, int experience, int strength, int agility, int intelect, String profession, int fightsTotal,
			int fightsWon, int weapon1, int weapon2, int armor, int aid)
	{
		this.characterId = characterId;
		this.sex = sex;
		this.experience = experience;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intelect;
		this.profession = profession;
		this.fightsTotal = fightsTotal;
		this.fightsWon = fightsWon;
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.armor = armor;
		this.aid = aid;
		//not in DB
		this.allUserHP = 200+strength*10;
		this.currentHP = allUserHP;
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
	public String getProfession()
	{
		return profession;
	}
	public void setProffesion(String profession)
	{
		this.profession = profession;
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
		return currentHP;
	}
	public void setHP(int hP)
	{
		currentHP = hP;
	}
}
