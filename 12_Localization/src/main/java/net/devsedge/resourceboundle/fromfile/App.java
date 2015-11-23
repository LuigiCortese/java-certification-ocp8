package net.devsedge.resourceboundle.fromfile;

import java.util.Locale;
import java.util.ResourceBundle;

public class App {

	public static void main(String[] args) {
		
		// Creating ResourceBundle object passing a "base name" and Locale=en
		ResourceBundle resourceBundle = ResourceBundle.getBundle("labels",new Locale("en"));
		
		// Iterating English properties
		System.out.println("English:");
		for(String key:resourceBundle.keySet())
			System.out.println("\t"+resourceBundle.getString(key));  
		
		// Creating ResourceBundle object passing a "base name" and Locale=it
		resourceBundle = ResourceBundle.getBundle("labels",new Locale("it"));
		
		// Iterating Italian properties
		System.out.println("Italian:");
		for(String key:resourceBundle.keySet())
			System.out.println("\t"+resourceBundle.getString(key));  

	}

}
