/**
 * Purpose:Interface to specify the tasks of Addressbook manager
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.services;

public interface AddressBookManager {
	/**
	 * Crate the new address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	public void createAddressBook(String addressBook);
	/**
	 * open the existed address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	public void openAddressBook(String addressBook);
	/**
	 * View the existed list of address book
	 */
	public void viewAddressBook();
	/**
	 * Delete address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	public void deleteAddressBook(String addressBook);
	/**
	 * Save/add the person
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	public void addPerson(String addressBook);
	/**
	 * update person details in address book
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	public void updatePerson(String addressBook);
	/**
	 * Delete the person details from the address book
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	public void removePerson( String addressBook);
	
	
}
