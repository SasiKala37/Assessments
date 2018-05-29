package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class PrimeList {

	public static void main(String[] args) {
		//Utility.twoDPrime();
		int[][] anagramPrint = Utility.checkAngram();
		for (int i = 0; i < anagramPrint.length; i++) {
			for (int j = 0; j < anagramPrint[i].length; j++) {
				System.out.print(anagramPrint[i][j]);
			}
			System.out.println();
		}
	}
}