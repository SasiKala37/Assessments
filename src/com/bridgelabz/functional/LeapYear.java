/** 
 * Purpose: print the given year is leap year or not
 * 
 * @author SasiKala
 * @version 1.0
 * @since 16-05-2018
 * 
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class LeapYear {
	public static void main(String[] args) {

		Utility utility = new Utility();
		System.out.println("Enter the year");
		String year = utility.userInputString();

		String message = Utility.leapYearChecker(year);
		System.out.println(message);
	}

}
