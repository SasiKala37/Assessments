/**
 * Purpose: To find the Word from Word List using Binary Search 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
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
