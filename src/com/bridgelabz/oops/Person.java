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
	 * Comparator for comparing two persons by alphabetical order of name
	 */
	public static class CompareByName implements Comparator<Object> {
		/**
		 * Compare two objects (which must both be Persons) by last name, with ties
		 * broken by first name
		 *
		 * @param person1
		 *            the first object
		 * @param person2
		 *            the second object
		 * @return a negative number if person1 belongs before person2 in alphabetical
		 *         order of name; 0 if they are equal; a positive number if person1
		 *         belongs after person2
		 *
		 * @exception ClassCastException
		 *                if either parameter is not a Person object
		 */
		public int compare(Object person1, Object person2) {
			int compareByLast = ((Person) person1).getLastName().compareTo(((Person) person2).getLastName());
			if (compareByLast != 0)
				return compareByLast;
			else
				return ((Person) person1).getFirstName().compareTo(((Person) person2).getFirstName());
		}

		/**
		 * Compare two objects (which must both be Persons) by name
		 *
		 * @param person1
		 *            the first object
		 * @param person2
		 *            the second object
		 * @return true if they have the same name, false if they do not
		 *
		 * @exception ClassCastException
		 *                if either parameter is not a Person object
		 */
		public boolean equals(Object person1, Object person2) {
			return compare(person1, person2) == 0;
		}
	}

	/**
	 * Comparator for comparing two persons by order of zip code
	 */
	public static class CompareByZip implements Comparator<Object>{
		/**
		 * Compare two objects (which must both be Persons) by zip
		 *
		 * @param person1
		 *            the first object
		 * @param person2
		 *            the second object
		 * @return a negative number if person1 belongs before person2 in order of zip;
		 *         0 if they are equal; a positive number if person1 belongs after
		 *         person2
		 *
		 * @exception ClassCastException
		 *                if either parameter is not a Person object
		 */
		public int compare(Object person1, Object person2) {
			int compareByZip = ((Person) person1).getZip().compareTo(((Person) person2).getZip());
			if (compareByZip != 0)
				return compareByZip;
			else
				return new CompareByName().compare(person1, person2);
		}

		/**
		 * Compare two objects (which must both be Persons) by zip
		 *
		 * @param person1
		 *            the first object
		 * @param person2
		 *            the second object
		 * @return true if they have the same zip, false if they do not
		 *
		 * @exception ClassCastException
		 *                if either parameter is not a Person object
		 */
		public boolean equals(Object person1, Object person2) {
			return compare(person1, person2) == 0;
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

	public Person() {
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
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
