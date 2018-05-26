package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Anagram {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter two Strings");
		String firstString=scanner.nextLine();
		System.out.println("Enter two Strings");
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
