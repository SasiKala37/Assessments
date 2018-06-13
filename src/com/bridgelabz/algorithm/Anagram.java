/**
 * Purpose: check whether the two strings are anagram or not
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Anagram {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter first Strings");
		String firstString=scanner.nextLine();
		System.out.println("Enter second Strings");
		String secondString=scanner.nextLine();
		boolean result=Utility.isAnagram(firstString, secondString);
		if(result) {
			System.out.println("Entered Strings are anagram");
		}
		else {
			System.out.println("Entered Strings are not anagram");
		}
		scanner.close();
	}

}
