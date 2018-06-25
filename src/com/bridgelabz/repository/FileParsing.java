/**
 * Purpose:Interface to specify the file operations
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.repository;

import com.bridgelabz.model.Person;

public interface FileParsing {
	/**
	 * Crate the new address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	void create(String addressBook);

	/**
	 * open the existed address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	void open(String addressBook);

	/**
	 * View the existed list of address book
	 */
	void view();

	/**
	 * Delete address book
	 * 
	 * @param addressBook
	 *            address book name
	 */
	void delete(String addressBook);

	/**
	 * Save/add the person
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	void savePerson(Person person, String addressBook);

	/**
	 * update person details in address book
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	void updatePerson(Person person, String addressBook);

	/**
	 * Delete the person details from the address book
	 * 
	 * @param person
	 *            instance of the person
	 * @param addressBook
	 *            address book name
	 */
	void deletePerson(Person person, String addressBook);
}
