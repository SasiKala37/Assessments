/** 
 * Purpose: Read the Text from a file, split it into words and arrange it as Linked List. 
 * Take a user input to search a Word in the List. If the Word is not found then add it to the list,
 *  and if it found then remove the word from the List. In the end save the list into a file
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import java.io.FileNotFoundException;

import com.bridgelabz.utility.Utility;

public class UnOrderedList {

	public static void main(String[] args) throws FileNotFoundException {
		Utility utility = new Utility();

		utility.unorderedFile();
	}

}
