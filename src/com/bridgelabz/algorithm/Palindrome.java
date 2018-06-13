/**
 * Purpose: To find the prime numbers that are Anagram and Palindrome 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */

package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class Palindrome {

	public static void main(String[] args) {
		int [] prime=Utility.findPrimeNumbers(1000);
		System.out.println("prime numbers");
		for (int i = 0; i <168; i++) {
			System.out.print(prime[i]+" ");
		}
		System.out.println();
		int[] anagram=Utility.primesAnagram(prime);
		System.out.println("Anagram numbers");
		for (int i = 0; i < 158; i++) {
			System.out.print(anagram[i]+" ");
		}
		System.out.println();
		int[] palindrome=Utility.isPalindrome(anagram);
		System.out.println("palindrome numbers");
		for (int i = 0; i < palindrome.length; i++) {
			if(palindrome[i]==0) {
				break;
			}
			System.out.print(palindrome[i]+" ");
		}
	}

}
