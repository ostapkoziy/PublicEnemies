package com.epam.publicenemies.domain.fight;

import java.util.ArrayList;

/**
 * @author Alexander Ivanov
 * @since 18.04.2012
 */
public class FightsList
{
	private ArrayList<Fight>	list	= new ArrayList<Fight>();
	private static FightsList	gl;
	private FightsList()
	{
	}
	public static FightsList newInstanse()
	{
		if (gl == null)
		{
			gl = new FightsList();
			return gl;
		}
		else
			return gl;
	}
	public ArrayList<Fight> getList()
	{
		return list;
	}
	public void setList(ArrayList<Fight> list)
	{
		this.list = list;
	}
	public ArrayList<Fight> getNotStartedGames()
	{
		ArrayList<Fight> gl = new ArrayList<Fight>();
		for (Fight game : getList())
		{
			if (!game.isGameStarted()) gl.add(game);
		}
		return gl;
	}
}
