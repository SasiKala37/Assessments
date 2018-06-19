package com.bridgelabz.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.bridgelabz.model.User;

public class Utility {
	public static Scanner scanner = new Scanner(System.in);

	public static String userInputString() {
		return scanner.next();
	}

	public static int userInputInteger() {
		return scanner.nextInt();
	}

	public static Double userInputDouble() {
		return scanner.nextDouble();
	}

	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}

	public static Long userInputLong() {
		return scanner.nextLong();
	}

	public static String userInputNextLine() {
		return scanner.nextLine();
	}

	public static Connection connections() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false", "root",
					"tiger");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static boolean validate(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		// System.out.println(password.matches(pattern));
		return password.matches(pattern);

	}

	public static User insert() {
		User user = new User();
		//user.setUserId(3);
		System.out.println("Enter Username without spaces");
		String name = Utility.userInputString();
		user.setUserName(name);
		System.out.println("Enter password");
		String pwd = Utility.userInputString();
		boolean valid = validate(pwd);
		if (valid) {
			user.setPassword(pwd);
			//return user;
		} else {
			System.out.println("password consists of upper, lower, special charecters,digits with minimum length 8");
			//return null;
			
		}
		return user;
	}
}
