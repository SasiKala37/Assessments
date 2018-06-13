/** 
 * Purpose:Print the calender format using Queue 
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class CalenderQueue {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter month: ");
		int month=utility.userInputInteger();
		System.out.println("Enter year: ");
		int year=utility.userInputInteger();
		Utility.calenderQueue(month, year);

	}

}
