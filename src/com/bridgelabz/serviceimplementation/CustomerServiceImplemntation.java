/**
 * Purpose:Implementation class for the CustomerService interface
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.model.Customer;
import com.bridgelabz.service.CustomerService;
import com.bridgelabz.util.Utility;

public class CustomerServiceImplemntation implements CustomerService {

	public ArrayList<Customer> customerList = new ArrayList<>();
	Utility utility = new Utility();
	Customer customer=new Customer();
	File file = new File("/home/bridgelabz/basicjavaprograms/stockmanagement/src/com/bridgelabz/files/customer.json");

	@Override
	public void showCustomerDetails() {
		try {
			customerList = Utility.parseJSONArray(file, Customer.class);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (Customer customer : customerList) {
			try {
				System.out.println(Utility.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addCustomer()  {
		try {
			customerList = Utility.parseJSONArray(file, Customer.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		customer=utility.customerInfo();
		customerList.add(customer);
		try {
			Utility.mapper.writeValue(file, customerList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(String customerName) {
		try {
			customerList = Utility.parseJSONArray(file, Customer.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getCustomerName().equalsIgnoreCase(customerName)) {
				customerList.remove(i);
			}
		}
		try {
			Utility.mapper.writeValue(file, customerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void udateCustomer(String customerName) {
		try {
			customerList = Utility.parseJSONArray(file, Customer.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getCustomerName().equalsIgnoreCase(customerName)) {
				System.out.println("Enter no of shares to update");
				int noOfShares=Utility.userInputInteger();
				customerList.get(i).setNoOfShares(noOfShares);
				
			}
			}
		try {
			Utility.mapper.writeValue(file, customerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
