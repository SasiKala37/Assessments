/** 
 * Purpose:Print the calendar format using Stack
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class StackCalender {

	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("Enter month: ");
		int month=utility.userInputInteger();
		System.out.println("Enter year: ");
		int year=utility.userInputInteger();
		Utility.calenderStack(month, year);
	}

}
