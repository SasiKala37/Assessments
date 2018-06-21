package com.bridgelabz.pooling;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {

	public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		connection=DataSource.getInstance().getConnection();
		DatabaseMetaData data;
		try {
			data = connection.getMetaData();
			String driver=data.getDriverName();
			String url=data.getURL();
			System.out.println("Data base meta data information\n");
			System.out.println("Driver name: "+driver);
			System.out.println("URL: "+url);
			
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from logindetails");
			ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			System.out.println("\nResultset metedata information");
			System.out.println("Column count: "+resultSetMetaData.getColumnCount());
			System.out.println("Column lable: "+resultSetMetaData.getColumnLabel(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} 
		 
	}

}
