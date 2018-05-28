package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class GuessNumber {

	public static void main(String[] args) {
		Utility utility=new Utility();
		int n=Integer.parseInt(args[0]);
		int N=(int)Math.pow(2, n);
		System.out.println("Think of an integer between"+0+" and "+(N-1));
		int secret=utility.searchGuessNumber(0, N);
		System.out.println("Your number is "+secret);
	}

}
