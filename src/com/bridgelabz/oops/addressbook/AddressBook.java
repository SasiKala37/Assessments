package com.bridgelabz.oops.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

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
	// add the person details
	ArrayList<Object> arrayList = new ArrayList<>();

	// add files into the directory
	ArrayList<Object> addressFiles = new ArrayList<>();
	ArrayList<Person> personList=new ArrayList<>();
	Person.CompareByName compareByName = new Person.CompareByName();
	Person.CompareByZip compareByZip = new Person.CompareByZip();

	Person person = new Person();
	Utility utility = new Utility();
	ObjectMapper mapper = new ObjectMapper();

	// default constructor
	public AddressBook() {

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
	 * @throws ParseException
	 */
	public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String file)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		arrayList = pareseFile(file);
		person = new Person(firstName, lastName, address, city, state, zip, phone);
		arrayList.add(person);
		File file1 = new File(file);
		mapper.writeValue(file1, arrayList);
		arrayList = pareseFile(file);
		System.out.println(arrayList.toString());
	}
	
	/**
	 * Parse the file into json file
	 * 
	 * @param fileName
	 * @return persons list of information
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Object> pareseFile(String fileName) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(new File(fileName)));
		JSONArray array = (JSONArray) object;
		ArrayList<Object> arrayList = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			arrayList.add(obj);
		}

		return arrayList;
	}

	/**
	 * Get the number of persons in the address book
	 * 
	 * @return the number of persons in the collection
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public int getNumberOfPersons(String file) throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);
		System.out.println(arrayList.toString());
		return arrayList.size();
	}

	/**
	 * Get the full name of the person
	 * 
	 * @param index
	 *            the position of the desired person
	 * @return the person's full name, in a form suitable for displaying or printing
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public String getFullNameOfPerson(int index, String file)
			throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);

		JSONObject jsonObject = (JSONObject) arrayList.get(index);
		String fullName = (String) jsonObject.get("firstName") + " " + (String) jsonObject.get("lastName");
		//System.out.println(arrayList.toString());
		return fullName;
	}

	/**
	 * Get the person information
	 * 
	 * @param index
	 * @return person's information
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public String[] getOtherPersonInformation(int index, String file)
			throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);

		JSONObject jsonObject = (JSONObject) arrayList.get(index);
		String[] information = { (String) jsonObject.get("firstName"), (String) jsonObject.get("lastName"),
				(String) jsonObject.get("address"), (String) jsonObject.get("city"), (String) jsonObject.get("state"),
				(String) jsonObject.get("zip"), (String) jsonObject.get("phone") };

		return information;
	}

	/**
	 * 
	 * Update the person information
	 * 
	 * @param index
	 *            to update the information in that index
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
	 * @throws ParseException
	 */
	public void updatePerson(int index, String address, String city, String state, String zip, String phone,
			String file) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		arrayList = pareseFile(file);
		File file1 = new File(file);
		System.out.println(arrayList.toString());
		JSONObject jsonObject = (JSONObject) arrayList.get(index);
		String firstName = (String) jsonObject.get("firstName");
		String lastName = (String) jsonObject.get("lastName");
		arrayList.remove(jsonObject);
		person.update(address, city, state, zip, phone);
		person = new Person(firstName, lastName, address, city, state, zip, phone);
		arrayList.add(person);
		mapper.writeValue(file1, arrayList);
		System.out.println(arrayList.toString());
		arrayList = pareseFile(file);

	}

	/**
	 * Remove the person in the particular index
	 * 
	 * @param index
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void removePerson(int index, String file) throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);
		File file1 = new File(file);

		JSONObject jsonObject = (JSONObject) arrayList.get(index);
		System.out.println(arrayList.get(index));
		arrayList.remove(jsonObject);
		mapper.writeValue(file1, arrayList);
	}

	/**
	 * Sort the address book by person's last name
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void sortByName(String file) throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);
		File file1 = new File(file);
		/*
		 * for (int i = 0; i < arrayList.size(); i++) { JSONObject
		 * person1=(JSONObject)arrayList.get(i); //person1.get("lastName");
		 * arrayList.sort((Person.CompareByName)person1); }
		 */
		// mapper.writeValue(file1, arrayList);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			for (int j = 0; j < arrayList.size() - i - 1; j++) {

				JSONObject person1 = (JSONObject) arrayList.get(j);
				JSONObject person2 = (JSONObject) arrayList.get(j + 1);
				if ((person1.get("lastName").toString()).compareToIgnoreCase(person2.get("lastName").toString()) > 0) {
					JSONObject temp = person1;
					arrayList.set(j, person2);
					arrayList.set(j + 1, temp);
				}
			}
			mapper.writeValue(file1, arrayList);

		}
	}

	/**
	 * Sort the address book by person's last name
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void sortByZip(String file) throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);
		File file1 = new File(file);
		for (int i = 0; i < arrayList.size() - 1; i++) {
			for (int j = 0; j < arrayList.size() - i - 1; j++) {

				JSONObject person1 = (JSONObject) arrayList.get(j);
				JSONObject person2 = (JSONObject) arrayList.get(j + 1);
				if ((person1.get("zip").toString()).compareToIgnoreCase(person2.get("zip").toString()) > 0) {
					JSONObject temp = person1;
					arrayList.set(j, person2);
					arrayList.set(j + 1, temp);
				}
			}
			mapper.writeValue(file1, arrayList);

		}
	}

	/**
	 * print the address book information
	 * 
	 * @param file
	 *            to print particular address book
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void printAll(String file) throws FileNotFoundException, IOException, ParseException {
		arrayList = pareseFile(file);
		System.out.println(file + " Adress book");
		System.out.println(arrayList.toString());

	}
	
}
