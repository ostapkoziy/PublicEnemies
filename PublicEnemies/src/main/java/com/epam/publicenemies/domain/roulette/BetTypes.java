package com.epam.publicenemies.domain.roulette;


public enum BetTypes {
	STRAIGHTUP(36),
	COLUMN1(3),COLUMN2(3),COLUMN3(3),
	DOZEN1(3),DOZEN2(3),DOZEN3(3),
	AnyRED(2),AnyBLACK(2),
	EVEN(2),ODD(2),
	LOW(2),HIGH(2);
	
	private final int WinMultiplier;
	
	private BetTypes (int mult){
		this.WinMultiplier = mult;
	}

	public int getPrize(BetTypes betType, Integer[] betNumbers, int rnd){
		if (betType==STRAIGHTUP) {
				if ((betNumbers[rnd]!=null)&&(betNumbers[rnd]>0)) return this.WinMultiplier*betNumbers[rnd];
		}

		if ((betType==COLUMN1)&&(betNumbers[46]!=null)) {
			for (int i = 1; i<=36; i+=3){
				if (i==rnd) return this.WinMultiplier*betNumbers[46]; //46 is index of COLUMN 1 in JSP
			}
		}

		if ((betType==COLUMN2)&&(betNumbers[47]!=null)) {
			for (int i = 2; i<=36; i+=3){
				if (i==rnd) return this.WinMultiplier*betNumbers[47]; //47 is index of COLUMN 2 in JSP
			}
		}

		if ((betType==COLUMN3)&&(betNumbers[48]!=null)) {
			for (int i = 3; i<=36; i+=3){
				if (i==rnd) return this.WinMultiplier*betNumbers[48]; //48 is index of COLUMN 3 in JSP
			}
		}

		if ((betType==DOZEN1)&&(betNumbers[37]!=null)) {
			for (int i = 1; i<=12; i++){
				if (i==rnd) return this.WinMultiplier*betNumbers[37];
			}
		}

		if ((betType==DOZEN2)&&(betNumbers[38]!=null)) {
			for (int i = 13; i<=24; i++){
				if (i==rnd) return this.WinMultiplier*betNumbers[38];
			}
		}
		
		if ((betType==DOZEN3)&&(betNumbers[39]!=null)) {
			for (int i = 25; i<=36; i++){
				if (i==rnd) return this.WinMultiplier*betNumbers[39];
			}
		}

		if ((betType==AnyRED)&&(betNumbers[41]!=null)) {
			int[] redOnes = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
			for (int i = 0; i<redOnes.length; i++){
				if (redOnes[i]==rnd) return this.WinMultiplier*betNumbers[41];
			}
		}

		if ((betType==AnyBLACK)&&(betNumbers[42]!=null)) {
			int[] blackOnes = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
			for (int i = 0; i<blackOnes.length; i++){
				if (blackOnes[i]==rnd) return this.WinMultiplier*betNumbers[42];
			}
		}

		if ((betType==EVEN)&&(betNumbers[43]!=null)) {
			for (int i = 2; i<=36; i+=2){
				if (i==rnd) return this.WinMultiplier*betNumbers[43];
			}
		}

		if ((betType==ODD)&&(betNumbers[40]!=null)) {
			for (int i = 1; i<=36; i+=2){
				if (i==rnd) return this.WinMultiplier*betNumbers[40];
			}
		}

		if ((betType==LOW)&&(betNumbers[44]!=null)) {
			for (int i = 1; i<=18; i++){
				if (i==rnd) return this.WinMultiplier*betNumbers[44];
			}
		}
		
		if ((betType==HIGH)&&(betNumbers[45]!=null)) {
			for (int i = 19; i<=36; i++){
				if (i==rnd) return this.WinMultiplier*betNumbers[45];
			}
		}
		
		return 0;
	}

}
