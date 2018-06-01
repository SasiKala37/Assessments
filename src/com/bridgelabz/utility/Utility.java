/*********************************************************************************
 * 
 * Purpose: Utility methods for all the programs
 * 
 * @author SasiKala
 * @version 1.0
 * @since 16-05-2018
 * 
 * *******************************************************************************
 */
package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.datastructures.Deque;
import com.bridgelabz.datastructures.LinkedList;
import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.datastructures.SortedLinkedList;
import com.bridgelabz.datastructures.Stack;
import com.bridgelabz.datastructures.StackReverse;

public class Utility {

	public Scanner scanner = new Scanner(System.in);
	LinkedList<String> linkedList = new LinkedList<>();
	Stack<Character> stack = new Stack<>();
	Queue<Integer> queue = new Queue<>();
	Deque<Character> deque = new Deque<>();
	SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();

	public String userInputString() {
		return scanner.next();
	}

	public int userInputInteger() {
		return scanner.nextInt();
	}

	public Double userInputDouble() {
		return scanner.nextDouble();
	}

	public boolean userInputBoolean() {
		return scanner.nextBoolean();
	}

	/**
	 * Replace with the String template
	 * 
	 * @param userName
	 * @return
	 */
	public String stringReplace(String userName) {

		String givenString = "Hello <<username>>, How are you?";
		return givenString.replaceAll("<<username>>", userName);
	}

	/**
	 * Calculate the head and tail percentage when flapping the coin randomly
	 * 
	 * @param noOfFlips
	 *            toss the coin number of times
	 */
	public static void flipCoin(int noOfFlips) {
		int heads = 0;
		int tails = 0;

		double randomNumber = 0;

		for (int i = 0; i <= noOfFlips; i++) {
			randomNumber = Math.random();

			if (randomNumber > 0.5) {
				tails++;
			} else {
				heads++;
			}
		}

		double headPerc = (heads * 100) / noOfFlips;
		double tailPerc = (tails * 100) / noOfFlips;
		System.out.println("Head Percentage: " + headPerc);
		System.out.println("tail Percentage: " + tailPerc);
	}

