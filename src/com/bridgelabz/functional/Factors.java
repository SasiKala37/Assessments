/**
 * 
 * Purpose: prints the prime factors of the number
 * 
 * @author SasiKala
 * @version 1.0
 * @since 17-05-2018
 * 
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Factors {

	public static void main(String[] args) {

		Utility utility = new Utility();
		System.out.println("Enter the number");
		int number = utility.userInputInteger();
		System.out.println("Prime factors are:");

		utility.primeFactors(number);
	}

}
