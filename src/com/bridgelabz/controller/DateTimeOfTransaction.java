/**
 * Purpose: maintain DateTime of the transaction in a Queue implemented using Linked  
 *	List to indicate  when the transactions were done
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.controller;

import com.bridgelabz.serviceimplementation.TransactionServiceImplementation;

public class DateTimeOfTransaction {

	public static void main(String[] args) {
		TransactionServiceImplementation tImplementation=new TransactionServiceImplementation();
		tImplementation.transactionDate();
	}

}
