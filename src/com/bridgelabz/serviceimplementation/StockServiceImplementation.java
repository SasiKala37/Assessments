/**
 * Purpose:Implementation class for the Stock service interface
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

import com.bridgelabz.datastructures.LinkedList;
import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.util.Utility;

public class StockServiceImplementation implements StockService {
	ArrayList<Stock> stockList=new ArrayList<>();
	Utility utility=new Utility();
	Stock stock=new Stock();
	LinkedList<String> list= new LinkedList<>();
	File file=new File("/home/bridgelabz/basicjavaprograms/stockmanagement/src/com/bridgelabz/files/stock.json");
	@Override
	public void showStockDetails() {
		try {
			stockList = Utility.parseJSONArray(file, Stock.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Stock stock:stockList) {
			try {
				System.out.println(Utility.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stock));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}
	public void showCompanyShares() {
		try {
			stockList = Utility.parseJSONArray(file, Stock.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String shares="";
		for(int i=0;i<stockList.size();i++) {
			shares=stockList.get(i).getStockName()+"---"+stockList.get(i).getNoOfShares();
			list.addLast(shares);
		}
		System.out.println("Company share Details");
		list.traverse();
		
	}

	@Override
	public void addStock() {
		try {
			stockList = Utility.parseJSONArray(file, Stock.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stock=utility.stockInfo();
		stockList.add(stock);
		try {
			Utility.mapper.writeValue(file, stockList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStock(String stockName) {
			try {
				stockList = Utility.parseJSONArray(file, Stock.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < stockList.size(); i++) {
				if(stockList.get(i).getStockName().equalsIgnoreCase(stockName)) {
					stockList.remove(i);
				}
			}
			try {
				Utility.mapper.writeValue(file, stockList);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	
	@Override
	public void updateStock(String stockName) {
		try {
			stockList = Utility.parseJSONArray(file, Stock.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < stockList.size(); i++) {
			if(stockList.get(i).getStockName().equalsIgnoreCase(stockName)) {
				//stockList.get(i).setStockName(stockList.get(i).getStockName());
				System.out.println("Enter no of shares to update");
				int noOfShares=Utility.userInputInteger();
				stockList.get(i).setNoOfShares(noOfShares);
				System.out.println("Enter  share price to update");
				int price=Utility.userInputInteger();
				stockList.get(i).setPrice(price);
			}
		}
		try {
			Utility.mapper.writeValue(file, stockList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
