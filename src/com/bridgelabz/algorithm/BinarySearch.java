package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class BinarySearch {
	public static void main(String[] args) {
		Utility utility = new Utility();

		System.out.println("Enter size of the elements");
		Integer size = utility.userInputInteger();

		System.out.println("Enter elements");
		Integer[] arrayData = new Integer[size];
		Utility.readData(arrayData, size);

		System.out.println("Enter Searchelment");
		Integer searchElement = utility.userInputInteger();
		
		Integer result = Utility.search(arrayData, searchElement, 0, (arrayData.length - 1));
		if (result != -1) {
			System.out.println("search element is found");
		} else {
			System.out.println("search element is not found");
		}
	}
}
