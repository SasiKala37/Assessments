/**
 * Purpose:  POJO class for the stock account management
 * @author SasiKala
 * @version 1.0
 * @since -06-2018
 */
package com.bridgelabz.oops;

public class PoJoStockAccount {
	 private  String stockSymbol;
	 private  int noOfStocks;
	 private String dateTime;
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	 
}
