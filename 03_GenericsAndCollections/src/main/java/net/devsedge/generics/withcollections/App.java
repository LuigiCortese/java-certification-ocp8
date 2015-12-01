package net.devsedge.generics.withcollections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {
	
	public static void main(String... args) {
		
		/*
		 * Raw HashSet (not sorted not ordered)
		 */
		
		Set s1=new HashSet();

		s1.add(1);				// you can add primitives
		s1.add(new Object());	// you can add Object
		s1.add(new Comp());		// you can add Comparable
		s1.add(new NotComp());	// you can add a custom object
		
		/*
		 * HashSet with Object type
		 */

		Set<Object> s2=new HashSet<>();
		
		s2.add(1);				// you can add primitives
		s2.add(new Object());	// you can add Object
		s2.add(new Comp());		// you can add Comparable
		s2.add(new NotComp());	// you can add a custom object
		
		/*
		 * HashSet with Unknown type 
		 * (see http://stackoverflow.com/questions/2770321/what-is-a-raw-type-and-why-shouldnt-we-use-it/2770692#2770692 )
		 */
		
		Set<?> s3=new HashSet<>();
		
		//s3.add(1);				// compilation error
		//s3.add(new Object());		// compilation error
		//s3.add(new Comp());		// compilation error
		//s3.add(new NotComp());	// compilation error
		
		/*
		 * HashSet with Unknown-extends-Object type 
		 * (see http://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java/33246935#33246935 )
		 */
		
		Set<? extends Object> s4=new HashSet<>();
		
		//s4.add(1);				// compilation error
		//s4.add(new Object());		// compilation error
		//s4.add(new Comp());		// compilation error
		//s4.add(new NotComp());	// compilation error

		/*
		 * HashSet with Unknown-super-Object type 
		 * (see http://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java/33246935#33246935 )
		 */
		
		Set<? super Object> s5=new HashSet<>();
		
		s5.add(1);				// you can add primitives
		s5.add(new Object());	// you can add Object
		s5.add(new Comp());		// you can add Comparable
		s5.add(new NotComp());	// you can add a custom object
		
		/*
		 * Raw TreeSet (sorted and ordered).
		 * When using a sorted collection you have to pay attention to this two rules:
		 *  
		 *  (1) an attempt to insert an object that does not implement Comparable will compile, but
		 *      will throw an exception at runtime
		 *    
		 *  continues below...
		 */
		
		TreeSet s6 = new TreeSet();
		
		try {
			s6.add(new NotComp()); // will throw an exception
		} catch (java.lang.ClassCastException e) {
			e.printStackTrace();
		} 
		
		
		/*
		 * ...continued
		 * 
		 *  (2) an attempt to insert two "not mutually comparable" Comparable objects will throw an
		 *      exception on the second insert attempt
		 */
		
		TreeSet s7 = new TreeSet();
		
		s7.add(new String()); // won't throw any exception
		try {
			s7.add(new NotComp()); // will throw an exception
		} catch (java.lang.ClassCastException e) {
			e.printStackTrace();
		} 
		
	}
	
}

class NotComp{}

class Comp implements Comparable<Comp>{
	@Override
	public int compareTo(Comp o) {
		return 0;
	}	
}