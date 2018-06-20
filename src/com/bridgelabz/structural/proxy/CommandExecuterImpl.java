package com.bridgelabz.structural.proxy;

import java.io.IOException;

public class CommandExecuterImpl implements CommandExecuter {
	@Override
	public void runCommand(String cmd) throws IOException {
                //some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}
