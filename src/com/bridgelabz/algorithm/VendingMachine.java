/**
 * Purpose: Find the Fewest Notes to be returned for Vending Machine
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class VendingMachine {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter some amount");
		int amount=utility.userInputInteger();
		int numberOfNotes=Utility.generateChange(amount);
		System.out.println("number of notes: "+numberOfNotes);
	}

}
