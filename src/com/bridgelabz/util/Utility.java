
package com.bridgelabz.util;

import java.util.Scanner;

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

	public static boolean validate(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      //System.out.println(password.matches(pattern));
		return password.matches(pattern);
		
	}

}
