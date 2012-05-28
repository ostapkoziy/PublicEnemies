package com.epam.publicenemies.utils;

import java.util.HashMap;

import com.epam.publicenemies.domain.User;

public class OnlineUsers
{
	HashMap<Long, User>			map	= new HashMap<Long, User>();
	private static OnlineUsers	users;
	private OnlineUsers()
	{
	}
	public static OnlineUsers newInstanse()
	{
		if (users == null)
		{
			users = new OnlineUsers();
			return users;
		}
		else
			return users;
	}
	public HashMap<Long, User> getMap()
	{
		return map;
	}
	public void setMap(HashMap<Long, User> map)
	{
		this.map = map;
	}
}
