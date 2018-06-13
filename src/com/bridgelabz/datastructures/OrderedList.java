/** 
 * Purpose:Implementation of ordered linked list
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import java.io.File;
import java.io.FileNotFoundException;

import com.bridgelabz.utility.Utility;

public class OrderedList {

	public static void main(String[] args) throws FileNotFoundException {
		Utility utility = new Utility();
		// String filePath="/home/bridgelabz/sasi-txtdocuments/numbers.txt";

		utility.orderedFile(new File("/home/bridgelabz/sasi-txtdocuments/numbers.txt"));
	}

}
