/**
 * purpose: Test the login/registration application
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridgelabz.controller;

import com.bridgelabz.services.UserServices;
import com.bridgelabz.services.UserServicesImplementation;
import com.bridgelabz.util.Utility;

public class LoginApplication {

	public static void main(String[] args) {
		String statementType = args[0];
		UserServices userServices = new UserServicesImplementation(statementType);
		System.out.println("1:Register");
		System.out.println("2:login ");
		System.out.println("3:Forgot password");
		int i = 0;
		while (i < 5) {
			System.out.println("Enter your choice ");
			i = Utility.userInputInteger();
			switch (i) {
			case 1:
				userServices.register();
				break;
			case 2:
				userServices.login();
				break;
			case 3:
				userServices.forgotPassword();
				break;
			case 4:
				userServices.exit();
				break;
			}
			i++;
		}
	}

}
