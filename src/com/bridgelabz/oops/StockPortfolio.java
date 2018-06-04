package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class StockPortfolio {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Stock stock = new Stock();
		Map<String, Object> stockData = new HashMap<>();
		stockData.put("Stock", stockData);
		List<Stock> list = new ArrayList<>();
		stock = stockData();
		Stock stock1 = stockData();
		list.add(stock);
		list.add(stock1);
		ObjectMapper mapper = new ObjectMapper();

			mapper.writeValue(new File("/home/bridgelabz/Documents/json/stock.json"), list);
	
		Object object = new JSONParser().parse(new FileReader("/home/bridgelabz/Documents/json/stock.json"));
		JSONObject jsonObject=(JSONObject) object;
		 @SuppressWarnings("unchecked")
		Set<String> keys=jsonObject.keySet();
		 long totalprice = 0;
	     for (String inventorykeys : keys) { 
	        JSONArray inventoryarray=(JSONArray)object.get(inventorykeys);
			
				Integer numberOfStocks= (Integer) inventoryarray.get("numberOfStocks");
				long sharePrice= (long) inventoryarray.get(2);
				totalprice += (numberOfStocks * sharePrice);
				System.out.println("price of " + inventorykeys + " is " + totalprice);
			}
			
		

	}

	public static Stock stockData() {
		Stock stock = new Stock();
		Utility utility = new Utility();
		System.out.println("Enter stock name ");
		String stockName = utility.userInputString();
		stock.setStockName(stockName);

		System.out.println("Enter number of stocks ");
		int numberOfStocks = utility.userInputInteger();
		stock.setNumberOfStocks(numberOfStocks);

		System.out.println("Enter share price ");
		long sharePrice = utility.userInputLong();
		stock.setSharePrice(sharePrice);
		return stock;
	}
}
