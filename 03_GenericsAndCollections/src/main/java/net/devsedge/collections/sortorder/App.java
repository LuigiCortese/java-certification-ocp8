package net.devsedge.collections.sortorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class App {

	public static void main(String[] args) {
		
		/*
		 * List
		 */
		
		List<Integer> l; 
		
		System.out.println("ArrayList: \n\t- ordered (insertion order is maintained), \n\t- not sorted (elements are not kept sorted)");
		l=new ArrayList<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			l.add(x);
			System.out.println(l);
		}
		
		System.out.println("\nVector: \n\t- ordered (insertion order is maintained), \n\t- not sorted (elements are not kept sorted)");
		l=new Vector<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			l.add(x);
			System.out.println(l);
		}
		
		System.out.println("\nLinkedList: \n\t- ordered (insertion order is maintained), \n\t- not sorted (elements are not kept sorted)");
		l=new LinkedList<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			l.add(x);
			System.out.println(l);
		}
		
		
		/*
		 * Set
		 */
		
		Set<Integer> s; 
		
		System.out.println("\nHashSet: \n\t- not ordered (insertion order is not maintained), \n\t- not sorted (elements are not kept sorted)");
		s=new HashSet<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			s.add(x);
			System.out.println(s);
		}


		System.out.println("\nLinkedHashSet: \n\t- ordered (insertion order is maintained), \n\t- not sorted (elements are not kept sorted)");
		s=new LinkedHashSet<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			s.add(x);
			System.out.println(s);
		}

		
		System.out.println("\nTreeSet: \n\t- ordered (insertion order is maintained), \n\t- sorted (elements are kept sorted)");
		s=new TreeSet<>();
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+": ");
			s.add(x);
			System.out.println(s);
		}

		
		/*
		 * Map
		 */
		
		Map<Integer,Integer> m;
		
		m = new HashMap<>();
		System.out.println("\nHashMap: \n\t- not ordered (insertion order is not maintained), \n\t- not sorted (elements are not kept sorted)");
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100),y=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+"="+String.format("%2d", y)+": ");
			m.put(x,y);
			System.out.println(m);
		}


		m = new Hashtable<>();
		System.out.println("\nHashtable: \n\t- not ordered (insertion order is not maintained), \n\t- not sorted (elements are not kept sorted)");
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100),y=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+"="+String.format("%2d", y)+": ");
			m.put(x,y);
			System.out.println(m);
		}
		
		m = new LinkedHashMap<>();
		System.out.println("\nLinkedHashMap: \n\t- ordered (insertion order is maintained), \n\t- not sorted (elements are not kept sorted)");
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100),y=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+"="+String.format("%2d", y)+": ");
			m.put(x,y);
			System.out.println(m);
		}

		
		m = new TreeMap<>();
		System.out.println("\nTreeMap: \n\t- ordered (insertion order is maintained), \n\t- sorted (elements are kept sorted)");
		for(int i=0;i++<10;){
			int x=(int)(Math.random()*100),y=(int)(Math.random()*100);
			System.out.print("Adding "+String.format("%2d", x)+"="+String.format("%2d", y)+": ");
			m.put(x,y);
			System.out.println(m);
		}

	}

}
