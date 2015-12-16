package net.devsedge.autocloseable.basics;

import java.util.stream.Stream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		try(Stream<Integer> s = Stream.of(1,2,3,4)){
			s.filter(x->(x%2)==0).forEach(System.out::println);
		}

	}

}
