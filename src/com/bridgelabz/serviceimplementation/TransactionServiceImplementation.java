/**
 * Purpose:Implementation class for the Transaction service interface
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.bridgelabz.datastructures.Queue;
import com.bridgelabz.datastructures.Stack;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.service.TransactionService;
import com.bridgelabz.util.Utility;

public class TransactionServiceImplementation implements TransactionService {
	File file = new File(
			"/home/bridgelabz/basicjavaprograms/stockmanagement/src/com/bridgelabz/files/transaction.json");
	File cfile = new File("/home/bridgelabz/basicjavaprograms/stockmanagement/src/com/bridgelabz/files/customer.json");
	File sfile = new File("/home/bridgelabz/basicjavaprograms/stockmanagement/src/com/bridgelabz/files/stock.json");

	ArrayList<Transaction> transactionList = new ArrayList<>();
	Stack<String> purchase = new Stack<>();

	Customer customer = new Customer();
	Transaction transaction = new Transaction();

	CustomerServiceImplemntation cuImplemntation = new CustomerServiceImplemntation();
	StockServiceImplementation sImplementation = new StockServiceImplementation();

	int noOfShares;
	boolean search;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Override
	public void buy(int amount, String stockName) {

		try {
			transactionList = Utility.parseJSONArray(file, Transaction.class);
			cuImplemntation.customerList = Utility.parseJSONArray(cfile, Customer.class);
			sImplementation.stockList = Utility.parseJSONArray(sfile, Stock.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < sImplementation.stockList.size(); i++) {
			// search the stock name
			if (sImplementation.stockList.get(i).getStockName().equalsIgnoreCase(stockName)) {
				System.out.println("Enter no of shares you want to buy");
				noOfShares = Utility.userInputInteger();
				// chek no of shares available
				if (sImplementation.stockList.get(i).getNoOfShares() >= noOfShares) {
					// check the amount sufficient buy
					if (sImplementation.stockList.get(i).getPrice() >= amount) {
						sImplementation.stockList.get(i)
								.setNoOfShares(sImplementation.stockList.get(i).getNoOfShares() - noOfShares);
						try {
							Utility.mapper.writeValue(sfile, sImplementation.stockList);
						} catch (IOException e) {
							e.printStackTrace();
						}
						search = true;
					} else {
						System.out.println("Amount not sufficient buy shares");
					}

				}

			}
		}
		// Store info in customer
		if (search) {
			System.out.println("Enter Customer name");
			String customerName = Utility.userInputString();
			boolean st = false;
			for (int i = 0; i < cuImplemntation.customerList.size(); i++) {

				if (cuImplemntation.customerList.get(i).getCustomerName().equalsIgnoreCase(customerName)) {
					cuImplemntation.customerList.get(i)
							.setNoOfShares(cuImplemntation.customerList.get(i).getNoOfShares() + noOfShares);
					cuImplemntation.customerList.get(i).setPrice(amount);
					st = true;
					break;
				}
			}
			if (!st) {
				customer.setCustomerName(customerName);
				customer.setNoOfShares(noOfShares);
				customer.setPrice(amount);
				cuImplemntation.customerList.add(customer);
			}
			try {
				Utility.mapper.writeValue(cfile, cuImplemntation.customerList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Store info in transaction
		if (search) {
			transaction.setStockName(stockName);
			transaction.setNoOfShares(noOfShares);
			transaction.setPrice(amount);
			transaction.setTypeOfTransaction("Buy");
			transaction.setDateTime(sdf.format(timestamp));
			transactionList.add(transaction);
			try {
				Utility.mapper.writeValue(file, transactionList);
				System.out.println("Successfully purchased Stock!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	//To Store the data and time of the transaction in Queue
	public void transactionDate() {
		Queue<String> dateTimeOfTrans = new Queue<>();
		try {
			transactionList = Utility.parseJSONArray(file, Transaction.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String purchased = "";
		for (int i = 0; i < transactionList.size(); i++) {
			purchased = transactionList.get(i).getStockName() + "--" + transactionList.get(i).getDateTime();
			dateTimeOfTrans.enqueue(purchased);
		}
		System.out.println("Date and time of the transaction Information");
		dateTimeOfTrans.display();
	}
	// To store the purchased stocks in Stack
	public void purchasedStocks() {
		try {
			transactionList = Utility.parseJSONArray(file, Transaction.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String purchased = "";
		for (int i = 0; i < transactionList.size(); i++) {
			purchased = transactionList.get(i).getStockName() + "--" + transactionList.get(i).getNoOfShares() + "--"
					+ transactionList.get(i).getTypeOfTransaction();
			purchase.push(purchased);
		}
		System.out.println("Stock purchased details");
		purchase.traverse();
	}

	/*
	 * @Override public void sell(int amount, String stockName) { }
	 */

	@Override
	public void printReport() {
		try {
			transactionList = Utility.parseJSONArray(file, Transaction.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Transaction transaction : transactionList) {
			try {
				System.out.println(Utility.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(transaction));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
