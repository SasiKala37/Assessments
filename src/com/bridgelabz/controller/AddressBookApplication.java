package com.bridgelabz.controller;

import com.bridgelabz.services.AddressBookManager;
import com.bridgelabz.services.AddressBookManagerImplementation;
import com.bridgelabz.util.Utility;

public class AddressBookApplication {

	public static void main(String[] args) {
		String fileType = args[0];
		AddressBookManager addressBookManager = new AddressBookManagerImplementation(fileType);
		System.out.println("1: CREATE THE NEW ADDRESSBOOK");
		System.out.println("2: VIEW THE ADDRESSBOOKS");
		System.out.println("3: OPEN AND EDIT THE EXISTED ADDRESSBOOK");
		System.out.println("4: DELETE THE ADDRESSBOOK");
		System.out.println("5: EXIT THE ADDRESSBOOK");
		int choice = 0;
		while (choice < 5) {
			System.out.println("enter your choice to do which operation");
			choice = Utility.userInputInteger();
			switch (choice) {
			case 1:
				System.out.println("Enter address book name");
				String addressBook2= Utility.userInputString();
				addressBookManager.createAddressBook(addressBook2);
				System.out.println("1:Add Person");
				System.out.println("2:Quit the address book");
				int j = 0;
				while (j < 3) {
					System.out.println("enter your choice to do which operation");
					j = Utility.userInputInteger();
					switch (j) {
					case 1:
						addressBookManager.addPerson(addressBook2);
						break;
					case 2:
						System.out.println("Exit the address book");
						break;
					}
					j++;
				}
				break;
			case 2:
				addressBookManager.viewAddressBook();
				break;
			case 3:
				System.out.println("Enter address book name");
				String addressBook = Utility.userInputString();
				addressBookManager.openAddressBook(addressBook);
				System.out.println("1:Add Preson Address");
				System.out.println("2:Update person address");
				System.out.println("3:Delete Person addresss");
				int k = 0;
				while (k < 4) {
					System.out.println("enter your choice ");
					k = Utility.userInputInteger();
					switch (k) {
					case 1:
						addressBookManager.addPerson(addressBook);
						break;
					case 2:
						addressBookManager.updatePerson(addressBook);
						break;
					case 3:
						addressBookManager.removePerson(addressBook);
					}
					k++;
				}
				break;
			
			case 4:
				System.out.println("Enter address book name");
				String addressBook1 = Utility.userInputString();
				addressBookManager.deleteAddressBook(addressBook1);
				break;
			case 5:System.out.println("Exit");
			break;
			}
		}
	}

}
