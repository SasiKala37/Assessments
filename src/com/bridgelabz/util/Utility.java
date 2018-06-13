/**
 * Purpose:Utility class for the Stock management
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;

import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;

public class Utility {
	public static Scanner scanner = new Scanner(System.in);
	public static ObjectMapper mapper = new ObjectMapper();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

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

	/**
	 * To parse the file into JSON File
	 * 
	 * @param file
	 *            to parse JSON file
	 * @param clazz
	 *            name of the class
	 * @return ArrayList of JSON objects
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<T> arrayList = new ArrayList<T>();
		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
		arrayList = mapper.readValue(file, javaType);

		return arrayList;

	}

	/**
	 * Add customer Details
	 * 
	 * @return Customer instance
	 */
	public Customer customerInfo() {
		Customer customer = new Customer();
		System.out.println("Enter customer name");
		userInputNextLine();
		String name = userInputNextLine();
		System.out.println("Enter noOf shares");
		int noOfShares = userInputInteger();
		System.out.println("Enter price of share");
		int price = userInputInteger();
		customer = new Customer(name, noOfShares, price);
		return customer;
	}

	/**
	 * Add Stock Details
	 * 
	 * @return Stock instance
	 */
	public Stock stockInfo() {
		Stock stock = new Stock();
		System.out.println("Enter stock name");
		userInputNextLine();
		String name = userInputNextLine();
		System.out.println("Enter noOf shares ");
		int noOfShares = userInputInteger();
		System.out.println("Enter price of share");
		int price = userInputInteger();
		stock = new Stock(name, noOfShares, price);
		return stock;
	}

	/**
	 * Add transaction Details
	 * 
	 * @return transaction instance
	 */
	public Transaction transactionInfo() {
		Transaction transaction = new Transaction();
		System.out.println("Enter stock name");
		userInputNextLine();
		String name = userInputNextLine();
		System.out.println("Enter noOf shares ");
		int noOfShares = userInputInteger();
		System.out.println("Enter price of share");
		int price = userInputInteger();
		String dateTime = sdf.format(timestamp);
		System.out.println("Enter the type of transation");
		String type = userInputString();
		transaction = new Transaction(name, noOfShares, price, type, dateTime);
		return transaction;
	}
}
