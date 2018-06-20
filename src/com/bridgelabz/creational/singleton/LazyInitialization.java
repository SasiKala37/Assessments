/**
 * Purpose:using Lazy initialization of the Singleton class implementation 
 * 
 * @author sasikala
 * @version 1.0
 * @since 14-06-2018
 * */
package com.bridgelabz.creational.singleton;

public class LazyInitialization {
	private static LazyInitialization instance;

	private LazyInitialization() {

	}

	public static LazyInitialization getInstance() {
		if (instance == null) {
			instance = new LazyInitialization();
		}
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(getInstance());
	}

}
