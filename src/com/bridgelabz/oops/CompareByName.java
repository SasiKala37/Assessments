/**
	 * Comparator for comparing two persons by alphabetical order of last name
	 * 
	 * @author sasikala
	 *
	 */
package com.bridgelabz.oops;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {
	
	@Override
	public int compare(Person person1, Person person2) {
		return person1.getLastName().compareTo(person2.getLastName());
	}
	
}
