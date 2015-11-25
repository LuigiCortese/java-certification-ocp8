package net.devsedge.resourcefile.basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		// Creating a property object
		Properties properties = new Properties();
		
		// Loading property file
		try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Iterating properties
		for(String key : properties.stringPropertyNames())
			System.out.println(key + " => " + properties.getProperty(key));
	}

}
