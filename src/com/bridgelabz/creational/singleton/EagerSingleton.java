/**
 * Purpose:Create the Singleton class implementation
 * 
 * @author sasikala
 * @version 1.0
 * @since 14-06-2018
 * */
package com.bridgelabz.creational.singleton;

public class EagerSingleton {

	private static final EagerSingleton instance = new EagerSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerSingleton() {

	}

	/**
	 * A static method to return the instance of the singleton class
	 * 
	 * @return the instance of the singleton class
	 */
	public static EagerSingleton getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(getInstance());
	}

}
