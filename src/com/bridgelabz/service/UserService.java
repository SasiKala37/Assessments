package com.bridgelabz.service;

import java.sql.SQLException;

public interface UserService {
	void login() throws SQLException;
	void register() throws SQLException;
	void forgotPassword(String name) throws SQLException;
}
