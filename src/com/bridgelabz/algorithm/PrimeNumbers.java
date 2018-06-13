/**
 * Purpose: To print a the Prime numbers in the range of 0 - 1000 Numbers  
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */

package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class PrimeNumbers {
	public static void main(String[] args) {
		int higherLimit = 1000;
		System.out.println("prime numbers with in the range 0-1000 ");
		Utility.findPrimeNumbers(higherLimit);

	}
}
