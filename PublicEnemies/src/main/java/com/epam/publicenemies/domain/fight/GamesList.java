package com.epam.publicenemies.domain.fight;

import java.util.LinkedList;

/**
 * @author Alexander Ivanov
 * @since 18.04.2012
 */
public class GamesList
{
	private LinkedList<Game>	list	= new LinkedList<Game>();
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
	public LinkedList<Game> getList()
	{
		return list;
	}
	public LinkedList<Game> getNotStartedGames()
	{
		LinkedList<Game> gl = new LinkedList<Game>();
		for (Game game : getList())
		{
			if (!game.isGameStarted()) gl.addFirst(game);
		}
		return gl;
	}
	public void setList(LinkedList<Game> list)
	{
		this.list = list;
	}
}
