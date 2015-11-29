package net.devsedge.stream.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		/*
		 * Stream creation...
		 */

		// ...empty
		
		Stream<Object> s = Stream.empty();							
		IntStream s1 = IntStream.empty();							
		LongStream s2 = LongStream.empty();							
		DoubleStream s3 = DoubleStream.empty();			
		
		// ...from values
		
		Stream<String> s4 = Stream.of("a","b","c");							
		Stream<Integer> s5 = Stream.of(1,2,3);							
		Stream<Object> s6 = Stream.of(new Object(),new Object());		
		
		// ...with a stream builder	
		
		Stream<String> s7 = Stream.<String>builder().add("a").add("b").add("c").build();							
		Stream<Integer> s8 = Stream.<Integer>builder().add(1).add(2).add(3).build();							
		Stream<Object> s9 = Stream.<Object>builder().add(new Object()).add(new Object()).build();
		
		// ...from function (ordered)
		
		Stream<String> s10 = Stream.iterate("|0|", x -> x+"_|");							
		Stream<Integer> s11 = Stream.iterate(1, n -> n + 2);							
		Stream<Integer> s12 = Stream.iterate(1, n -> n + 2).limit(10);							

		// ...from function (unordered)
		
		Stream<Double> s13 = Stream.generate(Math::random).limit(5);	
		
		// ......from arrays	
		
		Stream<String> s14 = Arrays.stream(new String[] {"A", "B"});							
		Stream<Integer> s15 = Arrays.stream(new Integer[]{1, 2, 3});							
		IntStream s16 = Arrays.stream(new int[]{1, 2, 3});
		
		// ...from collections	
		
		Stream<String> s17 = new ArrayList<String>().stream();							
		Stream<String> s18 = new ArrayList<String>().parallelStream();		
		
		// ...from File	
		try {
			Stream<String> lines = Files.lines(Paths.get("path/file.txt"));
		} catch (IOException e) {
		}
	}

}
