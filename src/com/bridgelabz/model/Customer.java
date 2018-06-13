/**
 * Purpose:Customer PoJo class for the Stock management
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.model;

public class Customer {
	private String customerName;
	private int noOfShares;
	private int price;

	public Customer() {

	}
// Parameterized constructor to initialize values
	public Customer(String customerName, int noOfShares, int price) {
		super();
		this.customerName = customerName;
		this.noOfShares = noOfShares;
		this.price = price;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
