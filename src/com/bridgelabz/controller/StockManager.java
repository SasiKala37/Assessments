/**
 * Purpose: To check the functionality of the Stock management
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.controller;

import com.bridgelabz.serviceimplementation.CustomerServiceImplemntation;
import com.bridgelabz.serviceimplementation.StockServiceImplementation;
import com.bridgelabz.serviceimplementation.TransactionServiceImplementation;
import com.bridgelabz.util.Utility;

public class StockManager {

	public static void main(String[] args) {
		TransactionServiceImplementation tImplementation = new TransactionServiceImplementation();
		StockServiceImplementation sImplementation = new StockServiceImplementation();
		CustomerServiceImplemntation cImplemntation = new CustomerServiceImplemntation();
		int ch = 0;
		System.out.println("1:Stock Information details");
		System.out.println("2:Customer Information Details");
		System.out.println("3:Transaction Information Details");
		int choice=0;
		while (choice < 4) {
			System.out.println("Enter your choice");
			ch = Utility.userInputInteger();
			switch (ch) {

			case 1:
				System.out.println("1: Show stock details");
				System.out.println("2: Add Stock Information");
				System.out.println("3: update Stock information");
				System.out.println("4: delete stock information");
				while (ch < 5) {
					System.out.println("Enter your choice");
					ch = Utility.userInputInteger();
					switch (ch) {
					case 1:
						sImplementation.showStockDetails();
						break;
					case 2:
						sImplementation.addStock();
						break;
					case 3:
						System.out.println("Enter Stock Name");
						Utility.userInputNextLine();
						sImplementation.updateStock(Utility.userInputNextLine());
					case 4:
						System.out.println("Enter Stock Name");
						Utility.userInputNextLine();
						sImplementation.deleteStock(Utility.userInputNextLine());
					default:
						System.out.println("Exit from the stock");
					}
					ch++;
				}
				break;
			case 2:

				System.out.println("1: Show Customer details");
				System.out.println("2: Add Customer Information");
				System.out.println("3: update Customer information");
				System.out.println("4: delete Customer information");
				int ch1=0;
				
				while (ch1 < 5) {
					System.out.println("Enter your choice");
					ch1= Utility.userInputInteger();
					switch (ch1) {
					case 1:
						cImplemntation.showCustomerDetails();
						break;
					case 2:
						cImplemntation.addCustomer();
						break;
					case 3:
						System.out.println("Enter  Customer Name");
						Utility.userInputNextLine();
						sImplementation.updateStock(Utility.userInputNextLine());
					case 4:
						System.out.println("Enter  Customer Name");
						Utility.userInputNextLine();
						sImplementation.deleteStock(Utility.userInputNextLine());
					default:
						System.out.println("Exit from the  Customer");
					}
					ch1++;
				}
				break;

			case 3:
				System.out.println("1:Buy transaction");
				System.out.println("2:Print Report");
				int ch2=0;
				while (ch2 < 3) {
					System.out.println("Enter your choice");
					ch2 = Utility.userInputInteger();
					switch (ch2) {
					case 1:
						System.out.println("Enter your amount");
						int amount = Utility.userInputInteger();
						System.out.println("Enter the stock name");
						Utility.userInputNextLine();
						String stockName = Utility.userInputNextLine();
						tImplementation.buy(amount, stockName);
						break;
					case 2:
						tImplementation.printReport();
						break;
					default:
						System.out.println("Exit the program");
					}ch2++;
				}
			}choice++;
		}
	}

}
