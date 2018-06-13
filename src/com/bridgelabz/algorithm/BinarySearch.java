/**
 * Purpose: Search the data in array using binary search technique
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class BinarySearch {
	public static void main(String[] args) {
		Utility utility = new Utility();

		System.out.println("Enter size of the elements");
		Integer size = utility.userInputInteger();

		System.out.println("Enter elements");
		String[] arrayData = new String[size];
		for (int i = 0; i < arrayData.length; i++) {
			arrayData[i]=utility.userInputString();
		}
		Utility.bubbleSort(arrayData);

		System.out.println("Enter Searchelment");
		String searchElement = utility.userInputString();
		
		Integer result = Utility.search(arrayData, searchElement, 0, (arrayData.length - 1));
		if (result == -1) {
			System.out.println("search element is not found");
		} else {
			System.out.println("search element is  found");
		}
	}
}
