package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class DataManagementOfRice {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		InventoryFactory inventoryFactory = new InventoryFactory();

		ObjectMapper map = new ObjectMapper();
		Utility utility = new Utility();
		PoJoProductDetails details = new PoJoProductDetails();

		System.out.println("enter no. of rice types");
		int noOftypes = utility.userInputInteger();
		for (int i = 0; i < noOftypes; i++) {
			details = productData();
			inventoryFactory.getrice().add(details);
		}

		System.out.println("enter no. ofPulses types");
		int noOfpulse = utility.userInputInteger();
		for (int i = 0; i < noOfpulse; i++) {
			details = productData();
			inventoryFactory.getPulse().add(details);
		}

		System.out.println("enter no. of Wheat types");
		int wheatTypes = utility.userInputInteger();
		for (int i = 0; i < wheatTypes; i++) {
			details = productData();
			inventoryFactory.getWheat().add(details);
		}
		map.writeValue(new File("/home/bridgelabz/Documents/json/ricep.json"), inventoryFactory);
		Object object = new JSONParser().parse(new FileReader("/home/bridgelabz/Documents/json/ricep.json"));

		JSONObject jsonObject = (JSONObject) object;
		@SuppressWarnings("unchecked")
		Set<String> keys = jsonObject.keySet();

		for (String inventorykeys : keys) {
			JSONArray inventoryarray = (JSONArray) jsonObject.get(inventorykeys);
			long totalprice = 0;

			for (Object object2 : inventoryarray) {
				JSONObject inventory = (JSONObject) object2;
				long weight = (long) inventory.get("weight");
				long price = (long) inventory.get("price");
				totalprice += (weight * price);
			}
			System.out.println("price of " + inventorykeys + " is " + totalprice);
		}

	}

	public static PoJoProductDetails productData() {
		PoJoProductDetails poJoProductDetails = new PoJoProductDetails();
		Utility utility = new Utility();
		System.out.println("Enter name: ");
		String name = utility.userInputString();
		poJoProductDetails.setName(name);

		System.out.println("Enter price:");
		long price = utility.userInputLong();
		poJoProductDetails.setPrice(price);

		System.out.println("Enter Weight: ");
		long weight = utility.userInputLong();
		poJoProductDetails.setWeight(weight);
		return poJoProductDetails;
	}
}
