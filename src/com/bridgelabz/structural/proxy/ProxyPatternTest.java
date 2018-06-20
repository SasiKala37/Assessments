package com.bridgelabz.structural.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {
		CommandExecuter executor = new CommandExecuterProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
	}

}
