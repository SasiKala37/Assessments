/** 
 * Purpose:Create a Slot of 10 to store Chain of Numbers that belong to each Slot
 *  to efficiently search a number from a given set of number
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.bridgelabz.utility.Utility;

public class Hashing {

	public static void main(String[] args) throws Exception {
		Utility utility = new Utility();
		HashTableChaining hashTableChaining = new HashTableChaining(12);
		File file = new File("/home/bridgelabz/sasi-txtdocuments/hash.txt");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			String word = null;
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while ((word = bufferedReader.readLine()) != null) {
				String[] array = word.split(",");
				System.out.println("Reading from the file.....");
				for (int i = 0; i < array.length; i++) {
					System.out.println(array[i]);
				}

				Integer array1[] = new Integer[array.length];
				for (int i = 0; i < array.length; i++) {
					array1[i] = Integer.parseInt(array[i]);
				}

				Integer[] sortedArray = Utility.insertionSort(array1);
				for (int i = 0; i < sortedArray.length; i++) {
					hashTableChaining.insert(sortedArray[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Contents of hash list...");
		hashTableChaining.printHashTable();

		System.out.println("Enter the word you want to search");
		int integerToSearch = utility.userInputInteger();

		if (hashTableChaining.contains(integerToSearch)) {
			hashTableChaining.remove(integerToSearch);
		}

		else {
			hashTableChaining.insert(integerToSearch);
		}

		hashTableChaining.printHashTable();

	}

}
