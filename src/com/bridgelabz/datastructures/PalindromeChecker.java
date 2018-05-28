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
