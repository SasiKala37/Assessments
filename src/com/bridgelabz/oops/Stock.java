package com.bridgelabz.oops;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class Stock {
	static long SUMSTOCK = 0;
	static long TOTALSTOCK = 0;

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		StockPortfolio folio = new StockPortfolio();
		ObjectMapper map = new ObjectMapper();
		Utility utility = new Utility();
		
		System.out.println("enter no. of stocks list");
		int noOfStock = utility.userInputInteger();
		PojoStock stock = new PojoStock();
		
		for (int i = 0; i < noOfStock; i++) {
			stock = stockData();
			folio.getstockList().add(stock);
		}
		
		map.writeValue(new File("/home/bridgelabz/Documents/json/stock.json"), folio);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/bridgelabz/Documents/json/stock.json"));
		JSONObject jsonobject = (JSONObject) obj;
		JSONArray stock1 = (JSONArray) jsonobject.get("stockList");
		
		for (int i = 0; i < stock1.size(); i++) {
			JSONObject objstock = (JSONObject) (stock1.get(i));
			SUMSTOCK +=(long) objstock.get("numberOfStocks")* (long)objstock.get("sharePrice");
			TOTALSTOCK +=(long) objstock.get("numberOfStocks");
		}
		System.out.println(SUMSTOCK);
		System.out.println(TOTALSTOCK);
	}

	public static PojoStock stockData() {
		PojoStock pojoStock = new PojoStock();
		Utility utility = new Utility();
		System.out.println("Enter stock name ");
		String stockName = utility.userInputString();
		pojoStock.setStockName(stockName);

		System.out.println("Enter number of stocks ");
		long numberOfStocks = utility.userInputLong();
		pojoStock.setNumberOfStocks(numberOfStocks);

		System.out.println("Enter share price ");
		long sharePrice = utility.userInputLong();
		pojoStock.setSharePrice(sharePrice);
		return pojoStock;
	}
}
