/**
 * Purpose:Interface to specify the tasks of Addressbook manager
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.model;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phone;

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

	
}
