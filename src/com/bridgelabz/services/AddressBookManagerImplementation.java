/**
 * Purpose:Implementation class for the AddressBookManager Interface
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.services;

import com.bridgelabz.model.Person;
import com.bridgelabz.repository.FileParsing;
import com.bridgelabz.repository.RepositoryFactory;
import com.bridgelabz.util.Utility;

public class AddressBookManagerImplementation implements AddressBookManager {
	FileParsing fileParsing;
	Person person=new Person();
	public  AddressBookManagerImplementation(String fileType) {
		fileParsing=RepositoryFactory.getFileType(fileType);
	}
	@Override
	public void createAddressBook(String addressBook) {
	fileParsing.create(addressBook);
	}
	public void openAddressBook(String addressBook) {
		fileParsing.open(addressBook);
	}
	public void viewAddressBook() {
		fileParsing.view();
	}
	@Override
	public void deleteAddressBook(String addressBook) {
		fileParsing.delete( addressBook);
	}
	@Override
	public void addPerson(String addressBook) {
		System.out.println("Enter first name");
		String firstName=Utility.userInputString();
		person.setFirstName(firstName);
		System.out.println("Enter Last name");
		String lastName=Utility.userInputString();
		person.setLastName(lastName);
		System.out.println("Enter address");
		String address=Utility.userInputString();
		person.setAddress(address);
		System.out.println("Enter city ");
		String city=Utility.userInputString();
		person.setCity(city);
		System.out.println("Enter state");
		String state=Utility.userInputString();
		person.setState(state);
		System.out.println("Enter Zip");
		int zip=Utility.userInputInteger();
		person.setZip(zip);
		System.out.println("Enter phone number");
		long phone=Utility.userInputLong();
		person.setPhone(phone);
		fileParsing.savePerson(person,addressBook);
	}

	@Override
	public void updatePerson( String addressBook) {
		System.out.println("Enter first name");
		String firstName=Utility.userInputString();
		person.setFirstName(firstName);
		System.out.println("Enter address");
		String address=Utility.userInputString();
		person.setAddress(address);
		System.out.println("Enter city ");
		String city=Utility.userInputString();
		person.setCity(city);
		System.out.println("Enter state");
		String state=Utility.userInputString();
		person.setState(state);
		System.out.println("Enter Zip");
		int zip=Utility.userInputInteger();
		person.setZip(zip);
		System.out.println("Enter phone number");
		long phone=Utility.userInputLong();
		person.setPhone(phone);
		fileParsing.updatePerson(person, addressBook);
	}

	@Override
	public void removePerson(String addressBook) {
		System.out.println("Enter first name");
		String firstName=Utility.userInputString();
		person.setFirstName(firstName);
		fileParsing.deletePerson(person, addressBook);
	}
	
	

	
}
