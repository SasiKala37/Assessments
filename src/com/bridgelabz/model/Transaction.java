/**
 * Purpose:POJO class for the Stock management
 * 
 * @author SasiKala
 * @version 1.0
 * @date 13-06-2018
 * 
 * */
package com.bridgelabz.model;

public class Transaction {
	private String stockName;
	private int noOfShares;
	private int price;
	private String typeOfTransaction;
	private String dateTime;

	public Transaction() {

	}

	/**
	 * Parameterized constructor to initialize the values
	 * 
	 * @param stockName
	 *            name of the stock
	 * @param noOfShares
	 *            number of shares
	 * @param price
	 *            price of each share
	 * @param typeOfTransaction
	 *            transaction type buy/sell
	 * @param dateTime
	 *            date and time of the transaction
	 */
	public Transaction(String stockName, int noOfShares, int price, String typeOfTransaction, String dateTime) {

		this.stockName = stockName;
		this.noOfShares = noOfShares;
		this.price = price;
		this.typeOfTransaction = typeOfTransaction;
		this.dateTime = dateTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
