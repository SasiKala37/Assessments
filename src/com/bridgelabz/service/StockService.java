/**
 * Purpose: StockService interface to list all the operations of Stock 
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13/06/2018
 * 
 * */
package com.bridgelabz.service;

public interface StockService {
	// show stock details
	void showStockDetails();

	// Add stock details
	void addStock();

	/**
	 * Delete the stock based on name
	 * 
	 * @param stockName
	 *            to delete the stock name
	 */
	void deleteStock(String stockName);

	/**
	 * Update the Stock info
	 * 
	 * @param stockName
	 *            update the Stock info based on name
	 */
	void updateStock(String stockName);
}
