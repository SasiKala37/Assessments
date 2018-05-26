/** 
 * Purpose: Replace the string template "Hello <<UserName>>, How are you?"
 * 
 * @author SasiKala
 * @version 1.0
 * @since 16-05-2018
 * 
 */

package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class StringReplace {

	public static void main(String[] args){
		Utility utility = new Utility();

		String userName;
		System.out.println("Enter the UserName");
		userName = utility.userInputString();

		String output = utility.stringReplace(userName);
		System.out.println(output);
	}
}
