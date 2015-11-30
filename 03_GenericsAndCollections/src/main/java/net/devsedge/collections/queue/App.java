package net.devsedge.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Creating an empty queue
		 */
		
		System.out.println("Empty Queue:");
		Queue<String>queue=new PriorityQueue<>();
		System.out.println(queue);
		
		/*
		 * Populating the queue with some values. Queue maintains natural order of elements
		 */
		
		System.out.println("\nAdding elements (natural order maintained)");
		queue.add("B");		//throws an exception if no space available
		queue.add("D");
		queue.offer("A");	//returns false if no space available
		queue.offer("C");
		System.out.println(queue);
		
		/*
		 * Inspecting elements (they won't be removed)
		 */
		
		System.out.println("\nInspecting elements");
		System.out.println("element = "+queue.element()); 	//throws an exception if queue is empty.
		System.out.println("element = "+queue.element());
		System.out.println("peek = "+queue.peek());			//returns null if queue is empty
		System.out.println("peek = "+queue.peek());
		
		/*
		 * Removing elements
		 */
		
		System.out.println("\nRemoving elements");
		System.out.println(queue.remove()+" removed: "+queue); 				//throws an exception if queue is empty.
		System.out.println(queue.remove()+" removed: "+queue);
		System.out.println(queue.poll()+" removed (with poll): "+queue);	//returns null if queue is empty
		System.out.println(queue.poll()+" removed (with poll): "+queue);
	}

}
