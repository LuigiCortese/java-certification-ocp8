package net.devsedge.stream.foreachordered;

import java.util.stream.Stream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {

		/*
		 * Here stream is parallelized and peek runs over a parallel stream, so 
		 * the order of the output cannot be predicted
		 */
		
		Stream.of("one ","two ","three ","four ","five ","six ")
		.parallel()
		.peek(item -> System.out.print(item))
		.forEachOrdered(item -> System.out.print(""));
		
		System.out.println();
		
		/*
		 * Here stream is parallelized but forEachOrdered will ensure the order to 
		 * be the original one
		 */
		
		Stream.of("one ","two ","three ","four ","five ","six ")
		.parallel()
		.peek(item -> System.out.print(""))
		.forEachOrdered(item -> System.out.print(item));
		
		System.out.println();
		
		/*
		 * Here stream is an alternative solution to the previous one
		 */
		
		Stream.of("one ","two ","three ","four ","five ","six ")
		.parallel()
		.peek(item -> System.out.print(""))
		.sequential()
		.forEach(item -> System.out.print(item));

	}

}
