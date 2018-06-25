/**
 * Purpose:Perform the read, write, update and delete operations with JSON file
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;

import com.bridgelabz.model.Person;

public class JsonFileParsing implements FileParsing {
	static ObjectMapper mapper = new ObjectMapper();
	ArrayList<Person> personList = new ArrayList<>();

	@Override
	public void create(String addressBookName) {

		ArrayList<String> arrayList = new ArrayList<>();
		File file1 = new File("/home/bridgelabz/Documents/addressbook/" + addressBookName + ".json");
		try {
			mapper.writeValue(file1, arrayList);
			System.out.println("new file created\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void view() {
		File directory = new File("/home/bridgelabz/Documents/addressbook");
		String[] children = directory.list();
		for (int i = 0; i < children.length; i++) {
			System.out.println(children[i]);
		}
	}

	public String SelectAddressBook(String addressBook) throws IOException {
		File directory = new File("/home/bridgelabz/Documents/addressbook/");
		String[] children = directory.list();
		String file = null;
		boolean found = false;
		String name = addressBook + ".json";
		for (int i = 0; i < children.length; i++) {
			if (name.equalsIgnoreCase(children[i])) {
				file = "/home/bridgelabz/Documents/addressbook/" + name;
				System.out.println("Address book opened");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Addressbook not found");
		}
		
		return file;
	}

	@Override
	public void delete(String addressBook) {
		File file = new File("/home/bridgelabz/Documents/addressbook/" + addressBook + ".json");
		file.delete();

	}

	@Override
	public void open(String addressBook) {
		try {
			SelectAddressBook(addressBook);
			File file = new File("/home/bridgelabz/Documents/addressbook/" + addressBook + ".json");
			personList=parseJSONArray(file, Person.class);
			for(Person person:personList) {
				System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<T> arrayList = new ArrayList<T>();
		CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
		arrayList = mapper.readValue(file, javaType);

		return arrayList;

	}

	@Override
	public void savePerson(Person person, String fileName) {
		try {
			File file = new File("/home/bridgelabz/Documents/addressbook/" + fileName + ".json");
			personList = parseJSONArray(file, Person.class);

			personList.add(person);
			mapper.writeValue(file, personList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePerson(Person person, String addressBook) {
		boolean found = false;
		try {
			File file = new File("/home/bridgelabz/Documents/addressbook/" + addressBook + ".json");
			personList = parseJSONArray(file, Person.class);

			for (int i = 0; i < personList.size(); i++) {
				if (personList.get(i).getFirstName().equalsIgnoreCase(person.getFirstName())) {
					personList.get(i).setAddress(person.getAddress());
					personList.get(i).setCity(person.getCity());
					personList.get(i).setState(person.getState());
					personList.get(i).setZip(person.getZip());
					personList.get(i).setPhone(person.getPhone());
					System.out.println("Updated sucessfully");
					mapper.writeValue(file, personList);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("not found the person name");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deletePerson(Person person, String addressBook) {
		boolean found = false;
		try {
			File file = new File("/home/bridgelabz/Documents/addressbook/" + addressBook + ".json");
			personList = parseJSONArray(file, Person.class);

			for (int i = 0; i < personList.size(); i++) {
				if (personList.get(i).getFirstName().equalsIgnoreCase(person.getFirstName())) {
					personList.remove(i);
					mapper.writeValue(file, personList);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("not found the person name");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
