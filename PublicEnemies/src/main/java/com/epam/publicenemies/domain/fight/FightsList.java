package com.epam.publicenemies.domain.fight;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Alexander Ivanov
 * @since 18.04.2012
 */
public class FightsList
{
	HashMap<Long, Fight>		map	= new HashMap<Long, Fight>();
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
	public HashMap<Long, Fight> getMap()
	{
		return map;
	}
	public void setMap(HashMap<Long, Fight> list)
	{
		this.map = list;
	}
	public ArrayList<Fight> getNotStartedGames()
	{
		ArrayList<Fight> gameList = new ArrayList<Fight>();
		for (Fight game : map.values())
		{
			if (!game.isGameStarted()) gameList.add(game);
		}
		return gameList;
	}
}
