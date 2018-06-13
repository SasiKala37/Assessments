/**
 * Purpose: manage the AddressBook and AddressBook user
 * 
 */
package com.bridgelabz.oops.addressbook;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookController extends Object {
	AddressBook addressBook =new AddressBook();
	Utility utility = new Utility();
	Person person = new Person();
	public AddressBookController()  {

	}
	/**
	 * Create the new address book
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doNew() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		System.out.println("Enter the new address book name");
		String addressBookName = utility.userInputString();
		
		File file1=new File("/home/bridgelabz/Documents/json/"+addressBookName+".json");

		//addressBook.addressFiles.add(file1);

		addressBook.mapper.writeValue(file1,addressBook.addressFiles);
		System.out.println("new file created");

	}
	/**
	 * Add the person information in the address book
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doAdd(String file) throws JsonGenerationException, JsonMappingException, IOException, ParseException {	
		
		System.out.println("Enter first name");
		String firstName = utility.userInputString();

		System.out.println("Enter last name");
		String lastName = utility.userInputString();
		
		System.out.println("Enter Adaress ");
		String address = utility.userInputString();
		
		System.out.println("Enter city");
		String city = utility.userInputString();
		
		System.out.println("Enter state");
		String state = utility.userInputString();
		
		System.out.println("Enter zip");
		String zip = utility.userInputString();
		
		System.out.println("Enter phone");
		String phone = utility.userInputString();
		
		
		addressBook.addPerson(firstName, lastName, address, city, state, zip, phone, file );	
	
			
	}
//Find the particular file
	public String findFile() {
		System.out.println("Enter file name which you want ");
		String fileName=utility.userInputString();
		File dir = new File("/home/bridgelabz/Documents/json/");
		 String[] children = dir.list();
		/*for(int i=0;i<children.length;i++)	 
		 System.out.println(children[i]);*/
		int i=0;
        String  filename = children[i];
       
       while (i<children.length && !filename.contains(".json")){
           i++;
           filename = children[i];
       }
       String file1="/home/bridgelabz/Documents/json/"+fileName+".json";
       //System.out.println(fileName);
       return file1;
	}
	
	public void doView() {
		File dir = new File("/home/bridgelabz/Documents/json/");
		 String[] children = dir.list();
		for(int i=0;i<children.length;i++) {	 
		 System.out.println(children[i]);}
	}

	/**
	 * Edit the information at particular index
	 * @param index
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doEdit(int index,String file) throws JsonGenerationException, JsonMappingException, IOException, ParseException  {
		
		System.out.println("Edit Adaress ");
		String address = utility.userInputString();
		
		System.out.println("Edit city");
		String city = utility.userInputString();
		
		System.out.println("Edit state");
		String state = utility.userInputString();
		
		System.out.println("Edit zip");
		String zip = utility.userInputString();
		
		System.out.println("Edit phone");
		String phone = utility.userInputString();
		
		addressBook.updatePerson(index, address, city, state, zip, phone,file);
	}

	/**
	 * Delete the information at particular index
	 * @param index
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doDelete(int index,String file) throws FileNotFoundException, IOException, ParseException {
		
		addressBook.removePerson(index,file);
	}
	public void doDeleteAddressBook(String fileName) {
		File file=new File(fileName);
		file.delete();
	}
	/**
	 * Get the person full name
	 * @param index
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doGetPersonName(int index,String file) throws FileNotFoundException, IOException, ParseException {
		
		String name=addressBook.getFullNameOfPerson(index, file);
		System.out.println("full name: "+name);
		int noOfPersons=addressBook.getNumberOfPersons(file);
		System.out.println("noOfPersons "+noOfPersons);
	}
	

	/**
	 * open the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doOpen() throws FileNotFoundException, IOException, ParseException {
		
		File dir = new File("/home/bridgelabz/Documents/json/");
		 String[] children = dir.list();
		for(int i=0;i<children.length;i++)	 
		 System.out.println(children[i]);
		String file=findFile();
		addressBook.printAll(file);
	}

	/**
	 * Sort the person names based on the last name
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void doSortByName(String file) throws FileNotFoundException, IOException, ParseException {
		
		addressBook.sortByName(file);
	}
	/**
	 * Sort the person names based on the zip code
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */

	public void doSortByZip(String file) throws FileNotFoundException, IOException, ParseException {
		
		addressBook.sortByZip(file);
	}
	
    /**
     * get the person information based on the index
     * @param index
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public void doGet(int index,String file) throws FileNotFoundException, IOException, ParseException {
    	
    	String[] info=addressBook.getOtherPersonInformation(index, file);
    	for (int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
		}
    }
	/*public void doPrint() throws FileNotFoundException, IOException, ParseException {
		String file=findFile();
		addressBook.printAll(file);
		
	}*/
	
}
