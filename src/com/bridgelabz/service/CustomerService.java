/**
 * Purpose: CustomerService interface to list all the operations of customer 
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13/06/2018
 * 
 * */
package com.bridgelabz.service;

public interface CustomerService {

	// Display the customer details
	void showCustomerDetails();

	// Add the customer Details
	void addCustomer();

	/**
	 * Delete the customer based on name
	 * 
	 * @param customerName
	 *            name of the customer to delete
	 */
	void deleteCustomer(String customerName);

	/**
	 * Update the customer based on name
	 * @param customerName based on customer name to update all the fields
	 */
	void udateCustomer(String customerName);

}
