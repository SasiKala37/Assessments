/*********************************************************************************
 * 
 * Purpose: Replace the string template "Hello <<UserName>>, How are you?"
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
import java.util.Random;
import java.util.Scanner;

import com.bridgelabz.datastructures.Deque;
import com.bridgelabz.datastructures.LinkedList;
import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.datastructures.SortedLinkedList;
import com.bridgelabz.datastructures.Stack;

public class Utility {
	public Scanner scanner = new Scanner(System.in);
	LinkedList<String> linkedList = new LinkedList<String>();
	Stack<Character> stack = new Stack<Character>();
	Queue<Integer> queue = new Queue<Integer>();
	Deque<Character> deque = new Deque<Character>();
	SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<Integer>();

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
	 * @throws IOException
	 */
	public String stringReplace(String userName) {

		String givenString = "Hello <<username>>, How are you?";
		return givenString.replaceAll("<<username>>", userName);
	}

	/**
	 * Calculate the head and tail percentage when flapping the coin randomly
	 * 
	 * @param noOfFlips
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
	 * @return
	 * @throws IOException
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
	 * @return
	 */
	public static double nthHarmonicValue(int nthTermNumber) {
		double result = 0;
		for (int i = 1; i <= nthTermNumber; i++) {
			result += (double) (1 / i);
		}
		return result;
	}

	/**
	 * calculate the prime factors of given number
	 * 
	 * @param N
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
	 * @param y
	 * @return
	 */
	public static double findDistance(int x, int y) {
		return Math.sqrt((x * x) + (y * y));
	}

	/**
	 * calculate the roots for quadratic equation given quadratic equation
	 * a*x*x+b*x+c
	 * 
	 * @param a
	 * @param b
	 * @param c
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
	 * @param windpeed
	 * @return
	 */
	public static double computeWindChill(double temperature, double windSpeed) {
		return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
	}

	/**
	 * get the random number from given number to number-1
	 * 
	 * @param number
	 * @return
	 */
	public static int getCoupon(int number) {
		Random random = new Random();
		return (random.nextInt()) * number;
	}

	/**
	 * find the distinct coupon numbers
	 * 
	 * @param randomNumber
	 */
	public static int distinctCouponNumber(int randomNumber) {
		int count = 0;
		boolean[] isCollected = new boolean[randomNumber];
		int distinctNumber = 0;
		while (distinctNumber < randomNumber) {
			int value = getCoupon(randomNumber);
			count++;
			if (!isCollected[value]) {
				distinctNumber++;
				isCollected[value] = true;
			}
		}
		return count;
	}

	/**
	 * calculate the percentage of win and loss gambler
	 * 
	 * @param stake
	 * @param goal
	 * @param numberOfTrails
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
	 * calculate the permutation of string using iterative meathod
	 * 
	 * @param input
	 * @param startIndex
	 * @param endIndex
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
	 * @param startIndex
	 * @param position
	 * @return
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
	 * @return
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
	 * @param columnSize
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
	 * @param columnSize
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
	 * @param columnSize
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
	 * @param secondString
	 * @return
	 */
	public static boolean isAnagram(String firstString, String secondString) {
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
	 * @return
	 */
	public static String removeSpace(String inputString) {
		char[] charString = inputString.toCharArray();
		inputString = "";
		for (int i = 0; i < charString.length; i++) {
			if (charString[i] != ' ') {
				inputString = inputString + charString[i];
			}
		}
		return inputString;
	}

	/****************************************
	 * check whether the given strings are having same characters
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
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
	 * @return
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
	 */
	public static void findPrimeNumbers(int higherLimit) {
		int count; // int k=0;
		// int[] primeArray=new int[k];
		for (int i = 1; i <= higherLimit; i++) {
			count = 0;
			for (int j = 1; j <= higherLimit; j++) {
				if (i % j == 0)
					count++;
			}
			if (count == 2) {
				System.out.println(i);
				// primeArray[k++]=i;
			}
			// isPalindrome(primeArray);
		}
	}

	/**
	 * check the given primeArray elements whether palindrome or not
	 * 
	 * @param primeArray
	 */
	public static void isPalindrome(int[] primeArray) {
		int reverseNumber = 0;
		for (int i = 0; i < primeArray.length && primeArray[i] != 0; i++) {
			while (primeArray[i] > 0) {
				reverseNumber = reverseNumber * 10 + primeArray[i] % 10;
				primeArray[i] = primeArray[i] / 10;
			}
			if (reverseNumber == primeArray[i]) {
				System.out.println("palindrome" + reverseNumber);
			}
		}
	}

	/**
	 * guessing the number to enter true or false answer
	 * 
	 * @param low
	 * @param high
	 * @return
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
	 * @return
	 */
	public static double celsiusToFahrenheit(double temperatureInCelsius) {
		return (temperatureInCelsius * 9 / 5) + 32;
	}

	/**
	 * convert fahrenheit to celsius temperature
	 * 
	 * @param temperatureInFahrenheit
	 * @return
	 */
	public static double fahrenheitToCelsius(double temperatureInFahrenheit) {
		return (temperatureInFahrenheit - 32) * 5 / 9;
	}

	/**
	 * calculate the monthly payment using given formula
	 * payment=(p*r)/(1-(1+r)^(-n))
	 * 
	 * @param principleAmount
	 * @param rateOfIntrest
	 * @param year
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
	 * @param month
	 * @param year
	 */
	public static void dayOfWeek(int day, int month, int year) {

		boolean keepGoing = true;
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
			int d0 = (day + x + 31 * m0 / 12) % 7;
			String result = "";
			switch (d0) {
			case 0:
				result += "sunday";
				break;
			case 1:
				result += "monday";
				break;
			case 2:
				result += "tuesday";
				break;
			case 3:
				result += "wednesday";
				break;
			case 4:
				result += "thursday";
				break;
			case 5:
				result += "friday";
				break;
			case 6:
				result += "satday";
				break;
			default:
				System.out.println("Nothing");
				break;
			}
			System.out.println("The day of the week is " + result);
			keepGoing = false;
		}

	}

	/**
	 * convert the decimal to binary
	 * 
	 * @param number
	 * @return
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
	 * @param number
	 * @return
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
	 * @return
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
	 *            - reading array of elements
	 * @param searchElement
	 *            -the which element user want to search
	 * @param low
	 *            -array first index
	 * @param high
	 *            -array last index
	 * @return -it returns true or false whether the search element is found or not
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
	 *            - data array
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
	 * print data -print the array of data
	 * 
	 * @param data
	 *            -array data
	 */
	public static <T extends Comparable<T>> void printData(T[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> void readData(T[] data, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Sort the data based on key value(insertion sort)
	 * 
	 * @param data
	 *            -array data to sort
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		for (int i = 0; i < data.length; i++) {
			T key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j].compareTo(key) > 0) {
				data[j + 1] = data[j];
				j = j - 1;

			}
			data[j + 1] = key;
		}
		System.out.println("Sorted data");
		printData(data);

	}

	/**
	 * compare the elements in the sub array then merging the two sub array into
	 * single array
	 * 
	 * @param data
	 *            - array of data
	 * @param low
	 *            -array first index
	 * @param mid
	 *            -array last index
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
	 *            - Array of data
	 * @param low
	 *            -array first index
	 * @param high
	 *            -array first index
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
	 * @throws IOException
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
	 * @param expression
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
	 * @param numberOfPersons
	 * @param balance
	 */
	public void maintainCashBalance(int numberOfPersons, double balance) {
		int[] person = new int[numberOfPersons];
		double withdraw;
		double deposit;
		;
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
				if (balance >= withdraw) {
					balance = balance - withdraw;
					System.out.println("cacsh balance:" + balance);
				} else {
					System.out.println("Insufficient balance");
				}
				queue.dequeue();
				break;
			case 2:
				System.out.println("Enter the amount to deposit");
				deposit = userInputDouble();
				balance = balance + deposit;
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
	 * @param input
	 * @return
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
	 * @param searchData
	 * @throws FileNotFoundException
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
}
