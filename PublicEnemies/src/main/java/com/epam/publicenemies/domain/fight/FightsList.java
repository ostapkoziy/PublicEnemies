package com.epam.publicenemies.domain.fight;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexander Ivanov
 * @since 18.04.2012
 */
public class FightsList
{
	ConcurrentHashMap<Long, Fight>	map	= new ConcurrentHashMap<Long, Fight>();
	private static FightsList		gl;
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
	public ConcurrentHashMap<Long, Fight> getMap()
	{
		return map;
	}
	public void setMap(ConcurrentHashMap<Long, Fight> list)
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
