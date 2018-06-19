package com.bridgelabz.controller;

import java.sql.SQLException;

import com.bridgelabz.sample.Utility;
import com.bridgelabz.service.UserService;
import com.bridgelabz.serviceimpl.UserServiceImpl;

public class LoginForm {

	public static void main(String[] args) throws SQLException {
		UserService userService=new UserServiceImpl();
		System.out.println("1:LOGIN FORM");
		System.out.println("2:REGISTER FORM");
		System.out.println("3:FORGOT PASSWORD");
		int choice=0;
		while(choice<4) {
			System.out.println("Enter your choice");
			choice=Utility.userInputInteger();
			switch(choice) {
			case 1: userService.login();
			break;
			case 2:userService.register();
			break;
			case 3:System.out.println("Enter user name without spaces");
			String name = Utility.userInputString();
			userService.forgotPassword(name);
			break;
			default:System.out.println("VISIT AGAIN !!!!!!");
			}choice++;
		}
		/*//
		
		//userService.
*/	}

}
