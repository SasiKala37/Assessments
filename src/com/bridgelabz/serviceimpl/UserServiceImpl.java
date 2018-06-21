package com.bridgelabz.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;
import com.bridgelabz.sample.Utility;
import com.bridgelabz.service.UserService;

public class UserServiceImpl implements UserService {
	User user = new User();
	Connection con = Utility.connections();
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;

	@Override
	public void login() throws SQLException {
		boolean search = false;
		String query = "select * from logindetails";
		try {
			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Enter user name without spaces");
		String name = Utility.userInputString();
		while (rs.next()) {
			if (name.equals(rs.getString(2))) {
				System.out.println("Enter password");
				String pwd = Utility.userInputString();
				if (pwd.equals(rs.getString(3))) {
					System.out.println("login successfully");
				} else {
					System.out.println("Invalid password Try Again!!!");
				}
				search = true;
				break;
			}
		}
		if (!search) {
			System.out.println("Username not existed please register");
			register();
		}
		
	}

	@Override
	public void register() throws SQLException {
		String query = "insert into logindetails values(?,?,?)";
		preparedStatement = con.prepareStatement(query);
		user = Utility.insert();
		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getPassword());
		int rs1 = preparedStatement.executeUpdate();
		if (rs1 != 0) {
			System.out.println("Registered successfully");
		}
	}

	@Override
	public void forgotPassword(String name) throws SQLException {
		boolean search = false;
		PreparedStatement pstmt = null;
		String query = "select * from logindetails";
		String query1 = "update logindetails set password=? where user_name=?";
		pstmt = con.prepareStatement(query1);
		preparedStatement = con.prepareStatement(query);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			// System.out.println(rs.getInt(1)+" user id");
			if (name.equals(rs.getString(2))) {

				System.out.println("Enter password");
				String pwd = Utility.userInputString();

				boolean valid = Utility.validate(pwd);
				if (valid) {
					pstmt.setString(1, pwd);
					pstmt.setString(2, rs.getString(2));
					pstmt.executeUpdate();
					System.out.println("Password reset successfully");
				} else {
					System.out.println(
							"password should consists of min of 8 chars along with special,upper,lower and digits");
				}
				search = true;
				break;
			}

		}
		if (!search) {
			System.out.println("user name not exist please register");
			register();
		}

	}

}
