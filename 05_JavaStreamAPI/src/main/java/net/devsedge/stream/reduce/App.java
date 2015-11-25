package net.devsedge.stream.reduce;

import java.util.stream.Stream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/* 
		 * Reduces elements by 
		 * 
		 *  - an accumulation rule to combine T type element into a T type result
		 *  
		 *  Equivalent to
		 *  
		 *     T result = null;
		 *     for (T element : this stream)
		 *         result = accumulator.apply(result, element);
		 *     return result;
		 *     
		 */
		System.out.print("Reduction by accumulation rule: \n\t");
		System.out.println(Stream.of(1,2,3,4,5).reduce(
				(x,y)->x*10+y
				));
		
		/* 
		 * Reduces elements by 
		 * 
		 *  - a head element
		 *  - an accumulation rule to combine T type element into a T type result
		 *  
		 *  Equivalent to
		 *  
		 *     T result = identity;
		 *     for (T element : this stream)
		 *         result = accumulator.apply(result, element)
		 *     return result;
		 *     
		 */
		System.out.print("\nReduction by \"head\" element and accumulation rule: \n\t");
		System.out.println(Stream.of(1,2,3,4,5).reduce(
				9,
				(x,y)->x*10+y
				));
		
		/* 
		 * Reduces elements by 
		 * 
		 *  - a head element
		 *  - an accumulation rule to combine T type element into a U type result
		 *  - a combiner rule to to combine U type partial results (needed if stream is parallel)
		 *  
		 *  Read this (awesome) answer for details:
		 *  http://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8/24316429#24316429
		 *  
		 *  Equivalent to
		 * 
		 *     U result = identity;
		 *     for (T element : this stream)
		 *         result = accumulator.apply(result, element)
		 *     return result;
		 *     
		 */
		System.out.print("\nReduction by \"head\" element, accumulation rule and combiner rule: \n\t");
		System.out.println(Stream.of("one","two","three","four").reduce(
				0,
				(x,y)->x+y.length(),
				(x,y)->x+y
				));
		
	}

}
