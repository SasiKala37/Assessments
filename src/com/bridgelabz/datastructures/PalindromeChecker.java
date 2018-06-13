/** 
 * Purpose:To check the palidrome of a string using Dqueue
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class PalindromeChecker {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter the String to check palindrome or not");
		String input=utility.userInputString();
		boolean result=utility.checkPalindrome(input);
		if(result) {
			System.out.println("given string is palindrome");
		}
		else {
			System.out.println("given string is not palindrome");
		}
		
		
	}

}
