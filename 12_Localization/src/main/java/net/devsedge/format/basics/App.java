package net.devsedge.format.basics;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {

		/*
		 * Formatting numbers
		 */

		NumberFormat n;

		n = NumberFormat.getInstance(new Locale("it"));
		System.out.println(n.format(12.34F));

		n = NumberFormat.getInstance(new Locale("en"));
		System.out.println(n.format(12.34F));

		n = NumberFormat.getCurrencyInstance(new Locale("it", "IT"));
		System.out.println(n.format(12.34F));

		n = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		System.out.println(n.format(12.34F));

		n = NumberFormat.getCurrencyInstance(new Locale("en", "GB"));
		System.out.println(n.format(12.34F));

		/*
		 * Formatting dates (DateFormat abstract class)
		 */

		DateFormat d;

		d = DateFormat.getInstance();
		System.out.println(d.format(new Date()));

		// Date instance

		d = DateFormat.getDateInstance();
		System.out.println(d.format(new Date()));

		d = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(d.format(new Date()));

		d = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("en", "US"));
		System.out.println(d.format(new Date()));

		// Time instance

		d = DateFormat.getTimeInstance();
		System.out.println(d.format(new Date()));

		d = DateFormat.getTimeInstance(DateFormat.SHORT);
		System.out.println(d.format(new Date()));

		d = DateFormat.getTimeInstance(DateFormat.SHORT, new Locale("en", "US"));
		System.out.println(d.format(new Date()));

		// DateTime instance

		d = DateFormat.getDateTimeInstance();
		System.out.println(d.format(new Date()));

		d = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		System.out.println(d.format(new Date()));

		d = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, new Locale("en", "US"));
		System.out.println(d.format(new Date()));

		/*
		 * Formatting dates (SimpleDateFormat class extends DateFormat)
		 */

		SimpleDateFormat s;

		s = new SimpleDateFormat();
		System.out.println(s.format(new Date()));

		s = new SimpleDateFormat("MMMM");
		System.out.println(s.format(new Date()));

		s = new SimpleDateFormat("MMMM", new Locale("en", "US"));
		System.out.println(s.format(new Date()));

		s = new SimpleDateFormat("MMMM", DateFormatSymbols.getInstance());
		System.out.println(s.format(new Date()));

	}

}
