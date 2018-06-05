package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManager {
	static long SUMSTOCK = 0;
	static long TOTALSTOCK = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Object object=new JSONParser().parse(new FileReader("/home/bridgelabz/Documents/json/stock.json"));
		 JSONObject jsonObject=(JSONObject) object;
		 long totalPrice=0; long totalStocks=0;
		 JSONArray stock1 = (JSONArray) jsonObject.get("stockList");
		 for (int i = 0; i < stock1.size(); i++) {
				JSONObject inventory = (JSONObject) (stock1.get(i));
				SUMSTOCK=(long) inventory.get("numberOfStocks")*(long) inventory.get("sharePrice");
				System.out.println("Stock price list"+i+": "+SUMSTOCK);
				totalPrice+=SUMSTOCK;
				TOTALSTOCK = (long) inventory.get("numberOfStocks");
				System.out.println("Number of Stocks in list"+i+": "+TOTALSTOCK);
				totalStocks+=TOTALSTOCK;
				
			}
		 
			System.out.println("Total stock Price: "+totalPrice);
			System.out.println("Number Stocks in the inventory: "+totalStocks); 
			 
	}

}

