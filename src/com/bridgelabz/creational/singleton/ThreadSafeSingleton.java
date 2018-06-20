/**
 * Purpose:Provide the thread safe to the Singleton class implementation 
 * 
 * @author sasikala
 * @version 1.0
 * @since 14-06-2018
 * */
package com.bridgelabz.creational.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	/**
	 * A static method to return the instance of the singleton class
	 * 
	 * @return return the instance of the singleton class
	 */
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (ThreadSafeSingleton.class) {
	            if(instance == null){
	                instance = new ThreadSafeSingleton();
	            }
	        }
	    }
	    return instance;
	}
	public static void main(String[] args) {
		System.out.println(getInstance());
		System.out.println(getInstanceUsingDoubleLocking());
	}

}
