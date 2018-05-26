package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MergeSort {
	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("Enter the size of the array");
		int size=utility.userInputInteger();
		String[] arrayOfString = new String[size];
		System.out.println("Enter String elements");
		Utility.readData(arrayOfString,size);
		Utility.sort(arrayOfString,0,arrayOfString.length-1);
	}
}
