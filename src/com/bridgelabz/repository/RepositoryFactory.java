/**
 * Purpose:Create the repository factory for selecting the instance of the class
 * 
 * @author SasiKala
 * @version 1.0
 * @since 23-06-2018
 * */
package com.bridgelabz.repository;

public class RepositoryFactory {
	/**
	 * choose the which file type then return the instance of the class
	 * 
	 * @param fileType
	 *            type of file name json/jdbc
	 * @return instance of the class
	 */
	public static FileParsing getFileType(String fileType) {
		if (fileType.equalsIgnoreCase("json")) {
			return new JsonFileParsing();
		}
		if (fileType.equalsIgnoreCase("jdbc")) {
			return new JdbcParsing();
		}
		return null;
	}
}
