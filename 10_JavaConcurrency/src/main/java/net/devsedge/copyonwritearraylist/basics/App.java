package net.devsedge.copyonwritearraylist.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	static List<Integer> list;
	static CopyOnWriteArrayList<Integer> COWAlist;
	static int a;
	
	static{
		resetValues();
	}
	
	static void resetValues(){
		list=new ArrayList<>(Arrays.asList(1,2));
		COWAlist=new CopyOnWriteArrayList<>(Arrays.asList(1,2));
		a=10;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Trying to modify the internal structure of an ArrayList while iterating through 
		 * its content will cause a ConcurrentModificationException
		 */
		System.out.println("BEFORE: "+list);
		try{
			for(int i:list)
				list.add(a++);
		}catch(ConcurrentModificationException e){
			System.out.println("  :Trying to modify the internal structure of an ArrayList "
					+ "caused a ConcurrentModificationException");
		}
		System.out.println("AFTER: "+list+"\n\n");
			
		/*
		 * A CopyOnWriteArrayList allows you to "modify" its content while iterating. To be more precise,
		 * it's a read-only object, each modification will result in creating an updated copy of the original.
		 * Despite of the fact that we're adding elements to the list, the loop will be executed only twice,
		 * because the (implicit) iterator always reference the original copy of the list, which contains two
		 * elements only
		 */
		resetValues();
		System.out.println("BEFORE: "+COWAlist);
		for(int i:COWAlist){
			COWAlist.add(a++);
			System.out.println("  :"+COWAlist);
		}
		System.out.println("AFTER: "+COWAlist+"\n\n");
		
		/*
		 * As the previous example, but using an explicit iterator syntax
		 */
		resetValues();
		System.out.println("BEFORE: "+COWAlist);
		for(Iterator<Integer> iterator = COWAlist.iterator(); iterator.hasNext();iterator.next()) {
			COWAlist.add(a++);
			System.out.println("  :"+COWAlist);
		}
		System.out.println("AFTER: "+COWAlist+"\n\n");
	}

}