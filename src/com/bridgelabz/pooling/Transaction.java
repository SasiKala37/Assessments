package com.bridgelabz.pooling;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Transaction {

	public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		Savepoint sp=null;
		String insert="insert into employee values(?,?,?)";
		String insert1="insert into studentdetails values(?,?)";
		/*System.out.println("Enter employee id");
		int empid=Utility.userInputInteger();*/
		int empid=0;
		System.out.println("Enter employee name");
		String empName=Utility.userInputString();
		System.out.println("Enter the employee designation");
		String designation=Utility.userInputString();
		System.out.println("Enter Student id");
		int stuId=Utility.userInputInteger();
		System.out.println("Enter the student name");
		String stuName=Utility.userInputString();
		connection=DataSource.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
			pstmt=connection.prepareStatement(insert);
			pstmt.setInt(1, empid);
			pstmt.setString(2, empName);
			pstmt.setString(3, designation);
			pstmt.executeUpdate();
			 sp=connection.setSavepoint();
			
			pstmt1=connection.prepareStatement(insert1); 
			pstmt1.setInt(1, stuId);
			pstmt1.setString(2, stuName);
			pstmt1.executeUpdate();
			 connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback(sp);
				connection.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			if(pstmt1!=null) {
				pstmt1.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
	}

}
