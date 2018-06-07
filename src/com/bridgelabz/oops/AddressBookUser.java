package com.bridgelabz.oops;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookUser {

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		AddressBookController controller = new AddressBookController();
		Utility utility = new Utility();

		System.out.println("1:create new json file");
		System.out.println("2:Add a person");
		System.out.println("3:Edit person details");
		System.out.println("4:Delete a person");
		System.out.println("5:Sort Entries by name");
		System.out.println("6:Sort entries by zip");
		System.out.println("7:print entries");
		System.out.println("8:Exit");
		int choice = 0;
		while (choice < 9) {
			System.out.println("Enter your choice ");
			choice = utility.userInputInteger();
			switch (choice) {
			case 1:
				
				controller.doNew();
				
				break;
			case 2:
				
				controller.doAdd();
				break;
			case 3:
				System.out.println("Enter index to edit");
				int index = utility.userInputInteger();
				controller.doEdit(index);
				break;
			case 4:
				System.out.println("Enter index to delete");
				int indexD = utility.userInputInteger();
				
				controller.doDelete(indexD);
				break;
			case 5:
				System.out.println("Sort by name");
				controller.doSortByName();
				break;
			case 6:
				System.out.println("Sort by zip");
				controller.doSortByZip();
				break;
			case 7:
				System.out.println("enter index to get person information");
				int indexp=utility.userInputInteger();
				controller.doGet(indexp);
				break;
			case 8:System.out.println("enter index to get person name");
			int indexn=utility.userInputInteger();
			controller.doGetPersonName(indexn);
				
			default: System.out.println("wrong input");
			break;
			}
			choice++;
		}

	}

}
