/**
 * 
 */
package com.bridgelabz.services;

/**
 * @author bridgelabz
 *
 */
public interface AddressBookManager {
	public void createAddressBook(String addressBook);
	public void openAddressBook(String addressBook);
	public void viewAddressBook();
	public void deleteAddressBook(String addressBook);
	public void addPerson(String addressBook);
	public void updatePerson(String addressBook);
	public void removePerson( String addressBook);
	
	
}
