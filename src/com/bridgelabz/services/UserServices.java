/**
 * purpose: Specify the user services of login or registration application
 *  @author sasikala
 *  @version 1.0
 *  @since 22-062018
 */
package com.bridgelabz.services;

public interface UserServices {
	//login the user
	void login();
	//register user
	void register();
	//if user forgot the password then reset 
	 void forgotPassword();
	 //exit from the login/register form
	 void exit();
}
