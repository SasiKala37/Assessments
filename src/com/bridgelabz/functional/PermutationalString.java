/**
* Purpose:print all permutations of string
* 
* @author SasiKala
* @version 1.0
* @since 18-05-2018
* 
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class PermutationalString {
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the input String");
		String input = utility.userInputString();
		int lenthOfInput = input.length();

		Utility.permutation(input, 0, lenthOfInput - 1);
	}
}