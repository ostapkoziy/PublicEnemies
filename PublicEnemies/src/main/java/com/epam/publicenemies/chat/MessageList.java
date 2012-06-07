package com.epam.publicenemies.chat;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexander Ivanov
 * @since 18 квіт. 2012
 */
public class MessageList
{
	private ConcurrentHashMap<Long, LinkedList<String>>	gameMessages	= new ConcurrentHashMap<Long, LinkedList<String>>();
	private static MessageList							ml;
	private MessageList()
	{
	}
	public static MessageList newInstanse()
	{
		if (ml == null)
		{
			ml = new MessageList();
			return ml;
		}
		else
			return ml;
	}
	public ConcurrentHashMap<Long, LinkedList<String>> getGameMessages()
	{
		return gameMessages;
	}
	public void setGameMessages(ConcurrentHashMap<Long, LinkedList<String>> gameMessages)
	{
		this.gameMessages = gameMessages;
	}
	public static void sendMessage()
	{
	}
}
