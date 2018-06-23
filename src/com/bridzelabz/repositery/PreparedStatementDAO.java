/**
 * purpose: Implementation class for the UserDAO interface with respect to PreparedStatement 
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridzelabz.repositery;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;
import com.bridgelabz.services.UserServices;
import com.bridgelabz.services.UserServicesImplementation;

public class PreparedStatementDAO implements UserDAO {
	UserServices userServices = new UserServicesImplementation();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
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
		connection = setConnection();
		// User user=userServices.register();
		int id = 0;

		String insert = "insert into user values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getEmailId());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("Registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void loginUser(User user) {

		String select = "select * from user";
		try {
			preparedStatement = connection.prepareStatement(select);
			resultSet = preparedStatement.executeQuery();
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
				System.out.println("User name or password incorrect");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void resetPassword(User user) {
		boolean search = false;
		connection = setConnection();
		PreparedStatement preparedstatement1 = null;
		String query = "select * from logindetails";
		String query1 = "update logindetails set password='" + user.getPassword() + "' where user_name='"
				+ user.getUserName() + "')";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (user.getUserName().equals(resultSet.getString(2))) {
					preparedstatement1 = connection.prepareStatement(query1);
					preparedstatement1.executeUpdate(query1);
					System.out.println("password reset successfully");
					search = true;
					break;
				}

			}
			if (!search) {
				System.out.println("user name not exist please register");
			}

		} catch (SQLException e) {
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
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
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
