package net.devsedge.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		/*
		 * Calculating the sum of the lengths of every string in the stream
		 */
		
		Stream<String> stream = Stream.of("One","Two","Three","Four");
		int sum = stream
			.peek(System.out::println)
			.map(String::length)
			.reduce(0,Integer::sum);

		System.out.println("--"+sum+"--\n");
		
		/*
		 * Calculating same value by using primitive version of "map"
		 */
		
		stream = Stream.of("One","Two","Three","Four");
		sum = stream
				.peek(System.out::println)
				.mapToInt(String::length)
				.sum();
		
		System.out.println("--"+sum+"--\n");
		
		/*
		 * Calculating same value by using "flatMap"
		 */
		
		Stream<List<String>> stream2 = Stream.of(
				Arrays.asList("One","Two"),
				Arrays.asList("Three","Four")
				);
		sum = stream2
				.flatMap(x->x.stream())
				.peek(System.out::println)
				.map(String::length)
				.reduce(0,Integer::sum);
		
		System.out.println("--"+sum+"--\n");

		/*
		 * Calculating same value by using "flatMapToInt"
		 */
		
		stream2 = Stream.of(
				Arrays.asList("One","Two"),
				Arrays.asList("Three","Four")
				);
		sum = stream2
				.flatMapToInt(x->x.stream().mapToInt(String::length))
				.peek(System.out::println)
				.reduce(0,Integer::sum);
		
		System.out.println("--"+sum+"--");
	}

}
