/** 
 * Purpose: To find the roots of the quadratic equation
 * 
 * @author SasiKala
 * @version 1.0
 * @since 18-05-2018
 * 
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class QuadraticEquation {

	public static void main(String[] args) {
		Utility utility = new Utility();

		System.out.println("Enter the a, b, c values");
		int a = utility.userInputInteger();
		int b = utility.userInputInteger();
		int c = utility.userInputInteger();

		Utility.findingRoots(a, b, c);

	}

}
