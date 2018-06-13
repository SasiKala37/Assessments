/** 
 * Purpose: Program which creates Banking Cash Counter where people come in to deposit Cash and withdraw Cash. Have an input panel 
 * to add people to Queue to either deposit or withdraw money and dequeue the people. Maintain the Cash Balance.
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class CashCounter {

	public static <T extends Comparable<T>> void main(String[] args) {

		Utility utility = new Utility();
		System.out.println("Enter number of persons:");
		int numberOfPersons = utility.userInputInteger();
		System.out.println("Enter the amount");
		double balance = utility.userInputDouble();
		utility.maintainCashBalance(numberOfPersons, balance);
	}

}
