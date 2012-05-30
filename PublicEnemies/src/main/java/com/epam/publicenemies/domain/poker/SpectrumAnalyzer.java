package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class SpectrumAnalyzer {
	private String[][] map = new String[13][13];
	private static final SpectrumAnalyzer INSTANCE = new SpectrumAnalyzer();

	private SpectrumAnalyzer() {
		this.initMap();
	}

	public static SpectrumAnalyzer getInstance() {
		return INSTANCE;
	}

	private void initMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = "";
			}
		}
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				//init the 1st symbol of every cell
				if((i == 0) || (j == 0)){	
					map[i][j] += "A";
				}else if((i == 1) || (j == 1)){
					map[i][j] += "K";
				}else if((i == 2) || (j == 2)){
					map[i][j] += "Q";
				}else if((i == 3) || (j == 3)){
					map[i][j] += "J";
				}else if((i == 4) || (j == 4)){
					map[i][j] += "T";
				}else if((i == 5) || (j == 5)){
					map[i][j] += "9";
				}else if((i == 6) || (j == 6)){
					map[i][j] += "8";
				}else if((i == 7) || (j == 7)){
					map[i][j] += "7";
				}else if((i == 8) || (j == 8)){
					map[i][j] += "6";
				}else if((i == 9) || (j == 9)){
					map[i][j] += "5";
				}else if((i == 10) || (j == 10)){
					map[i][j] += "4";
				}else if((i == 11) || (j == 11)){
					map[i][j] += "3";
				}else if((i == 12) || (j == 12)){
					map[i][j] += "2";
				}
				
				
				if(i == j){
					map[i][j] += map[i][j];	//diagonal
					for(int temp = j-1; temp >= 0; temp --){	//others
						map[i][temp] += map[i][j].substring(0, 1);
						map[temp][j] += map[i][j].substring(0, 1);
					}
				}
			}
		}
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if (j > i){
					map[i][j] += "s";
				}else if (j < i){
					map[i][j] += "o";
				}
			}
		}
	}

	public void show() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(map[i][0] + "\t" + map[i][1] + "\t" + map[i][2]
					+ "\t" + map[i][3] + "\t" + map[i][4] + "\t" + map[i][5] + "\t"
					+ map[i][6] + "\t" + map[i][7] + "\t" + map[i][8] + "\t"
					+ map[i][9] + "\t" + map[i][10] + "\t" + map[i][11] + "\t"
					+ map[i][12]+"\n");
		}
	}
	
	/**available param lengths
	 * 3 chars = pair. e.g "TT+" means all pairs higher than 10; "44-" - all pairs lower than 4
	 * 4 chars = non pair;
	 * 3rd char = "s" - suited. e.g "63s+" - all suited higher than 63 (6+ and 3, 6 and 3+)
	 **/
	private List<String> getChances(String param){
		List<String> result = new ArrayList<String>();
		
		int x = 0, y = 0;	//coords of found point
		
		
		
		if(param.length() == 3){	//pair + or -
			List<Integer> find = this.contains(param.substring(0,2));
			if (find != null){
				x = find.get(0);
				y = find.get(1);
				//x and y now contain coords of the param string 
			}
			if (param.endsWith("+")){

				for(int i = 0; i <= x; i++){
					result.add(map[i][i]);
				}
				
			}else if (param.endsWith("-")){

				System.out.println("X - "+x+"\nY - "+y);
				for(int i = x; i < map.length; i++){
					result.add(map[i][i]);
				}
			}
		
		}else if(param.length() == 4){	//not pair
			List<Integer> find = this.contains(param.substring(0,3));
			if (find != null){
				x = find.get(0);
				y = find.get(1);
				//x and y now contain coords of the param string 
			}
			if (param.endsWith("+")){	
				if(param.contains("s")){
					
					for(int i = x; i >= 0; i --){
						for(int j = y; j >= 0; j --){
							if(i == j){
								break;
							}
							result.add(map[i][j]);
						}
					}
				}else if (param.contains("o")){	
					for(int i = 0; i <= x; i ++){
						for(int j = 0; j <= y; j ++){
							if(i == j){
								break;
							}
							result.add(map[i][j]);
						}
					}
				}
			}else if (param.endsWith("-")){
					if(param.contains("s")){
					for(int i = x; i < map.length; i ++){
						for(int j = y; j < map.length; j ++){
							if(i == j){
								continue;
							}
							if(map[i][j].contains("o")){
								continue;
							}
							result.add(map[i][j]);
						}
					}
				}else if (param.contains("o")){
					for(int i = x; i < map.length; i ++){
						for(int j = y; j < map.length; j ++){
							if(i == j){
								break;
							}
							result.add(map[i][j]);
						}
					}
				}
			}
		}
		
		return result;
		
	}
	
	private List<Integer> contains(String arg){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < map.length; i ++){
			for(int j = 0; j < map[i].length; j ++){
				if (map[i][j].contains(arg)){
					result.add(i);
					result.add(j);
					return result;
				}
			}
		}
		return null;
	}

	public boolean inRange(PokerHand hand, List<String> conditions){
		boolean result = false;
		Set<String> results = new TreeSet<String>();
		for(String i : conditions){
			results.addAll(this.getChances(i));
		}
		if (results.contains(hand.getNotation())){
			result = true;
		}
		return result;
	}
}
