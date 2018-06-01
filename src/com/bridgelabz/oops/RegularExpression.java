package com.bridgelabz.oops;

import com.bridgelabz.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter name");
		String name=utility.userInputString();
		System.out.println("Enter full name");
		String fullName=utility.userInputString();
		System.out.println("Enter phone number");
		String phoneNumber=utility.userInputString();
		/*System.out.println("Enter today date");
		String date=utility.userInputString();*/
		Utility.replacementOfRegx(name,fullName,phoneNumber);

	}

}
