package com.bridgelabz.datastructures;

import java.io.FileNotFoundException;

import com.bridgelabz.utility.Utility;

public class UnOrderedList {

	public static void main(String[] args) throws FileNotFoundException {
		Utility utility=new Utility();
		System.out.println("Enter the search word");
        String searchData=utility.userInputString();
        utility.unorderedFile(searchData);
	}

}
