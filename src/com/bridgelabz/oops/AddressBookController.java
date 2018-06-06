package com.bridgelabz.oops;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookController extends Object {
	AddressBook addressBook ;
	Utility utility = new Utility();
	Person person = new Person();
	public AddressBookController() throws JsonGenerationException, JsonMappingException, IOException {
		// new AddressBook();

	}

	public void doAdd(String firstName, String lastName, String address, String city, String state, String zip,
			String phone,String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {	
	
		addressBook.addPerson(firstName, lastName, address, city, state, zip, phone, fileName);
		
	
			}

	public void doEdit(int index)  {
		
		System.out.println("Edit Adaress ");
		String address = utility.userInputString();
		person.setAddress(address);

		System.out.println("Edit city");
		String city = utility.userInputString();
		person.setCity(city);

		System.out.println("Edit state");
		String state = utility.userInputString();
		person.setState(state);

		System.out.println("Edit zip");
		String zip = utility.userInputString();
		person.setZip(zip);

		System.out.println("Edit phone");
		String phone = utility.userInputString();
		person.setPhone(phone);
		addressBook.updatePerson(index, address, city, state, zip, phone);
	}

	public void doDelete(int index) {
		addressBook.removePerson(index);
	}

	public void doNew() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		new AddressBook();

	}

	public void doOpen() {
		//addressBook.printAll();
	}

	public void doSortByName() {
		addressBook.sortByName();
	}

	public void doSortByZip() {
		addressBook.sortByZip();
	}

	public void doPrint() {
	
		
	}
	
}
