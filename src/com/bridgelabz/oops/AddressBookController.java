package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookController extends Object {
	AddressBook addressBook =new AddressBook();
	Utility utility = new Utility();
	Person person = new Person();
	public AddressBookController() throws JsonGenerationException, JsonMappingException, IOException {
		// new AddressBook();

	}
	public void doNew() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.out.println("Enter the new address book name");
		String addressBookName = utility.userInputString();
		
		File file1=new File("/home/bridgelabz/Documents/json/"+addressBookName+".json");

		addressBook.addressFiles.add(file1);

		addressBook.mapper.writeValue(file1,addressBook.addressFiles);

	}
	public void doAdd() throws JsonGenerationException, JsonMappingException, IOException, ParseException {	
	  
		System.out.println("Enter first name");
		String firstName = utility.userInputString();

		System.out.println("Enter last name");
		String lastName = utility.userInputString();
		
		System.out.println("Enter Adaress ");
		String address = utility.userInputString();
		
		System.out.println("Enter city");
		String city = utility.userInputString();
		
		System.out.println("Enter state");
		String state = utility.userInputString();
		
		System.out.println("Enter zip");
		String zip = utility.userInputString();
		
		System.out.println("Enter phone");
		String phone = utility.userInputString();
		
		String file=findFile();
		//System.out.println(file);
		addressBook.addPerson(firstName, lastName, address, city, state, zip, phone, file );	
	
			}
	

	public String findFile() {
		System.out.println("Enter file name which you want to add");
		String fileName=utility.userInputString();
		
		File dir = new File("/home/bridgelabz/Documents/json/");
		 String[] children = dir.list();
		/*for(int i=0;i<children.length;i++)	 
		 System.out.println(children[i]);*/
		int i=0;
         String filename = children[i];
       
       while (i<children.length && !filename.contains(".json")){
           i++;
           filename = children[i];
       }
       String file1="/home/bridgelabz/Documents/json/"+fileName+".json";
       //System.out.println(fileName);
       return file1;
	}

	public void doEdit(int index) throws JsonGenerationException, JsonMappingException, IOException, ParseException  {
		String file=findFile();
		System.out.println("Edit Adaress ");
		String address = utility.userInputString();
		
		System.out.println("Edit city");
		String city = utility.userInputString();
		
		System.out.println("Edit state");
		String state = utility.userInputString();
		
		System.out.println("Edit zip");
		String zip = utility.userInputString();
		
		System.out.println("Edit phone");
		String phone = utility.userInputString();
		
		addressBook.updatePerson(index, address, city, state, zip, phone,file);
	}

	public void doDelete(int index) throws FileNotFoundException, IOException, ParseException {
		String file=findFile();
		addressBook.removePerson(index,file);
	}
	public void doGetPersonName(int index) throws FileNotFoundException, IOException, ParseException {
		String file=findFile();
		String name=addressBook.getFullNameOfPerson(index, file);
		System.out.println("full name: "+name);
		int noOfPersons=addressBook.getNumberOfPersons(file);
		System.out.println("noOfPersons"+noOfPersons);
	}
	

	public void doOpen() {
		String file=findFile();
		
	}

	public void doSortByName() throws FileNotFoundException, IOException, ParseException {
		String file=findFile();
		addressBook.sortByName(file);
	}

	public void doSortByZip() {
		addressBook.sortByZip();
	}
    public void doGet(int index) throws FileNotFoundException, IOException, ParseException {
    	String file=findFile();
    	String[] info=addressBook.getOtherPersonInformation(index, file);
    	for (int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
		}
    }
	public void doPrint() {
	
		
	}
	
}
