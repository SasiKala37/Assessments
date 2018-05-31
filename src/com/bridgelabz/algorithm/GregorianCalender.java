/**
 * Purpose: To print the day of week using 
 * y0 = y − (14 − m) / 12
 * x = y0 + y0/4 − y0/100 + y0/400
 * m0 = m + 12 × ((14 − m) / 12) − 2
 * d0 = (d + x + 31m0 / 12) mod 7
 *
 * @author sasikala
 * @version 1.0
 * @since 22/05/2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class GregorianCalender {

	public static void main(String[] args) {
		int day = Integer.parseInt(args[0]);

		int month = Integer.parseInt(args[1]);

		int year = Integer.parseInt(args[2]);
		boolean keepGoing=true;
		int dayNumber=Utility.dayOfWeek(day, month, year);
		String result = "";
		while(keepGoing) {
		switch (dayNumber) {
		case 0:
			result += "sunday";
			break;
		case 1:
			result += "monday";
			break;
		case 2:
			result += "tuesday";
			break;
		case 3:
			result += "wednesday";
			break;
		case 4:
			result += "thursday";
			break;
		case 5:
			result += "friday";
			break;
		case 6:
			result += "satday";
			break;
		default:
			System.out.println("Nothing");
			break;
		}
		System.out.println("The day of the week is " + result);
		keepGoing = false;
	}
		
	}

}
