/**
* Purpose: Print the triplet sum 
*  
* @author SasiKala
* @version 1.0
* @since 19-05-2018
* 
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Triplets {
	public static void main(String[] args) {
		Utility utility = new Utility();

		System.out.println("Enter the triplet sum");
		int tripletSum = utility.userInputInteger();
		utility.sumOfTriplets(tripletSum);
	}
}
