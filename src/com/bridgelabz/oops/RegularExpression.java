/**
 * Purpose: program to Read in the following message: Hello <<name>>, We have your full name as <<full name>>
 * in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification 
 * Thank you BridgeLabz 01/01/2016. Use Regex to replace name, full name, Mobile#, and Date with proper value.
 * @author SasiKala
 * @version 1.0
 * @since -06-2018
 */
package com.bridgelabz.oops;

import com.bridgelabz.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter name");
		String name = utility.userInputString();
		System.out.println("Enter full name");
		String fullName = utility.userInputString();
		System.out.println("Enter phone number");
		String phoneNumber = utility.userInputString();
		/*
		 * System.out.println("Enter today date"); String
		 * date=utility.userInputString();
		 */
		Utility.replacementOfRegx(name, fullName, phoneNumber);

	}

}
