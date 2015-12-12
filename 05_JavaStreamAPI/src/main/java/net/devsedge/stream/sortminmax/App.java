package net.devsedge.stream.sortminmax;

import java.util.stream.Stream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Sorting a strings according to their lengths
		 */
		
		Stream.of("aaaa", "bbb", "cc", "d")
			.sorted((a, b) -> a.length() - b.length())  
			.forEach(System.out::println);
		
		/*
		 * Finding longest string -- returns an optional
		 */
		
		System.out.println(
				Stream.of("aaaa", "bbb", "cc", "d")
				.max((a, b) -> a.length() - b.length()));

		/*
		 * Finding shortest string -- returns an optional
		 */
		
		System.out.println(
				Stream.of("aaaa", "bbb", "cc", "d")
				.min((a, b) -> a.length() - b.length()));
	}

}
