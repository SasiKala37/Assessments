/**
 * Purpose: Convert the decimal number to binary number with padding of 4 bits
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class DecimalToBinary {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter decimal number");
		int decimalNumber=utility.userInputInteger();
		StringBuilder byteString=Utility.toBinary(decimalNumber);
		System.out.println("Result in binary: "+byteString);

	}

}
