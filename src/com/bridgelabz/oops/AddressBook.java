package com.bridgelabz.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBook extends Observable implements Serializable {
	ArrayList<Person> personDetails = new ArrayList<>();
	ArrayList<AddressBook> addressBookList=new ArrayList<>();
	LinkedList<File> addressFiles=new LinkedList<>();
	Object object=new Object();
	Person.CompareByName compareByName = new Person.CompareByName();
	Person.CompareByZip compareByZip = new Person.CompareByZip();
	Person person;
	Utility utility = new Utility();
	ObjectMapper mapper = new ObjectMapper();
	/*public AddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Enter the new address book name");
		String addressBookName = utility.userInputString();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("/home/bridgelabz/Documents/json/" + addressBookName + ".json"),personDetails);
		
	}
	*/
	
	public AddressBook() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.out.println("Enter the new address book name");
		String addressBookName = utility.userInputString();
		File file=new File("/home/bridgelabz/Documents/json/" + addressBookName + ".json");
		addressFiles.add(file);
		/*System.out.println("enter no. of persons list");
		int noOfPerson = utility.userInputInteger();
		for (int i = 0; i < noOfPerson; i++) {
			person = personData();
			personDetails.add(person);
		}*/
		//addressFiles.add(new File("/home/bridgelabz/Documents/json/" + addressBookName + ".json"));
		
		mapper.writeValue(file,addressFiles);
		/*JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/bridgelabz/Documents/json/" + addressBookName + ".json"));
		JSONObject jsonobject = (JSONObject) obj;
		JSONArray personArray = (JSONArray) jsonobject.get("personDetails");*/
	}

	
	/**
	 * @param firstName
	 *            the person's first name
	 * @param lastName
	 *            the person's last name
	 * @param address
	 *            the person's address
	 * @param city
	 *            the person's city
	 * @param state
	 *            the person's state
	 * @param zip
	 *            the person's zip
	 * @param phone
	 *            the person's phone
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone,String fileName) throws JsonGenerationException, JsonMappingException, IOException {
	      File file =new File("/home/bridgelabz/Documents/json/" +fileName+".json");
		
		person = new Person(firstName, lastName, address, city, state, zip, phone);
		personDetails.add(person);
		mapper.writeValue(file, personDetails);
		
	}

	/**
	 * @return the number of persons in the collection
	 */
	public int getNumberOfPersons() {
		return personDetails.size();
	}

	/**
	 * @param index
	 *            the position of the desired person
	 * @return the person's full name, in a form suitable for displaying or printing
	 */
	public String getFullNameOfPerson(int index) {
		String fullName = "";
		if (index == personDetails.indexOf(person)) {
			fullName = person.getFirstName() + " " + person.getLastName();
		}
		return fullName;
	}

	/**
	 * @param index
	 * @return
	 */
	public String[] getOtherPersonInformation(int index) {
		String[] otherPersonInformation = new String[5];
		if (index == personDetails.indexOf(person)) {
			otherPersonInformation[0] = person.getAddress();
			otherPersonInformation[1] = person.getCity();
			otherPersonInformation[2] = person.getState();
			otherPersonInformation[3] = person.getZip();
			otherPersonInformation[4] = person.getPhone();
		}
		return otherPersonInformation;
	}

	/**
	 * @param index
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void updatePerson(int index, String address, String city, String state, String zip, String phone) {
		if (index == personDetails.indexOf(person)) {
			person.update(address, city, state, zip, phone);
		}
	}

	/**
	 * @param index
	 */
	public void removePerson(int index) {
		if (index == personDetails.indexOf(person)) {
			personDetails.remove(index);
		}

	}

	// Sort the collection by name
	public void sortByName() {
		for (int index = 0; index < personDetails.size(); index++) {
			compareByName.compare(personDetails.get(index), personDetails.get(index + 1));
		}
	}

	// Sort the collection by zip
	public void sortByZip() {
		for (int index = 0; index < personDetails.size(); index++) {
			compareByName.compare(personDetails.get(index), personDetails.get(index + 1));
		}
	}

	// print the address of the person
	public void printAll() throws FileNotFoundException, IOException, ParseException {

		new AddressBook();
		JSONParser parser = new JSONParser();
		
	}

	public Person getWrite(Person person) throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("enter no. of persons list");
		int noOfPerson = utility.userInputInteger();
		for (int i = 0; i < noOfPerson; i++) {
			//person = personData();
			personDetails.add(person);
		}
		return person;
	}

	

}
