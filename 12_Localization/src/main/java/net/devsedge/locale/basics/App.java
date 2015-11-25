package net.devsedge.locale.basics;

import java.util.Locale;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	static Locale locale;
	
	public static void main(String[] args) {
		
		// defining language
		locale = new Locale("it");
		
		// defining language & country
		locale = new Locale("it","IT");
		locale = new Locale("it","CH");
		locale = new Locale("en","US");
		
		// getting default
		System.out.println(Locale.getDefault());
		
		// setting default
		Locale.setDefault(locale);
		System.out.println(Locale.getDefault());

		// getting info in its own language
		System.out.println(locale.getDisplayLanguage());
		System.out.println(locale.getDisplayCountry());
		
		// getting info in another language
		System.out.println(locale.getDisplayLanguage(new Locale("it","CH")));
		System.out.println(locale.getDisplayCountry(new Locale("it","CH")));
		
	}

}