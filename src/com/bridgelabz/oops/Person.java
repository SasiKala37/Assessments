package com.bridgelabz.oops;

import java.io.Serializable;
import java.util.Comparator;

public class Person extends Object implements Serializable {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	/**
	 * Comparator for comparing two persons by alphabetical order of last name
	 * 
	 * @author sasikala
	 *
	 */
	private class CompareByLastName implements Comparator<Person> {

		@Override
		public int compare(Person person1, Person person2) {
			return person1.lastName.compareTo(person2.lastName);
		}

		/*
		 * public boolean equals(Person person) { if (person instanceof Object ) {
		 * Object object =( Object)person; return object.
		 * firstName.equals(getFirstName()); } return false; }
		 */
	}

	/**
	 * Comparator for comparing two persons by alphabetical order of zip
	 * 
	 * @author Sasikala
	 *
	 */
	private static class CompareByZip implements Comparator<Person> {
		@Override
		public int compare(Person person1, Person person2) {
			return person1.zip.compareTo(person2.zip);
		}
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
	 */
	public Person(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	/**
	 * @return the person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the person's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the person's city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the person's state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the person's zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the person's zip
	 */
	public String getPhone() {
		return phone;
	}

	/**
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
	 */
	public void update(String address, String city, String state, String zip, String phone) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

}
