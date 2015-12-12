package net.devsedge.stream.sortminmax;

import java.util.Arrays;
import java.util.Comparator;

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
		
		Arrays.asList("aaaa", "bbb", "cc", "d")
			.stream()
			.sorted((a, b) -> a.length() - b.length())  
			.forEach(System.out::println);

		Arrays.asList("aaaa", "bbb", "cc", "d")
		.stream()
		.sorted(Comparator.comparing(String::length))  
		.forEach(System.out::println);
		
		/*
		 * Finding longest string -- returns an optional
		 */
		
		System.out.println(
				Arrays.asList("aaaa", "bbb", "cc", "d")
				.stream()
				.max((a, b) -> a.length() - b.length()));
		
		System.out.println(
				Arrays.asList("aaaa", "bbb", "cc", "d")
				.stream()
				.max(Comparator.comparing(String::length)));

		/*
		 * Finding shortest string -- returns an optional
		 */
		
		System.out.println(
				Arrays.asList("aaaa", "bbb", "cc", "d")
				.stream()
				.min((a, b) -> a.length() - b.length()));
		
		System.out.println(
				Arrays.asList("aaaa", "bbb", "cc", "d")
				.stream()
				.min(Comparator.comparing(String::length)));
	}

}
