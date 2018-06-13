/** 
 * Purpose: Write a Stack Class to push open parenthesis “(“ and pop closed parenthesis “)”.
 *  At the End of the Expression if the Stack is Empty then the Arithmetic Expression is Balanced
 * 
 * @author SasiKala
 * @version 1.0
 * @since -05-2018
 * 
 */
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
