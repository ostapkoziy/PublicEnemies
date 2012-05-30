package com.epam.publicenemies.utils;

public class Logar
{
	public static void main(String[] args)
	{
		// double step = Math.log(9) / Math.log(3);
		// System.out.println(step);
		// int exp = 32000;
		// double lvl = Math.log(exp / 1000) / Math.log(2);
		// System.out.println(lvl);
		// int expForNextLevel = 1000*lvl*lvl*100
		int leftGr = 0;
		int rightGr = 0;
		int lvl = 0;
		int allExp = 4500;
		while (true)
		{
			lvl++;
			rightGr = rightGr + 1000 + lvl * lvl * 100;
			if (rightGr > allExp)
			{
				break;
			}
			leftGr = rightGr;
		}
		int expOnCurrentLvl = allExp - leftGr;
		System.out.println("ALL EXP: " + allExp);
		System.out.println("LEVEL: " + lvl);
		System.out.println("RIGHT: " + rightGr);
		System.out.println("LEFT: " + leftGr);
		System.out.println("EXP ON CURRENT LVL: " + expOnCurrentLvl);
	}
}