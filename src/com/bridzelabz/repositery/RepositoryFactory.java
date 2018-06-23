/**
 * purpose: factory class give the instance class as per the user request
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridzelabz.repositery;

public class RepositoryFactory {
	UserDAO userDAO;
	public static UserDAO getStatementType(String statementType) {
		if(statementType.equals("statement")) {
			return new StatementDAO();
		}
		if(statementType.equalsIgnoreCase("preparedstatement")) {
			return new PreparedStatementDAO();
		}
		return null;
	}
} 
