/**
 * Purpose: Stock POJO class for the Stock Management
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.model;

public class Stock {
	private String stockName;
	private int noOfShares;
	private int price;

	public Stock() {

	}
	//Parameterized constructor to initialize values
	public Stock(String stockName, int noOfShares, int price) {
		this.stockName = stockName;
		this.noOfShares = noOfShares;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
