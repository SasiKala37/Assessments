/**
 * Purpose:using static block initialization of the Singleton class implementation 
 * 
 * @author sasikala
 * @version 1.0
 * @since 14-06-2018
 * */
package com.bridgelabz.creational.singleton;

public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	/**
	 * A static method to return the instance of the singleton class
	 * 
	 * @return the instance of the singleton class
	 */
	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(getInstance());
	}

}
