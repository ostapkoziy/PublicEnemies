package com.epam.publicenemies.domain.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGameList {
	private List<BlackJackGame> allGames = new ArrayList<BlackJackGame>();

	public BlackJackGame getGameById(int id){
		for(BlackJackGame g : allGames){
			if (g.getId()==id){
				return g;			}
		}
		return null;
	}
	
	public void createNewGame(int id,int chips){
		allGames.add(new BlackJackGame(id,chips));
	}
	
	public void removeGame(int id){
		for (BlackJackGame game : allGames){
			if (game.getId()==id){
				allGames.remove(game);
				return;
			}
		}
	}
}
