package com.epam.publicenemies.domain.fight.skills;

/**
 * @author Alexander Ivanov
 */
public abstract class AbstractSkill
{
	private String	name;
	private int		reload;
	private String	skillImage;
	public String getName()
	{
		return name;
	}
	public int getReload()
	{
		return reload;
	}
	public String getSkillImage()
	{
		return skillImage;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setReload(int reload)
	{
		this.reload = reload;
	}
	public void setSkillImage(String skillImage)
	{
		this.skillImage = skillImage;
	}
}
