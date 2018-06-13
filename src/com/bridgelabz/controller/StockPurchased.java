/**
 * Purpose: maintain   the   Stock   Symbol   Purchased   or   Sold   in   a   Stack   implemented   using  
 *  Linked   List   to   indicate   transactions   done. 
 * 
 * @author SasiKala
 * @version 1.0
 * @since 13-06-2018
 * 
 * */
package com.bridgelabz.controller;

import com.bridgelabz.serviceimplementation.TransactionServiceImplementation;

public class StockPurchased {

	public static void main(String[] args) {
		TransactionServiceImplementation tImplementation=new TransactionServiceImplementation();
		tImplementation.purchasedStocks();
	}

}
