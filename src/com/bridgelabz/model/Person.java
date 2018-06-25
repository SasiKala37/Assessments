package com.bridgelabz.model;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phone;

	/*
	*//**
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
	 *//*
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
*/
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

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setPhone(long phone) {
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
	public int getZip() {
		return zip;
	}

	/**
	 * @return the person's zip
	 */
	public long getPhone() {
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
	 *//*
	public void update(String address, String city, String state, String zip, String phone) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}*/
}
