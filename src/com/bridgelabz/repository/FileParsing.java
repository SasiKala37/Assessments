/**
 *  @author bridgelabz
 */
package com.bridgelabz.repository;

import com.bridgelabz.model.Person;

public interface FileParsing {
	void create(String addressBook);
	void open(String addressBook);
	void view();
	void delete(String addressBook);
	void savePerson(Person person, String addressBook);
	void updatePerson(Person person, String addressBook);
	void deletePerson(Person person, String addressBook);
	
	
	
}
