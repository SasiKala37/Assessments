package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManagementOfRice {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	 Object object=new JSONParser().parse(new FileReader("/home/bridgelabz/Documents/json/rice.json"));
	 JSONObject jsonObject=(JSONObject) object;
	 @SuppressWarnings("unchecked")
	Set<String> keys=jsonObject.keySet();
	 
     for (String inventorykeys : keys) { 
        JSONArray inventoryarray=(JSONArray)jsonObject.get(inventorykeys);
        long totalprice=0;
        
        for (Object object2 : inventoryarray) {
        JSONObject inventory=(JSONObject)object2;
        long weight=(long)inventory.get("Weight");
        long price=(long)inventory.get("Price");
       totalprice+=(weight*price);
        }
        System.out.println("price of "+inventorykeys+" is "+totalprice);
    }
	 
	}

}
