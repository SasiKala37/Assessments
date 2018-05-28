package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class VendingMachine {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter some amount");
		int amount=utility.userInputInteger();
		Utility.generateChange(amount);
	}

}
