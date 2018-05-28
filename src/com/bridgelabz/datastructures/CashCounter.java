package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class CashCounter {

	public static<T extends Comparable<T>> void main(String[] args) {
		
		Utility utility=new Utility();
		System.out.println("Enter number of persons:");
		int numberOfPersons=utility.userInputInteger();
		System.out.println("Enter the amount");
		double balance=utility.userInputDouble();
		utility.maintainCashBalance(numberOfPersons, balance);
	}

}

