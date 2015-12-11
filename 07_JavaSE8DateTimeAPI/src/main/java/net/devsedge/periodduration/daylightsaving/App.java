package net.devsedge.periodduration.daylightsaving;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
	

		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

		ZonedDateTime date ;
		
		/*
		 * Duration is used to manipulate dates in terms of 
		 *  - hours, 
		 *  - minutes, 
		 *  - seconds.
		 *  
		 *  Duration may change the time component if the date is close to the DST  boundary.
		 *  A Duration will add an exact number of seconds, thus a duration of one day is always exactly 24 hours.
		 *  
		 */
		
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		System.out.println("     ZonedDateTime:   "+date+"    +");
		System.out.println("Duration.ofDays(1):   "+Duration.ofDays(1));
		System.out.println("                      ---------------------------------");
		System.out.println("                      "+date.plus(Duration.ofDays(1)));
		System.out.println("\n");

		/*
		 * Period is used to manipulate dates in terms of 
		 *  - days, 
		 *  - months, 
		 *  - years
		 *  
		 *  Period doesn't mess with the time component of the date.
		 *  Period will add a conceptual day, trying to maintain the local time
		 *  
		 */
		
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		System.out.println("     ZonedDateTime:   "+date+"    +");
		System.out.println("  Period.ofDays(1):   "+Period.ofDays(1));
		System.out.println("                      ---------------------------------");
		System.out.println("                      "+date.plus(Period.ofDays(1)));
		System.out.println();

	}

}
