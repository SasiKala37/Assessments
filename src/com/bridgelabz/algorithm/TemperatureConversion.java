/**
 * Purpose: To convert the temperature celcius to fahrenheit vice versa
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class TemperatureConversion {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the temperature in celsius");
		double temperatureInCelsius = utility.userInputDouble();
		double fahrenheit = Utility.celsiusToFahrenheit(temperatureInCelsius);
		System.out.println("faherenheit temperature: " + fahrenheit);
		System.out.println("Enter the temperature in fahrenheit");
		double temperatureInFahrenheit = utility.userInputDouble();
		double celsius = Utility.fahrenheitToCelsius(temperatureInFahrenheit);
		System.out.println("celcius Tempreture:" + celsius);
	}
}
