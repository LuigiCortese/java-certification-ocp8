package net.devsedge.stream.collect;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		/*
		 * 
		 * CUSTOM CONTAINER
		 * 
		 */
		
		// Generates custom container
		System.out.print("Custom container: ");
		System.out.println(Stream.of(1,2,3).collect(
				ArrayList<Integer>::new,
				ArrayList::add,
				ArrayList::addAll
				));
		
		/*
		 * 
		 * CUSTOM COLLECTION
		 * 
		 * 
		 */
		
		// Generates custom Collection
		System.out.print("\nCustom Collection: ");
		System.out.println(Stream.of(1,2,3).collect(
				Collectors.toCollection(
						ArrayList::new
						)));
		
		/*
		 * 
		 * LIST - SET - MAP 
		 * 
		 */
		
		// Generates List
		System.out.print("\nList: ");
		System.out.println(Stream.of(1,2,3).collect(
				Collectors.toList())
				);
		
		// Generates Set
		System.out.print("Set: ");
		System.out.println(Stream.of(1,2,3).collect(
				Collectors.toSet())
				);
	
		// Generates Map
		System.out.print("Map: ");
		System.out.println(Stream.of(1,2,3).collect(
				Collectors.toMap(
						x->x,
						x->2*x
						)));
	
		// Generates Map with duplicate keys policy
		System.out.print("Map (with duplicate policy): ");
		System.out.println(Stream.of(1,2,2,2,2,2,3,3,3).collect(
				Collectors.toMap(
						x->x,
						x->2*x,
						(x,y)->x*10+y
						)));
		
		// Generates Map with duplicate keys policy and map supplier
		System.out.print("Map (with duplicate policy and map supplier): ");
		System.out.println(Stream.of(1,2,2,2,2,2,3,3,3).collect(
				Collectors.toMap(
						x->x,
						x->2*x,
						(x,y)->x*10+y,
						TreeMap::new
						)));

		/*
		 * 
		 * JOINING
		 * 
		 */
		
		// Generates String by concatenating elements
		System.out.print("\nJoining (plain): ");
		System.out.println(Stream.of("1", "2", "3").collect(
				Collectors.joining()
				));
		
		// Generates String by concatenating elements with a separator
		System.out.print("Joining (with separator): ");
		System.out.println(Stream.of("1", "2", "3").collect(
				Collectors.joining(
						" - "
						)));
		
		// Generates String by concatenating elements with a separator, a prefix and a suffix
		System.out.print("Joining (with separator, prefix and suffix): ");
		System.out.println(Stream.of("1", "2", "3").collect(
				Collectors.joining(
						" - ",
						"[",
						"]"
						)));
		
		/*
		 * 
		 * GROUPING BY
		 * 
		 */
		
		// Generates Map<Integer,List<String>>
		System.out.print("\nGrouping By (with classifier): ");
		System.out.println(Stream.of("1","2","11","22","111","222").collect(
				Collectors.groupingBy(
						x->x.length()
						)));

		// Generates Map<Integer,String>
		System.out.print("Grouping By (with classifier and reduction policy): ");
		System.out.println(Stream.of("1","2","11","22","111","222").collect(
				Collectors.groupingBy(
						x->String.valueOf(x).length(),
						Collectors.joining("&")
						)));
		
		// Generates Map<Integer,String>
		System.out.print("Grouping By (with classifier, map supplier and reduction policy): ");
		System.out.println(Stream.of("1","2","11","22","111","222").collect(
				Collectors.groupingBy(
						x->x.length(),
						TreeMap::new,
						Collectors.joining("&")
						)));
		
		/*
		 * 
		 * PARTITIONING BY
		 * 
		 */
		
		// Generates Map<Boolean, List<String>>
		System.out.print("\nPartitioning By (with predicate): ");
		System.out.println(Stream.of("1","2","3","11","22","33").collect(
				Collectors.partitioningBy(
						x->x.length()%2==0
					)));
		
		// Generates Map<Boolean, String>
		System.out.print("Partitioning By (with predicate and reduction policy): ");
		System.out.println(Stream.of("1","2","3","11","22","33").collect(
				Collectors.partitioningBy(
						x->x.length()%2==0,
						Collectors.joining("&")
						)));
		
	}

}
