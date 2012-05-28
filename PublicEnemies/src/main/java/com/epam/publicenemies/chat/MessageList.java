package com.epam.publicenemies.chat;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Alexander Ivanov
 * @since 18 квіт. 2012
 */
// TODO Прерробити!!!!!!!!!!1111
public class MessageList
{
	private HashMap<Long, LinkedList<String>>	gameMessages	= new HashMap<Long, LinkedList<String>>();
	private static MessageList					ml;
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
	public HashMap<Long, LinkedList<String>> getGameMessages()
	{
		return gameMessages;
	}
	public void setGameMessages(HashMap<Long, LinkedList<String>> gameMessages)
	{
		this.gameMessages = gameMessages;
	}
	public static void sendMessage()
	{
	}
}
