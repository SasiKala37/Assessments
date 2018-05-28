package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

public class BalancedParenthesis {

	public static void main(String[] args) {

		Utility utility = new Utility();
		System.out.println("Enter the Arithmetic expression");
		String expression = utility.userInputString();
		utility.checkBalancedParenthesis(expression);
	}

}
