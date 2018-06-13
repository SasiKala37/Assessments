/**
 * Purpose: Sort the array of data using merge sort
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MergeSort {
	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("Enter the size of the array");
		int size=utility.userInputInteger();
		String[] arrayOfString = new String[size];
		System.out.println("Enter String elements");
		for (int i = 0; i < arrayOfString.length; i++) {
			arrayOfString[i]=utility.userInputString();
		}
		Utility.sort(arrayOfString,0,arrayOfString.length-1);
	}
}
