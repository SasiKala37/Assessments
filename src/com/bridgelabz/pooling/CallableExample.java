package com.bridgelabz.pooling;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableExample {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			connection = DataSource.getInstance().getConnection();
			cstmt = connection.prepareCall("{call emp(?)}");
			cstmt.setInt(1, 3);
			rs = cstmt.executeQuery();
			rs.absolute(1);
			 while(rs.next()) {
			System.out.println("Employe id: " + rs.getInt(1) + " Employe name: " + rs.getString(2) + " Designation: "
					+ rs.getString(3));
			 }

		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

}
