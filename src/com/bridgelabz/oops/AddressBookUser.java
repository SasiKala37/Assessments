/**
 * Purpose: implementation of address book problem
 * @author SasiKala
 * @version 1.0
 * @since 08-06-2018
 */
package com.bridgelabz.oops;

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
		System.out.println("1: CREATE THE NEW ADDRESSBOOK");
		System.out.println("2: OPEN THE EXISTED ADDRESSBOOK");
		System.out.println("3: VIEW THE ADDRESSBOOKS");
		System.out.println("4: EDIT THE ADDRESSBOOK");
		System.out.println("5: EXIT THE ADDRESSBOOK");
		int choice = 0;
		while (choice < 6) {
			System.out.println("enter your choice to do which operation");
			choice = utility.userInputInteger();
			switch (choice) {
			case 1:
					controller.doNew();
				break;
			case 2:
				controller.doOpen();
				break;
			case 3:
				controller.doView();
				break;
			case 4:
				System.out.println("Edit the information");
				int input = 0;
				System.out.println("1:add person address");
				System.out.println("2:Edit person details");
				System.out.println("3:Delete a person");
				System.out.println("4:Sort Entries by name");
				System.out.println("5:Sort entries by zip");
				System.out.println("6:Get the information of particular person");
				System.out.println("7:Get the person full name based on the index");
                controller.doView();
                String file=controller.findFile();
				while (input < 8) {
					System.out.println("enter your choice to do which operation");
					input = utility.userInputInteger();
					
					switch (input) {
					case 1: controller.doAdd( file);
					break;
					case 2:
						System.out.println("Enter index to edit");
						int index = utility.userInputInteger();
						controller.doEdit(index,file);
						break;
					case 3:
						System.out.println("Enter index to delete");
						int indexD = utility.userInputInteger();
						controller.doDelete(indexD,file);
						break;
					case 4:
						System.out.println("Sort by name");
						controller.doSortByName(file);
						break;
					case 5:
						System.out.println("Sort by zip");
						controller.doSortByZip(file);
						break;
					case 6:
						System.out.println("enter index to get person information");
						int indexp = utility.userInputInteger();
						controller.doGet(indexp,file);
						break;
					case 7:
						System.out.println("enter index to get person name");
						int indexn = utility.userInputInteger();
						controller.doGetPersonName(indexn,file);
						break;
					default:
						System.out.println("wrong input");
						break;
					}
					input++;
				}
				break;
			case 5:
				System.out.println("Exit the address book");
				break;
			}
			choice++;
		}
	}
}
