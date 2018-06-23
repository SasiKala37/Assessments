/**
 * purpose: Specify the database services of login or registration application
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridzelabz.repositery;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bridgelabz.model.User;

public interface UserDAO {
	//Establish the connection with database server
	Connection setConnection();
	//save the data into database
	void save(User user);
	//search the user in database whether present or not
	void loginUser(User user);
	//reset the password
	void resetPassword(User user);
	//close all the connections
	void closeConnection();
	
}
