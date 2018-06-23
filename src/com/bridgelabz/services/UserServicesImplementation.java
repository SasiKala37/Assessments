/**
 * purpose: Implementation class for the UserServices interface
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridgelabz.services;

import com.bridgelabz.model.User;
import com.bridgelabz.util.Utility;
import com.bridzelabz.repositery.RepositoryFactory;
import com.bridzelabz.repositery.UserDAO;


public class UserServicesImplementation implements UserServices {
	//UserDAO userDAO=new StatementDAO();
	User user=new User();
	String statementType; 
	UserDAO userDAO;
	public UserServicesImplementation() {
	}
	public UserServicesImplementation(String statementType) {
		userDAO=(UserDAO) RepositoryFactory.getStatementType(statementType);
	}
	@Override
	public void login() {
		System.out.println("Enter user name");
		String userName=Utility.userInputString();
		user.setUserName(userName);
		System.out.println("Enter Password");
		String password=Utility.userInputString();
		user.setPassword(password);
		userDAO.loginUser(user);
		
	} 

	@Override
	public void register() {
		System.out.println("Enter user name");
		String userName=Utility.userInputString();
		user.setUserName(userName);
		System.out.println("Enter email id");
		String emailId=Utility.userInputString();
		user.setEmailId(emailId);
		System.out.println("Enter Password");
		String password=Utility.userInputString();
		if(Utility.validate(password)) {
		user.setPassword(password);}
		else {
			System.out.println("Not a valid password\nyou should enter atleast 1 character[a-z] [A-Z] [0-9][!@#$%_]");
			
		}
		userDAO.save(user);
		
		
	}

	@Override
	public void forgotPassword() {
		System.out.println("Enter user name");
		String userName=Utility.userInputString();
		user.setUserName(userName);
		System.out.println("Enter Password");
		String password=Utility.userInputString();
		if(Utility.validate(password)) {
		user.setPassword(password);}
		else {
			System.out.println("Not a valid password\nyou should enter atleast 1 character[a-z] [A-Z] [0-9][!@#$%_]");
			
		}
		userDAO.resetPassword( user);
	}
	
	public void exit() {
		userDAO.closeConnection();
		System.out.println("Exit the login/registration form");
	}

}
