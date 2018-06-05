package com.bridgelabz.oops;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class AddressBook extends Observable implements Serializable {
	ArrayList<Person> addPersonDetails=new ArrayList<>();
	public AddressBook() {

	}
    Person person;
	void addPerson( String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		person=new Person(firstName, lastName, address, city, state, zip, phone);
		addPersonDetails.add(person);
	}
}
