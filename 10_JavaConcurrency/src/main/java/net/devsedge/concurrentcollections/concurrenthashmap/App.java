package net.devsedge.concurrentcollections.concurrenthashmap;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.devsedge.Util;

public class App {

	static HashMap<String, Integer> hMap;
	static ConcurrentHashMap<String, Integer> cMap;

	static {
		hMap = new HashMap<>();
		hMap.put("one", 1);
		hMap.put("two", 2);
		hMap.put("three", 3);

		cMap = new ConcurrentHashMap<>();
		cMap.put("one", 1);
		cMap.put("two", 2);
		cMap.put("three", 3);
	}

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Trying to iterate&modify the same HashMap Object in two different
		 * Threads will cause a ConcurrentModificationException on one
		 * of the two threads
		 */
		System.out.println("Concurrently modifying HashMap...");
		Thread t1=new Thread(new MyRunnable(hMap));
		t1.start();
		Thread t2=new Thread(new MyRunnable(hMap));
		t2.start();
		
		//to avoid mixing the outputs between the examples
		t1.join();
		t2.join();
		
		/*
		 * Concurrent modification allowed with ConcurrentHashMap
		 */
		System.out.println("\nConcurrently modifying ConcurrentHashMap...");
		new Thread(new MyRunnable(cMap)).start();
		new Thread(new MyRunnable(cMap)).start();

	}

}

class MyRunnable implements Runnable {

	Map<String, Integer> map;

	MyRunnable(Map map) {
		this.map = map;
	}

	@Override
	public void run() {
		try {
			for (String e : map.keySet()) {
				map.put("four", 4);
				Util.sleep_(1000);
			}
			System.out.println("...successfully updated!");
		} catch (ConcurrentModificationException e) {
			System.out.println("...ConcurrentModificationException thrown!");
		}
	}
}