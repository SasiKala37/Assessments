package com.bridgelabz.datastructures;

import java.io.FileNotFoundException;

import com.bridgelabz.utility.Utility;

public class OrderedList {

	public static void main(String[] args) throws FileNotFoundException {
		Utility utility=new Utility();
		System.out.println("Enter the search number");
        int searchNumber=utility.userInputInteger();
        utility.orderedFile(searchNumber);
	}

}
