package net.devsedge.io.console;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Getting the console.
		 * If running in Eclipse, you won't be able to get the console
		 * because of this https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429
		 */
		
		Console console=System.console();

		/*
		 * Getting a string containing the line read from the console
		 */
		
		String line = console.readLine();
		
		/*
		 * Getting a character array containing the password read from the console
		 */
		
		char[] password = console.readPassword();
		
		/*
		 * Getting the printwriter associated with this console
		 */
		
		PrintWriter writer = console.writer();
		
		/*
		 * Getting the reader associated with this console
		 */
		
		Reader reader = console.reader();
	}

}
