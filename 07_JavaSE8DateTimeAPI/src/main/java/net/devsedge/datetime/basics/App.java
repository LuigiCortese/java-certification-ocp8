package net.devsedge.datetime.basics;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Times
		 */
		
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		/*
		 * ZoneOffset: a time-zone offset from Greenwich/UTC, such as +02:00. 
		 */
		
		ZoneOffset zoneOffset = ZoneOffset.of("+2");
		
		/*
		 * Offset[Date]Time = Local[Date]Time + ZoneOffset
		 */
		
		OffsetTime offsetTime = OffsetTime.of(localTime,zoneOffset);
		OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime,zoneOffset);
		
		/*
		 * ZoneId: a time-zone ID, such as Europe/Paris. 
		 */
		
		ZoneId zoneId = ZoneId.of(zoneOffset.getId());
		
		/*
		 * ZonedDateTime = LocalDateTime
		 */
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		
		/*
		 * Period: in terms of years, months and days
		 */
		
		Period period = Period.of(1,1,1);
		
		/*
		 * Duration: in terms of hours, minutes and seconds
		 */
		
		Duration duration = Duration.of(1,ChronoUnit.MINUTES);
		
		/*
		 * Instant: in terms of seconds elapsed from epoch time
		 */
		
		Instant instant = Instant.ofEpochSecond(119);
	
	}

}
