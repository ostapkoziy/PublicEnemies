package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.web.casino.poker.PokerGame;

public class PokerGameList {
	private List<PokerGame> allGames = new ArrayList<PokerGame>();

	public PokerGame getGameById(int id){
		for(PokerGame g : allGames){
			if (g.getId()==id){
				return g;			}
		}
		return null;
	}
	
	public void createNewGame(int id, Profile user){
		allGames.add(new PokerGame(id,user));
	}
	
	public void removeGame(int id){
		for (PokerGame game : allGames){
			if (game.getId()==id){
				allGames.remove(game);
				return;
			}
		}
	}
}
