/*
 * 
 * Purpose: prints the wind chill at the given temperature and wind speed  
 * 
 * @author SasiKala
 * @version 1.0
 * @since 16-05-2018
 * 
 */

package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class WindChill {
	public static void main(String[] args) {

		double temperature = Double.parseDouble(args[0]);
		double windSpeed = Double.parseDouble(args[1]);
		double windChill = Utility.computeWindChill(temperature, windSpeed);
		if (temperature < 50 && (windSpeed > 3 || windSpeed < 120)) {
		String myMessage= "Wind chill: " + windChill;
			System.out.println(myMessage);
		} else {
			System.out.println("values is not valid");
		}
	}
}
