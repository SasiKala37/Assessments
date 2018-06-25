/**
 * Purpose: To perform the CURD operation with database
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.repository;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bridgelabz.model.Person;
import com.bridgelabz.util.Utility;
import com.mchange.v1.lang.GentleThread;

public class JdbcParsing implements FileParsing {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<Person> personList = new ArrayList<>();

	/**
	 * Establish the connection with JDBc
	 * 
	 * @return database connection
	 */
	public Connection setConnection() {
		try {
			connection = DataSource.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void create(String addressBookName) {
		String insert = "insert into address_book values('" + addressBookName + "')";
		Statement statement1 = null;
		String query = "create table " + addressBookName
				+ "(id int(2) auto_increment,first_name varchar(15),last_name varchar(10),address varchar(20),city varchar(20),state varchar(3),zip int(5),phone int(10),primary key(id))";
		try {
			statement = setConnection().createStatement();
			boolean result = statement.execute(query);
			statement1 = setConnection().createStatement();
			statement1.execute(insert);
			if (!result) {
				System.out.println("new AddressBook Created");
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void open(String addressBook) {
		boolean found = false;
		Statement statement1 = null;
		ResultSet resultSet1 = null;
		String addressBooks = "select * from address_book";
		String select = "select * from " + addressBook;
		try {
			statement = setConnection().createStatement();
			resultSet = statement.executeQuery(addressBooks);
			statement1 = setConnection().createStatement();
			resultSet1 = statement1.executeQuery(select);
			while (resultSet.next()) {
				if (resultSet.getString(1).equalsIgnoreCase(addressBook)) {
					System.out.println("address book found\n");
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("address book found\n");
			}
			while (resultSet1.next()) {
				System.out.println("person id:" + resultSet1.getInt(1) + "\n" + "first name:" + resultSet1.getString(2)
						+ "\n" + "last name:" + resultSet1.getString(3) + "\n" + "Address:" + resultSet1.getString(4)
						+ "\n" + "City:" + resultSet1.getString(5) + "\n" + "State:" + resultSet1.getString(6) + "\n"
						+ "Zip:" + resultSet1.getInt(7) + "\n" + "Phone number:" + resultSet1.getLong(8));
				System.out.println();
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String addressBook) {
		String delete = "delete from address_book where name='" + addressBook + "'";
		String drop = "drop table " + addressBook;
		try {
			statement = setConnection().createStatement();
			statement.execute(delete);
			statement = setConnection().createStatement();
			statement.execute(drop);
			System.out.println("deleted the addressbook");
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void view() {
		String addressBooks = "select * from address_book";
		try {
			statement = setConnection().createStatement();
			resultSet = statement.executeQuery(addressBooks);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void savePerson(Person person, String addressBook) {

		String insert = "insert into " + addressBook + " values(?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = setConnection().prepareStatement(insert);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, person.getFirstName());
			preparedStatement.setString(3, person.getLastName());
			preparedStatement.setString(4, person.getAddress());
			preparedStatement.setString(5, person.getCity());
			preparedStatement.setString(6, person.getState());
			preparedStatement.setInt(7, person.getZip());
			preparedStatement.setLong(8, person.getPhone());
			preparedStatement.execute();
			System.out.println("Person address added successfully");
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePerson(Person person, String addressBook) {
		String update = "update " + addressBook + " set address=?, city=?, state=?, zip=?, phone=? where first_name=?";
		try {
			preparedStatement = setConnection().prepareStatement(update);
			preparedStatement.setString(1, person.getAddress());
			preparedStatement.setString(2, person.getCity());
			preparedStatement.setString(3, person.getState());
			preparedStatement.setInt(4, person.getZip());
			preparedStatement.setLong(5, person.getPhone());
			preparedStatement.setString(6, person.getFirstName());
			preparedStatement.executeUpdate();

			System.out.println("updated person address successfully");
			closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deletePerson(Person person, String addressBook) {
		String delete = "delete from " + addressBook + " where first_name='" + person.getFirstName() + "'";
		try {
			statement = setConnection().createStatement();
			statement.execute(delete);
			System.out.println("Deleted the person");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close all the connections
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
