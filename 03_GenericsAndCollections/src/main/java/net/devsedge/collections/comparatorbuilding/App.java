package net.devsedge.collections.comparatorbuilding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		List<String> l = Arrays.asList("aaa","bb","c");
		
		/*
		 * You can provide a Comparator by...
		 */
		
		// ...using a subclass
		Collections.sort(l,new MyComp());
		
		// ...implementing it (via lambda expression)
		Collections.sort(l,(a,b)->a.length()-b.length());
		
		// ...implementing it (via method reference)
		Collections.sort(l,MyClass::compareMethod);
		
		// ...building it
		Collections.sort(l,Comparator.comparing(String::length));
		
		System.out.println(l);
	}

}

/**
 * This class IS a Comparator, it implements the Comparator interface
 * 
 * @author Luigi Cortese
 * 
 */
class MyComp implements Comparator<String>{
	@Override
	public int compare(String a,String b){
		return a.length()-b.length();
	}
}

/**
 * This class IS NOT a Comparator, but defines a method that can be used
 * by a Comparator<String>
 * 
 * @author Luigi Cortese
 *
 */
class MyClass{
	static int compareMethod(String a,String b){
		return a.length()-b.length();
	}
}