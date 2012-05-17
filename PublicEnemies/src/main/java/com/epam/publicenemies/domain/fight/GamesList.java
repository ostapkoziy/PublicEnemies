package com.epam.publicenemies.domain.fight;

import java.util.ArrayList;

/**
 * @author Alexander Ivanov
 * @since 18.04.2012
 */
public class GamesList
{
	private ArrayList<Game>		list	= new ArrayList<Game>();
	private static GamesList	gl;
	private GamesList()
	{
	}
	public static GamesList newInstanse()
	{
		if (gl == null)
		{
			gl = new GamesList();
			return gl;
		}
		else
			return gl;
	}
	public ArrayList<Game> getList()
	{
		return list;
	}
	public void setList(ArrayList<Game> list)
	{
		this.list = list;
	}
	public ArrayList<Game> getNotStartedGames()
	{
		ArrayList<Game> gl = new ArrayList<Game>();
		for (Game game : getList())
		{
			if (!game.isGameStarted()) gl.add(game);
		}
		return gl;
	}
}
