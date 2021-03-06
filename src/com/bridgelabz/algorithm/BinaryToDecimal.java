/**
 * Purpose: Convert binary to decimal after swapping the nibbles
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter decimal number");
		int decimalNumber=utility.userInputInteger();
		int binaryValue=Utility.binary(decimalNumber);
		if(binaryValue!=-1) {
			System.out.println("Binary Value: "+binaryValue);
		}
		else {
			System.out.println("Nothing");
		}
		
	}

}
