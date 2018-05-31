package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class BubbleSort {

	public static void main(String[] args) {
		Utility utility = new Utility();

		System.out.println("Enter the size of the array");
		int size = utility.userInputInteger();
		String[] arrayOfString = new String[size];

		System.out.println("Enter String elements");
		//Integer[] arrayData = new Integer[size];
		for (int i = 0; i < arrayOfString.length; i++) {
			arrayOfString[i]=utility.userInputString();
		}

		Utility.bubbleSort(arrayOfString);

	}

}
