package com.bridgelabz.datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.bridgelabz.utility.Utility;

public class Hashing {

	public static void main(String[] args) throws Exception {
		Utility utility=new Utility();
	
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
	               
	                 new HashTableChaining(12);
	               Integer[] sortedArray= Utility.insertionSort(array1);
	                for (int i = 0; i < sortedArray.length; i++) {
	                    HashTableChaining.insert(sortedArray[i]);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	        System.out.println("Contents of hash list...");
	        HashTableChaining.printHashTable ();
	       
	       
	        System.out.println("Enter the word you want to search");
	        int integerToSearch = utility.userInputInteger();
	       
	        if(HashTableChaining.contains(integerToSearch)) {
	            HashTableChaining.remove(integerToSearch);
	        }
	       
	        else {
	            HashTableChaining.insert(integerToSearch);
	        }

	       
	        HashTableChaining.printHashTable ();
	       
	    
	}

}
