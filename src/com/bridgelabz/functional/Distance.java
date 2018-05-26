/** 
 * Purpose: prints the  distance from the point (x, y) to the origin (0, 0).
 * 
 * @author SasiKala
 * @version 1.0
 * @since 18-05-2018
 * 
 */
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Distance {

	public static void main(String[] args) {

		System.out.println("Enter the x and y co-ordinates");
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);

		double distance = Utility.findDistance(x, y);
		System.out.println("distance from (" + x + ", " + y + ") to (0, 0) = " + distance);
	}

}
