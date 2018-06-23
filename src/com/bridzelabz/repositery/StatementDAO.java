/**
 * purpose: Implementation class for the UserDAO interface with respect to Statement 
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridzelabz.repositery;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;
import com.bridgelabz.services.UserServices;
import com.bridgelabz.services.UserServicesImplementation;
import com.bridgelabz.util.Utility;

public class StatementDAO implements UserDAO {
	UserServices userServices = new UserServicesImplementation();
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	@Override
	public Connection setConnection() {
		try {
			connection = DataSource.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void save(User user) {
		String insert = "insert into user values(" + "0" + ",'" + user.getUserName() + "','" + user.getEmailId() + "','"
				+ user.getPassword() + "'" + ")";
		try {
			statement =  setConnection().createStatement();
			statement.executeUpdate(insert);
			System.out.println("Register successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void loginUser(User user) {
		String select = "select * from user";
		try {
			statement = setConnection().createStatement();
			resultSet = statement.executeQuery(select);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		boolean search = false;
		try {
			while (resultSet.next()) {
				if (user.getUserName().equals(resultSet.getString(2))
						&& user.getPassword().equals(resultSet.getString(4))) {
					System.out.println("login successfully");
					search = true;
				}
			}
			if (!search) {
				System.out.println("User or password not valid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void resetPassword(User user) {
		boolean search=false;
		Statement statement1=null;
		String query = "select * from logindetails";
		String query1 = "update logindetails set password='"+user.getPassword()+"' where user_name='"+user.getUserName()+"')";
		try {
		statement = connection.createStatement();
		resultSet=statement.executeQuery(query);
		

		while (resultSet.next()) {
			if (user.getUserName().equals(resultSet.getString(2))) {
				statement1 = setConnection().createStatement();
				statement1.executeUpdate(query1);
				System.out.println("password reset successfully");
				search = true;
				break;
			}

		}
		if (!search) {
			System.out.println("user name not exist please register");
		}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}