	/**
	 * checking given year is leap year or not
	 * 
	 * @param year
	 *            4 digit number
	 * @return leap year or notF
	 */
	public static String leapYearChecker(String year) {

		boolean isLeapYear = false;
		if (year.length() == 4) {
			int n = Integer.parseInt(year);
			if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) {
				isLeapYear = true;
			} else {
				isLeapYear = false;
			}
			if (isLeapYear) {
				return year + "is the leapyear";
			} else {
				return year + "is not the leapyear";
			}
		} else
			return "Entered year is not the 4 digit number";
	}

	/**
	 * printing power of two table
	 * 
	 * @param N
	 *            print 2 power table up to the limitF
	 */
	public static void powerOfTwo(int N) {
		double result = 0;
		for (int i = 0; i <= N; i++) {
			result = Math.pow(2, i);
			System.out.println(2 + "^" + i + "=" + result);
		}
	}

	/**
	 * calculate the nth term number in the harmonic series
	 * 
	 * @param nthTermNumber
	 *            to calculate the harmonic value
	 * @return nth harmonic value
	 */
	public static double nthHarmonicValue(int nthTermNumber) {
		double result = 0;
		for (int i = 1; i <= nthTermNumber; i++) {
			result += (double) (1.0) / i;
		}
		return result;
	}

	/**
	 * calculate the prime factors of given number
	 * 
	 * @param N
	 *            calculate the prime factors of N
	 */
	public void primeFactors(int N) {
		for (int i = 2; i * i <= N; i++) {
			int result = N % i;
			while (result == 0) {
				System.out.print(i + "  ");
				N = N / i;
			}
		}
		if (N > 1) {
			System.out.print(N);
		}
	}

	/**
	 * find the distance from (x,y) to (0,0)
	 * 
	 * @param x
	 *            co-ordinate value
	 * @param y
	 *            co-ordinate value
	 * @return distance from (x,y) to (0,0)
	 */
	public static double findDistance(int x, int y) {
		return Math.sqrt((x * x) + (y * y));
	}

	/**
	 * calculate the roots for quadratic equation given quadratic equation
	 * a*x*x+b*x+c
	 * 
	 * @param a
	 *            coefficient of x^2
	 * @param b
	 *            coefficient of x
	 * @param c
	 *            constant
	 */
	public static void findingRoots(int a, int b, int c) {
		double delta = (b * b) - (4 * a * c);
		double rootOfx = (-b) / (2 * a);
		if (delta > 0) {
			double root1Ofx = (-b + Math.sqrt(delta)) / (2 * a);
			double root2Ofx = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("Roots are real and different: " + root1Ofx);
			System.out.print(root2Ofx);

		} else if (delta == 0) {
			System.out.println("Roots are real and same: " + rootOfx);
		} else {
			System.out.println("Roots are complex: " + (rootOfx) + "+i" + Math.sqrt(Math.abs(delta)));
		}

	}

	/**
	 * Compute the windChill using given formula
	 * 
	 * @param temprature
	 *            below 50
	 * @param windspeed
	 *            3< winwindspeed >120
	 * @return wind chill
	 */
	public static double computeWindChill(double temperature, double windSpeed) {
		return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
	}

	/**
	 * get the random number from given number n to n-1
	 * 
	 * @param number
	 *            to get random value
	 * @return random number
	 */
	public static int getCoupon(int number) {
		Random random = new Random();
		return (random.nextInt()) * number;
	}

	/**
	 * find the distinct coupon numbers
	 * 
	 * @param randomNumber
	 *            check the distinctNumber less than randomNumber
	 */
	public static int distinctCouponNumber(int randomNumber) {
		int count = 0;
		int distinctNumber = 0;
		boolean[] isCollected = new boolean[randomNumber];
		
		while (distinctNumber < randomNumber) {
			int value = getCoupon(randomNumber);
			count++;
			if (!isCollected[value]) {
				distinctNumber++;
				System.out.println(value);
				isCollected[value] = true;
			}
			
		}
		return count;
	}

	/**
	 * calculate the percentage of win and loss gambler
	 * 
	 * @param stake
	 *            sum amount
	 * @param goal
	 *            reach the stake
	 * @param numberOfTrails
	 *            number of times to play the game
	 */
	public static void gamblGoal(int stake, int goal, int numberOfTrails) {

		int bets = 0; // total number of bets made
		int wins = 0; // total number of games won

		for (int t = 0; t < numberOfTrails; t++) {
			int cash = stake;
			while (cash > 0 && cash < goal) {
				bets++;
				if (Math.random() < 0.5) {
					cash++;
				} else {
					cash--;
				}
			}
			if (cash == goal) {
				wins++;
			}
		}
		System.out.println(wins + " wins of " + numberOfTrails);
		System.out.println("Percentage of games won = " + (100.0 * wins) / numberOfTrails);
		System.out.println("Avg # bets           = " + (1.0 * bets) / numberOfTrails);
	}

	/**
	 * calculate the permutation of string using iterative method
	 * 
	 * @param input
	 *            to find the number of permutations of string
	 * @param startIndex
	 *            first index of the input
	 * @param endIndex
	 *            last index of the inputs
	 */
	public static void permutation(String input, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.println(input);
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				input = swapInputString(input, startIndex, i);
				permutation(input, startIndex + 1, endIndex);
				input = swapInputString(input, startIndex, i);
			}
		}
	}

	/**
	 * Swap the string based on index
	 * 
	 * @param input
	 *            string to swap the indexes
	 * @param startIndex
	 *            first index of the input
	 * @param position
	 *            to swap the index with that positionF
	 * @return string after swap
	 */
	public static String swapInputString(String input, int startIndex, int position) {
		char[] charArray = input.toCharArray();
		char temp;
		temp = charArray[startIndex];
		charArray[startIndex] = charArray[position];
		charArray[position] = temp;

		return String.valueOf(charArray);
	}

	/**
	 * compute the elapsed time using stop watch
	 * 
	 * @return elapsed time between start and end time
	 */
	public long findElapseTime() {
		System.out.println(" the start time, type start");
		userInputString();
		long startTime = System.currentTimeMillis();
		System.out.println("The end time, type end ");
		userInputString();
		return System.currentTimeMillis() - startTime;
	}

	/**
	 * calculating triplet sum using array values
	 * 
	 * @param tripletSum
	 *            3 integers sum
	 */
	public void sumOfTriplets(int tripletSum) {
		int count = 0;
		System.out.println("Enter the array of integers");
		int[] arrayOfIntegers = new int[6];
		for (int r = 0; r < arrayOfIntegers.length; r++) {
			arrayOfIntegers[r] = userInputInteger();
		}

		for (int i = 0; i < arrayOfIntegers.length - 2; i++) {
			for (int j = i + 1; i < arrayOfIntegers.length - 1; j++) {
				for (int k = j + 1; k < arrayOfIntegers.length; k++) {
					if ((arrayOfIntegers[i] + arrayOfIntegers[j] + arrayOfIntegers[k]) == tripletSum) {
						count++;
						System.out.println(arrayOfIntegers[i] + "  " + arrayOfIntegers[j] + "  " + arrayOfIntegers[k]);
					}
				}
			}
		}
		System.out.println("Number of triplets: " + count);
	}

	/**
	 * Read the 2D integer array from the user and print the array of elements
	 * 
	 * @param rowSize
	 *            number of rows
	 * @param columnSize
	 *            number of columns
	 */
	public void readArrayOfIntegers(int rowSize, int columnSize) {
		int array[][] = new int[rowSize][columnSize];
		System.out.println("Read the integer array values");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				array[i][j] = userInputInteger();
			}
		}
		System.out.println("Print the Array of integers");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Read the 2D double array from the user and print the array of elements
	 * 
	 * @param rowSize
	 *            number of rows
	 * @param columnSize
	 *            number of columns
	 */
	public void readArrayOfDouble(int rowSize, int columnSize) {
		double array[][] = new double[rowSize][columnSize];
		System.out.println("Read the double type array values");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				array[i][j] = userInputDouble();
			}
		}
		System.out.println("Print the Array of double values");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Read the 2D boolean array from the user and print the array of elements
	 * 
	 * @param rowSize
	 *            number of rows
	 * @param columnSize
	 *            number of columns
	 */
	public void readArrayOfBoolean(int rowSize, int columnSize) {
		boolean array[][] = new boolean[rowSize][columnSize];
		System.out.println("Read the boolean type array values");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				array[i][j] = userInputBoolean();
			}
		}
		System.out.println("Print the Array of boolean values");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				if (array[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * check whether the given strings are anagram or not
	 * 
	 * @param firstString
	 *            to compare with second string
	 * @param secondString
	 *            to compare with first string
	 * @return true/false if two strings are anagram or not
	 */
	public static <T extends Comparable<T>> boolean isAnagram(String firstString, String secondString) {
		firstString = removeSpace(firstString);
		secondString = removeSpace(secondString);
		if (firstString.length() != secondString.length()) {
			return false;
		}
		firstString = firstString.toLowerCase();
		secondString = secondString.toLowerCase();
		boolean result = checkString(firstString, secondString);
		return result;

	}

	/**
	 * Remove the space in given String
	 * 
	 * @param inputString
	 *            to remove the spaces in input string
	 * @return returns the string without spaces
	 */
	public static String removeSpace(String inputString) {
		String input = inputString;
		char[] charString = input.toCharArray();
		input = "";
		for (int i = 0; i < charString.length; i++) {
			if (charString[i] != ' ') {
				input = input + charString[i];
			}
		}
		return input;
	}

	/**
	 * check whether the given strings are having same characters or not
	 * 
	 * @param firstString
	 *            to compare with second string
	 * 
	 * @param secondString
	 *            to compare with first string
	 * @return true/false if strings are equal or not
	 */
	public static boolean checkString(String firstString, String secondString) {
		char[] charString1 = firstString.toCharArray();
		char[] charString2 = secondString.toCharArray();
		charString1 = sortChar(charString1);
		charString2 = sortChar(charString2);

		for (int i = 0; i < charString1.length; i++) {
			if (charString1[i] != charString2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * sort the characters in ascending order
	 * 
	 * @param charString
	 *            to sort the characters in an array
	 * @return sorted chararrary
	 */
	public static char[] sortChar(char[] charString) {
		for (int i = 0; i < charString.length; i++) {
			for (int j = i + 1; j < charString.length; j++) {
				if (charString[i] > charString[j]) {
					char temp = charString[i];
					charString[i] = charString[j];
					charString[j] = temp;
				}
			}
		}
		return charString;
	}

	/**
	 * find the prime numbers in the between the given range 1-1000
	 * 
	 * @param higherLimit
	 *            print primes up to higher limit
	 */
	public static int[] findPrimeNumbers(int higherLimit) {
		int count;
		int k = 0;
		int[] primeArray = new int[260];
		for (int i = 1; i <= higherLimit; i++) {
			count = 0;
			for (int j = 1; j <= higherLimit; j++) {
				if (i % j == 0)
					count++;
			}
			if (count == 2) {
				// System.out.println(i);
				primeArray[k++] = i;
			}
			// isPalindrome(primeArray);
		}
		return primeArray;
	}

	/**
	 * check the given primeArray elements whether palindrome or not
	 * 
	 * @param primeArray
	 *            to check the palindrome or not
	 */
	public static int[] isPalindrome(int[] primesAnagram) {
		// System.out.println("Palindrome number");
		int[] palindrome = new int[primesAnagram.length];
		int j = 0;
		for (int i = 0; i < primesAnagram.length; i++) {

			int var = primesAnagram[i];
			int num = primesAnagram[i];
			int reverseNumber = 0;
			while (num > 0) {
				reverseNumber = reverseNumber * 10 + num % 10;
				num = num / 10;
			}
			if (reverseNumber == var) {
				palindrome[j++] = var;
				// System.out.println(var);
			}
		}
		return palindrome;
	}

	public static int[] primesAnagram(int[] prime) {
		int[] primes = prime;
		int[] anagram = new int[primes.length];
		int k = 0;
		for (int i = 0; i < primes.length - 1; i++) {
			if (prime[i] == 0) {
				break;
			}
			for (int j = i + 1; j < primes.length; j++) {
				if (isAnagram(Integer.toString(primes[i]), Integer.toString(primes[j]))) {
					anagram[k++] = primes[i];
					anagram[k++] = primes[j];
				}
				if (primes[i] == 0) {
					break;
				}
			}
		}
		return anagram;
	}

	/**
	 * guessing the number to enter true or false answer
	 * 
	 * @param low
	 *            lower limit start with 0
	 * @param high
	 *            pass high as 2^n-1
	 * @return guessing value
	 */
	public int searchGuessNumber(int low, int high) {
		if (high - low == 1) {
			return low;
		}
		int mid = low + (high - low) / 2;
		System.out.println("Is it less than " + mid);
		if (userInputBoolean()) {
			return searchGuessNumber(low, mid);
		} else {
			return searchGuessNumber(mid, high);
		}

	}

	/**
	 * generate the notes in descending order
	 * 
	 * @param amount
	 *            to generate notes equal to the amount
	 */
	public static void generateChange(int amount) {
		int[] ar = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000 };
		int temp = 0;
		int index = 0;
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (amount == ar[i]) {
				System.out.println("The amount note ");
				System.out.println(amount);
				count++;
				return;
			}
		}

		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (amount < ar[j] && amount > ar[j] || amount > ar[i]) {
					temp = ar[i];
					index = i;
					break;
				}
			}
		}

		System.out.print(temp + "  ");
		int goal = amount - temp;
		for (int i = index; i >= 0; i--) {
			if (goal == ar[i]) {
				System.out.print(ar[i] + "  ");
				return;
			}

		}
		generateChange(goal);
	}

	/**
	 * convert celsius to fahrenheit temperature
	 * 
	 * @param temperatureInCelsius
	 *            celcius temperature to convert fahrenheit
	 * @return fahrenheit temperature
	 */
	public static double celsiusToFahrenheit(double temperatureInCelsius) {
		return (temperatureInCelsius * 9 / 5) + 32;
	}

	/**
	 * convert fahrenheit to celsius temperature
	 * 
	 * @param temperatureInFahrenheit
	 *            fahrenheit temperature to convert celcius
	 * @return the celsius temprature
	 */
	public static double fahrenheitToCelsius(double temperatureInFahrenheit) {
		return (temperatureInFahrenheit - 32) * 5 / 9;
	}

	/**
	 * calculate the monthly payment using given formula
	 * payment=(p*r)/(1-(1+r)^(-n))
	 * 
	 * @param principleAmount
	 *            total amount
	 * @param rateOfIntrest
	 *            pass the interest
	 * @param year
	 *            pass number of year
	 * @return
	 */
	public static double paymentCalculation(double principleAmount, double rateOfIntrest, double year) {
		double r = rateOfIntrest / (12 * 100);
		double n = 12 * year;
		double power = Math.pow((1 + r), (-n));
		return (principleAmount * r) / (1 - power);

	}

	/**
	 * calculate the square root of non negative number
	 * 
	 * @param c
	 *            non negative number to find square root
	 */
	public static void sqrt(double c) {
		double epsilon = 1e-15;
		double t = c;

		while (Math.abs(t - c / t) > epsilon * t) {
			t = (c / t + t) / 2.0;
		}
		System.out.println(t);
	}

	/***
	 * check whether the given input is correct or not then calculate the day of
	 * week
	 * 
	 * @param day
	 *            pass day between 1 to 31
	 * @param month
	 *            month between 1 to 12
	 * @param year
	 *            pass the 4 digit number
	 */
	public static int dayOfWeek(int day, int month, int year) {

		boolean keepGoing = true;
		int d0 = 0;
		while (keepGoing) {
			if ((month <= 1 || month >= 12)) {
				System.out.println("Months are between 1 and 12");
				continue;
			}

			if (day < 1 || day > 31) {
				System.out.println("Days are between 1 and 31");
				continue;
			}

			if (year < -10000 || year > 10000) {
				System.out.println("Years are between -10000 and 10000");
				continue;
			}

			int y0 = year - (14 - month) / 12;
			int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
			int m0 = month + 12 * ((14 - month) / 12) - 2;
			d0 = (day + x + 31 * m0 / 12) % 7;
			keepGoing = false;

		}
		return d0;
	}

	/**
	 * convert the decimal to binary
	 * 
	 * @param number
	 *            pass decimal number to convert binary
	 * @return binary number
	 */
	public static StringBuilder toBinary(int number) {
		String paddingZero = "";

		while (number != 0) {
			int remainder = number % 2;
			paddingZero = remainder + paddingZero;
			number = number / 2;
		}

		int size = paddingZero.length();
		int temp = size;
		while (size % 4 != 0) {
			size++;
		}
		int diff = size - temp;
		for (int i = 1; i <= diff; i++) {
			paddingZero = '0' + paddingZero;
		}

		int count = 0;
		StringBuilder sb = new StringBuilder(paddingZero);
		for (int i = 0; i < paddingZero.length(); i++) {
			count++;
			if (count == 5) {
				sb.insert(i, " ");
				count = 0;
			}
		}
		return sb;
	}

	/**
	 * swap the two nibbles
	 * 
	 * @param decimalnumber
	 *            pass decimal number to swap the nibbles
	 * @return decimal value after swap the nibbles
	 */
	public static int binary(int decimalnumber) {
		if (decimalnumber < 127) {
			StringBuilder stringBuilder = toBinary(decimalnumber);
			String newString = stringBuilder.toString();
			System.out.println(newString);
			int size = newString.length();
			String[] array = new String[size];
			array = newString.split(" ");

			String temp = array[0];
			array[0] = array[1];
			array[1] = temp;
			String stringBack = "";
			for (int i = 0; i < array.length; i++) {
				stringBack += array[i];
			}
			stringBack.replaceAll("\\s", "");
			System.out.println("After swapping: ");
			System.out.println(stringBack);
			int decimal = binaryToDecimal(stringBack);

			return decimal;
		} else
			return -1;
	}

	/**
	 * Method to convert binary to decimal
	 * 
	 * @param string
	 *            it is a binary format number to convert decimal
	 * @return decimal value of binary
	 */
	public static int binaryToDecimal(String string) {
		int number = Integer.parseInt(string);
		int count = 0;
		int out = 0;
		while (number != 0) {
			int rem = number % 10;
			out = (int) (out + rem * Math.pow(2, count++));
			number = number / 10;

		}
		return out;

	}

	/********************************************************************************************
	 * search the specific data using binary search
	 * 
	 * @param arrayData
	 *            reading array of elements
	 * @param searchElement
	 *            the which element user want to search
	 * @param low
	 *            array first index
	 * @param high
	 *            array last index
	 * @return it returns true or false whether the search element is found or not
	 */
	public static <T extends Comparable<T>> Integer search(T[] arrayData, T searchElement, int low, int high) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (arrayData[mid] == searchElement) {
				return mid;
			} else if (arrayData[mid].compareTo(searchElement) > 0) {
				return search(arrayData, searchElement, low, mid - 1);
			} else {
				return search(arrayData, searchElement, mid + 1, high);
			}

		}
		return -1;
	}

	/**
	 * sort the data using bubble sort technique
	 * 
	 * @param data
	 *            data array
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j + 1].compareTo(data[j]) < 0) {
					T temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted data");
		printData(data);
	}

	/**
	 * print data print the array of data
	 * 
	 * @param data
	 *            array data
	 */
	public static <T extends Comparable<T>> void printData(T[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Sort the data based on key value(insertion sort)
	 * 
	 * @param data
	 *            array data to sort
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] data) {
		for (int i = 0; i < data.length; i++) {
			T key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j].compareTo(key) > 0) {
				data[j + 1] = data[j];
				j = j - 1;

			}
			data[j + 1] = key;
		}
		// System.out.println("Sorted data");
		// printData(data);
		return data;

	}

	/**
	 * compare the elements in the sub array then merging the two sub array into
	 * single array
	 * 
	 * @param data
	 *            array of data
	 * @param low
	 *            array first index
	 * @param mid
	 *            array last index
	 * @param high
	 */
	public static <T extends Comparable<T>> void merge(T[] data, int low, int mid, int high) {

		// Find sizes of two sub arrays to be merged
		int size1 = mid - low + 1;
		int size2 = high - mid;

		// Create temperary arrays
		String leftArray[] = new String[size1];
		String rightArray[] = new String[size2];

		/* Copy data to temprary arrays */
		for (int i = 0; i < size1; ++i)
			leftArray[i] = (String) data[low + i];
		for (int j = 0; j < size2; ++j)
			rightArray[j] = (String) data[mid + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second sub arrays
		int i = 0, j = 0;

		// Initial index of merged sub array array
		int k = low;
		while (i < size1 && j < size2) {
			if (leftArray[i].compareTo(rightArray[j]) <= 0) {
				data[k] = (T) leftArray[i];
				i++;
			} else {
				data[k] = (T) rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < size1) {
			data[k] = (T) leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < size2) {
			data[k] = (T) rightArray[j];
			j++;
			k++;
		}
	}

	/**
	 * Sort the data
	 * 
	 * @param data
	 *            Array of data
	 * @param low
	 *            array first index
	 * @param high
	 *            array first index
	 */
	public static <T extends Comparable<T>> void sort(T[] data, int low, int high) {
		if (low < high) {
			// Find the middle point
			int mid = (low + high) / 2;

			// Sort first and second halves
			sort(data, low, mid);
			sort(data, mid + 1, high);

			// Merge the sorted halves
			merge(data, low, mid, high);
		}
		printData(data);
	}

	/**
	 * to find the word in file using binary search technique
	 * 
	 * @param searchString
	 *            search the string in file content
	 * @throws IOException
	 *             it handle the file not found exception
	 */
	public void searchWord(String searchString) throws IOException {
		String filePath = "/home/bridgelabz/sasi-txtdocuments/names.txt";
		String line = "";
		int result;

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(",");
				bubbleSort(words);
				result = search(words, searchString, 0, words.length - 1);

				if (result == -1) {
					System.out.println("search element found");
				} else {
					System.out.println("Search elements not found");
				}

				// bufferedReader.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * check whether the given expression is balanced parenthesis or not
	 * 
	 * @param expression
	 *            it is regular expression pass as parameter
	 */
	public void checkBalancedParenthesis(String expression) {
		char[] expOperand = expression.toCharArray();
		int size = 0;
		for (int i = 0; i < expOperand.length; i++) {
			if (expOperand[i] == '(') {
				stack.push(expOperand[i]);
				size++;
			}
			if (expOperand[i] == ')') {
				stack.pop();
				size--;
			}

		}
		if (size == 0) {
			System.out.println("Arithmetic expression is Balanced\n" + stack.isEmpty());
		} else {
			System.out.println("Arithmetic expression is unBalanced " + stack.isEmpty());
		}
	}

	/**
	 * calculate the cash balance in account
	 * 
	 * @param numberOfPersons
	 *            number of persons present in the queue
	 * @param balance
	 *            pass the user account available balance
	 */
	public void maintainCashBalance(int numberOfPersons, double balance) {
		int n = numberOfPersons;
		double result = balance;
		int[] person = new int[n];
		double withdraw;
		double deposit;
		for (int i = 1; i <= person.length; i++) {
			queue.enqueue(i);
		}
		for (int i = 1; i <= person.length; i++) {
			System.out.println("Queue opertions");
			System.out.println("1: withdraw");
			System.out.println("2.Deposit");
			System.out.println("Enter your choice");
			int choice = userInputInteger();
			switch (choice) {
			case 1:
				System.out.println("Enter the amount to withdraw");
				withdraw = userInputDouble();
				if (result >= withdraw) {
					result = result - withdraw;
					System.out.println("cacsh balance:" + result);
				} else {
					System.out.println("Insufficient balance");
				}
				queue.dequeue();
				break;
			case 2:
				System.out.println("Enter the amount to deposit");
				deposit = userInputDouble();
				result = result + deposit;
				System.out.println("cacsh balance:" + balance);
				queue.dequeue();
				break;
			default:
				System.out.println("input mismatch");
				break;
			}
		}
	}

	/**
	 * check whether the given input is palindrome or not
	 * 
	 * @param input
	 *            this parameter passed to check palindrome or not
	 * @return true/false if it is palindrome or not
	 */
	public boolean checkPalindrome(String input) {

		char[] inputChar = input.toCharArray();
		boolean equalChars = true;
		char first;
		char last;
		for (int i = 0; i < inputChar.length; i++) {
			deque.insertAtRear(inputChar[i]);
		}

		while (deque.size() > 1 && equalChars) {
			first = deque.dequeueAtFront();
			last = deque.dequeueAtRear();

			if (first == last) {
				equalChars = true;
			}
		}
		return equalChars;
	}

	/**
	 * Search the data if it is present then remove otherwise add it into the file
	 * 
	 * @param searchData
	 *            it is pass to search whether it is present or not
	 * @throws FileNotFoundException
	 *             it throw this exception when file is not found
	 */
	public void unorderedFile(String searchData) throws FileNotFoundException {
		File file = new File("/home/bridgelabz/sasi-txtdocuments/names.txt");

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(",");
				for (int i = 0; i < words.length; i++) {
					linkedList.addLast(words[i]);

				}
			}
			bufferedReader.close();
			System.out.println("File content:");
			linkedList.traverse();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (linkedList.search(searchData)) {
			linkedList.remove(searchData);
		} else {
			linkedList.addLast(searchData);
		}
		System.out.println("Edited file content");
		linkedList.traverse();
		PrintWriter printWriter = new PrintWriter(file);
		for (int i = 1; i <= linkedList.size(); i++) {
			String word = linkedList.getIndexValue(i);
			printWriter.print(word + ",");
		}
		printWriter.close();
	}

	/**
	 * Search the data if it is present then remove otherwise add it into the file
	 * 
	 * @param searchNumber
	 *            it is pass to search whether it is present or not
	 * @throws FileNotFoundException
	 *             it throw this exception when file is not found
	 */
	public void orderedFile(int searchNumber) throws FileNotFoundException {
		File file = new File("/home/bridgelabz/sasi-txtdocuments/numbers.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = "";
			int[] number = new int[15];
			int k = 0;
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(",");
				for (int i = 0; i < words.length; i++) {
					number[++k] = Integer.parseInt(words[i]);
					sortedLinkedList.addSorted(number[k]);

				}
			}

			System.out.println("File content:");
			sortedLinkedList.display();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sortedLinkedList.search(searchNumber)) {
			sortedLinkedList.remove(searchNumber);
			sortedLinkedList.display();
		} else {
			sortedLinkedList.addSorted(searchNumber);

		}
		// System.out.println("Edited file content");

		PrintWriter printWriter = new PrintWriter(file);
		for (int i = 0; i < sortedLinkedList.size(); i++) {

			printWriter.print(sortedLinkedList.getNth(i) + ",");
		}
		printWriter.close();

	}

	/**
	 * Print the `prime numbers between low and high
	 * 
	 * @param low
	 *            lower limit
	 * @param high
	 *            higher limit
	 * @return it returns prime array or null
	 */
	public static int[] findPrime(int low, int high) {
		int flag;
		int k = 0;
		int count = 0;
		int[] prime = new int[200];
		if (high < 2) {
			return null;
		}
		if (low == 0) {
			low = 2;
		}
		for (int i = low; i <= high; i++) {
			flag = 0;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				prime[k++] = i;
				count++;
			}
		}
		// System.out.println(count+" primes");
		return prime;
	}

	/**
	 * prints the 2D prime array
	 * 
	 * @return it return the 2D array
	 */
	public static int[][] twoDPrime() {
		int[][] prime = new int[10][30];
		int low = 0;
		int high = 0;
		int k = 0;

		for (int i = 0; i < prime.length; i++) {
			low = high;
			high = low + 100;
			int[] result = findPrime(low, high);
			for (int j = 0; j < prime[i].length; j++) {
				prime[i][j] = result[k++];
				System.out.print(prime[i][j] + " ");

				if (result[k] == 0) {
					break;
				}

			}
			k = 0;
			System.out.println();
		}
		return prime;
	}

	/**
	 * check the prime number is anagram or not
	 * 
	 * @return it returns the prime anagram array
	 */
	public static int[] primeAnagram() {
		int k = 0;
		int low = 0;
		int high = 0;
		int[] anagram = new int[200];

		for (int l = 0; l < 10; l++) {
			low = high;
			high = low + 100;
			int[] prime = findPrime(low, high);
			for (int i = 0; i < prime.length - 1; i++) {
				if (prime[i] == 0) {
					break;
				}
				for (int j = i + 1; j < prime.length; j++) {

					if (isAnagram(Integer.toString(prime[i]), Integer.toString(prime[j]))) {
						anagram[k++] = prime[i];
						anagram[k++] = prime[j];
						System.out.print(prime[i] + " " + prime[j] + " ");
					}
					if (prime[j] == 0) {
						break;
					}
				}

			}
			System.out.println();
		}
		/*
		 * for (int i = 0; i < nonanagram.length; i++) { for (int j = 0; j <nonanagram
		 * .length; j++) { System.out.print(nonanagram[i][j]); } System.out.println(); }
		 */
		return anagram;

	}

	/*
	 * public static int[] checkNonAnagram() { int[] prime = findPrime(0, 1000); int
	 * k = 0; int[] anagram = new int[300]; for (int i = 0; i < prime.length - 1;
	 * i++) { for (int j = i + 1; j < prime.length; j++) { if
	 * (isAnagram(Integer.toString(prime[i]), Integer.toString(prime[j]))) {
	 * anagram[k++] = prime[i]; anagram[k++] = prime[j]; } if (prime[j] == 0) {
	 * break; } } } for (int i = 0; i < anagram.length; i++) {
	 * System.out.println(anagram[i]); } return anagram; }
	 * 
	 * public static void nonAngram() { int low = 0; int high = 100;
	 * 
	 * while (high < 1000) {
	 * 
	 * int[] prime = findPrime(low, high); int[] anagram = checkNonAnagram(); int j
	 * = 0; for (int i = 0; i < prime.length; i++) { if (prime[i] == anagram[j++]) {
	 * // System.out.print(prime[i]+" "); }
	 * 
	 * } System.out.println(); low = low + 100; high = low + 100; } }
	 */

	/**
	 * calculate the day of week
	 * 
	 * @param month
	 *            month between 1 to 12
	 * @param day
	 *            days 1-31
	 * @param year
	 *            any year to pass
	 * @return it return day number that is falls which day of week
	 */
	public static int day(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31 * m) / 12) % 7;
		return d;
	}

	/**
	 * find the month have how many day
	 * 
	 * @param d
	 *            day 1 to 31
	 * @param mmonth
	 *            1 to 12
	 * @param y
	 *            check year is leap year or not
	 * @return return true/false given month has how many days or not
	 */
	public static boolean checkMonth(int d, int m, int y) {

		boolean st = true;
		if (((m == 4 || m == 6 || m == 9 || m == 11) && (d > 30)) || (d > 31)
				|| (m == 2 && y % 100 == 0 && y % 400 != 0 && d > 28) || (m == 2 && y % 400 == 0 && d > 29)
				|| (m == 2 && y % 100 != 0 && y % 4 != 0 && d > 28)
				|| (m == 2 && y % 100 != 0 && y % 4 == 0 && d > 29)) {
			st = false;
		} else {
			st = true;
		}
		return st;
	}

	/**
	 * print the calender format using Queue
	 * 
	 * @param month
	 *            month 1 to 12
	 * @param year
	 *            any year
	 */
	public static void calenderQueue(int month, int year) {
		Queue<String> QueueWeek = new Queue<String>();
		Queue<String> QueueDays = new Queue<String>();
		String[][] a = new String[6][7];
		int d = 1;
		String[] months = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] days = { " S ", " M ", " T ", " W ", " Th ", "F", " Sa" };

		for (int i = 0; i < days.length; i++) {
			QueueWeek.enqueue(days[i]);
		}
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				a[i][j] = "  ";
			}
		}
		int startday = dayOfWeek(d, month, year);
		for (int i = 0; i < startday; i++) {
			QueueDays.enqueue("  ");
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (checkMonth(d, month, year)) {
					j = dayOfWeek(d, month, year);
					if (d < 10) {
						a[i][j] = " " + d++;
						QueueDays.enqueue(a[i][j]);
					} else {
						a[i][j] = "" + d++;
						QueueDays.enqueue(a[i][j]);
					}

				}

			}
		}

		System.out.println(months[month] + " " + year);
		System.out.println();

		QueueWeek.displayInLine();
		// System.out.println();
		QueueDays.displayCalender();
	}

	/**
	 * print the calender format using stack
	 * 
	 * @param month
	 *            month between 1 to 12
	 * @param year
	 *            any year
	 */
	public static void calenderStack(int month, int year) {

		Stack<String> stackWeek = new Stack<>();
		Stack<String> stackDays = new Stack<String>();
		StackReverse<String> StackReverse = new StackReverse<String>();
		String[][] a = new String[6][7];
		int d = 1;
		String[] months = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] days = { " S ", " M ", " T ", " W ", " Th ", "F", " Sa" };

		for (int i = days.length - 1; i >= 0; i--) {
			stackWeek.push(days[i]);
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				a[i][j] = "  ";
			}
		}
		int startDay = dayOfWeek(d, month, year);
		// String dayStr=" "+startDay;
		for (int i = 0; i < startDay; i++) {
			stackDays.push("  ");
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (checkMonth(d, month, year)) {
					j = dayOfWeek(d, month, year);
					if (d < 10) {
						a[i][j] = " " + d++;
						stackDays.push(a[i][j]);
					} else {
						a[i][j] = "" + d++;
						stackDays.push(a[i][j]);
					}

				}

			}
		}
		System.out.println(stackDays.size());
		int index = stackDays.size();

		for (int i = 0; i < index; i++) {
			StackReverse.push(stackDays.pop());

		}

		System.out.println(StackReverse.size());
		System.out.println(months[month] + " " + year);
		System.out.println();

		stackWeek.displayInLine();

		StackReverse.displayCalender();

	}

	/**
	 * check the given year is leap year or not
	 * 
	 * @param year
	 *            year to pass check leap year or not
	 * @return true/false if it is leap year or not
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		if (year % 400 == 0)
			return true;
		return false;
	}

	/**
	 * print the calender using 2D array format
	 * 
	 * @param month
	 *            pass an integer 1 to 12
	 * @param year
	 *            pass the 4 digit year
	 */
	public static void printCalender(int month, int year) {
		String[] months = { "", // leave empty so that months[1] = "January"
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// check for leap year
		if (month == 2 && isLeapYear(year)) {
			days[month] = 29;
		}
		// print calendar header
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");

		// starting day
		int d = day(month, 1, year);

		// print the calendar
		for (int i = 0; i < d; i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= days[month]; i++) {
			System.out.printf("%2d ", i);
			if (((i + d) % 7 == 0) || (i == days[month])) {
				System.out.println();
			}
		}
	}

	/**
	 * Method to find possible number of binary search trees
	 *
	 * @param testCase
	 *            pass the nodes number
	 */

	public void numberOfBST(int testCase) {
		System.out.println("Enter total " + testCase + " number of nodes");
		int[] array = new int[testCase];
		for (int i = 0; i < testCase; i++) {
			array[i] = userInputInteger();
		}

		for (int i = 0; i < testCase; i++) {
			double result = (double) treeCount(array[i]);
			System.out.println(result);
		}

	}

	/**
	 * calculating the formula
	 * 
	 * @param number
	 *            number of nodes
	 * @return total number of possible binary search trees
	 */
	public static int treeCount(int number) {
		int intsum = 0;
		if (number == 0 || number == 1) {
			return 1;
		} else if (number == 2) {
			return 2;
		} else {
			for (int i = 0; i < number; i++) {
				intsum = intsum + treeCount(i) * treeCount(number - i - 1);
			}
			return intsum;
		}
	}

	/**
	 * Store the prime anagram numbers in stack and print it
	 */
	public static void primeAnagramStack() {
		Stack<Integer> stack = new Stack<>();
		int[] anagram = primeAnagram();
		for (int i = 0; i < anagram.length; i++) {
			if (anagram[i] == 0) {
				continue;
			}
			stack.push(anagram[i]);
		}
		stack.traverse();
	}

	/**
	 * Store the prime anagram numbers in Queue and print it
	 */
	public static void angramPrimeQ() {
		Queue<Integer> queue = new Queue<>();
		int[] anagram = primeAnagram();
		for (int i = 0; i < anagram.length; i++) {
			if (anagram[i] == 0) {
				continue;
			}
			queue.enqueue(anagram[i]);
		}
		queue.display();
	}

	/*************************************************************************************
	 * 
	 * OOPS Problems
	 * ***********************************************************************************
	 */

	public static void replacementOfRegx(String userName, String fullName, String mobileNo) {
		String message = " Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. ";

		String regexName = "(\\<<)(name)(>>)";
		String regexFullName = "(\\<<)(full name)(>>)";
		String regexPhone = "(xxxxxxxxxx)";
		String regexDate = "(01/01/2016)";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		String todayDate = dateFormat.format(new Date());

		message = regexReplace(message, regexName, userName);
		message = regexReplace(message, regexFullName, fullName);
		message = regexReplace(message, regexPhone, mobileNo);
		message = regexReplace(message, regexDate, todayDate);
		System.out.println(message);

	}

	public static String regexReplace(String message, String regex, String replacement) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll(replacement);
		// System.out.println(message);
		return message;

	}

}
