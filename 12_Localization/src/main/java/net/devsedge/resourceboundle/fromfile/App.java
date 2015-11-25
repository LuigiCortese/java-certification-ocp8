package net.devsedge.resourceboundle.fromfile;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/* 
		 * Creating ResourceBundle object passing a "base name" and Locale=en.
		 * "labels_en.properties" will be chosen.
		 * 
		 * Here 
		 *    http://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-java.util.Locale-java.lang.ClassLoader-
		 * you can find a description of the file seach strategy, based on the 
		 * base name and locale
		 */
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("labels",new Locale("en"));
		
		// Iterating English properties
		System.out.println("English:");
		for(String key:resourceBundle.keySet())
			System.out.println("\t"+key+" => "+resourceBundle.getString(key));  
		
		// Creating ResourceBundle object passing a "base name" and Locale=it
		resourceBundle = ResourceBundle.getBundle("labels",new Locale("it"));
		
		// Iterating Italian properties
		System.out.println("Italian:");
		for(String key:resourceBundle.keySet())
			System.out.println("\t"+key+" => "+resourceBundle.getString(key));  

	}

}
