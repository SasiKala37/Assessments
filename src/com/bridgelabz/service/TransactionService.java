/**
 * Purpose: TransationService interface to list all the operations of Transaction 
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13/06/2018
 * 
 * */
package com.bridgelabz.service;

public interface TransactionService {

	/**
	 * purchase the stock
	 * 
	 * @param amount
	 *            to buy stock
	 * @param stockName
	 *            select the name to buy
	 */
	void buy(int amount, String stockName);

	// void sell(int amount, String stockName);

	// Print Report of Transaction
	void printReport();
}
