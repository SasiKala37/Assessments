/** 
 * Purpose:Take a range of 0 - 1000 Numbers and find the Prime numbers in that range. 
 * Store the prime numbers in a 2D Array, the first dimension represents the range 0-100, 100-200, and so on. 
 * While the second dimension represents the prime numbers as well as anagrams in that range
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class PrimeList {

	public static void main(String[] args) {
		System.out.println("Prime numbers");
		Utility.twoDPrime();
		//Utility.checkAngram();
		System.out.println("prime anagrams");
		Utility.primeAnagram();
		//Utility.nonAngram();
		
	}
}