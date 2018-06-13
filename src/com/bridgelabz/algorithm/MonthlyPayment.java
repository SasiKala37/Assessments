/**
 * Purpose: Calculate the monthly payment of the person's
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */

package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MonthlyPayment {

	public static void main(String[] args) {
		double principleAmount = Double.parseDouble(args[0]);
		double rateOfIntrest = Double.parseDouble(args[1]);
		double year = Double.parseDouble(args[2]);
		double payment = Utility.paymentCalculation(principleAmount, rateOfIntrest, year);
		System.out.println("Payment: " + payment);
	}

}
