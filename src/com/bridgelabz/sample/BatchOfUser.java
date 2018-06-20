package com.bridgelabz.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchOfUser {

	public static void main(String[] args) throws SQLException {
	Connection connection=null;
	Statement statement=null;
	String insert="insert into studentdetails values(4,'prateek')";
	String update="update studentdetails set id=6 where name='simran'";
	String delete="delete from studentdetails where id=2";
	try {
	connection=Utility.connections();
	statement=connection.createStatement();
	
	statement.addBatch(insert);
	statement.addBatch(update);
	statement.addBatch(delete);

	int[] array=statement.executeBatch();
	for (int i:array) {
		System.out.println(i);
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		if(statement!=null) {
			statement.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
	
	}

}
