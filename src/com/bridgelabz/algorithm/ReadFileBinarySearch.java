package com.bridgelabz.algorithm;

import java.io.IOException;

import com.bridgelabz.utility.Utility;

public class ReadFileBinarySearch {

	public static void main(String[] args) throws IOException {
		Utility utility= new Utility();
		System.out.println("Enter Searchelment");
		String  searchString=utility.userInputString();
		utility.searchWord(searchString);
	}

}
