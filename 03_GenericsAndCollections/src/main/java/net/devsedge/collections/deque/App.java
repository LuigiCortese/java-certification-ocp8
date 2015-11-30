package net.devsedge.collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Creating an empty deque
		 */
		
		System.out.println("Empty Deque:");
		Deque<String> deque=new ArrayDeque<>();
		System.out.println("\t"+deque);
		
		/*
		 * Populating the deque from head with some values
		 */
		
		System.out.println("\nAdding elements (from head):");
		deque.addFirst("E");							//throws an exception if no space available
		System.out.println("\taddFirst E    "+deque); 	
		deque.addFirst("B");
		System.out.println("\taddFirst B    "+deque);
		deque.push("F");								//throws an exception if no space available
		System.out.println("\tpush F        "+deque);
		deque.push("C");
		System.out.println("\tpush C        "+deque);
		deque.offerFirst("A");
		System.out.println("\tofferFirst A  "+deque);
		deque.offerFirst("D");		
		System.out.println("\tofferFirst D  "+deque);
		
		/*
		 * Populating the deque from tail with some values
		 */
		
		System.out.println("\nAdding elements (from tail):");
		deque.addLast("e");							//throws an exception if no space available
		System.out.println("\taddLast e    "+deque); 	
		deque.addLast("b");
		System.out.println("\taddLast b    "+deque);
		deque.add("f");								//throws an exception if no space available
		System.out.println("\tadd f        "+deque);
		deque.add("c");
		System.out.println("\tpush c       "+deque);
		deque.offerLast("a");
		System.out.println("\tofferLast a  "+deque);
		deque.offerLast("d");		
		System.out.println("\tofferLast d  "+deque);
		deque.offer("h");
		System.out.println("\toffer h      "+deque);
		deque.offer("g");		
		System.out.println("\toffer g      "+deque);
		
		/*
		 * Inspecting elements from head (they won't be removed)
		 */
		
		System.out.println("\nInspecting elements (from head):");
		System.out.println("\tgetFirst = "+deque.getFirst()); 	//throws an exception if queue is empty.
		System.out.println("\tgetFirst = "+deque.getFirst());
		System.out.println("\telement = "+deque.element());			//returns null if queue is empty
		System.out.println("\telement = "+deque.element());
		System.out.println("\tpeekFirst = "+deque.peekFirst());
		System.out.println("\tpeekFirst = "+deque.peekFirst());
		System.out.println("\tpeek = "+deque.peek());
		System.out.println("\tpeek = "+deque.peek());
		
		/*
		 * Inspecting elements from tail (they won't be removed)
		 */
		
		System.out.println("\nInspecting elements (from tail):");
		System.out.println("\tgetLast = "+deque.getLast()); 	//throws an exception if queue is empty.
		System.out.println("\tgetLast = "+deque.getLast()); 	
		System.out.println("\tpeekLast = "+deque.peekLast());
		System.out.println("\tpeekLast = "+deque.peekLast());
		
		/*
		 * Removing elements from head
		 */
		
		System.out.println("\nRemoving elements (from head):");
		System.out.println("\tremoveFirst -> "+deque.removeFirst()+": "+deque); 		//throws an exception if queue is empty.
		System.out.println("\tremove      -> "+deque.remove()+": "+deque); 				//throws an exception if queue is empty.
		System.out.println("\tpop         -> "+deque.pop()+": "+deque); 				//throws an exception if queue is empty.
		System.out.println("\tpollFirst   -> "+deque.pollFirst()+": "+deque); 				
		System.out.println("\tpoll        -> "+deque.poll()+": "+deque); 				
		
		/*
		 * Removing elements from tail
		 */
		
		System.out.println("\nRemoving elements (from tail):");
		System.out.println("\tremoveLast -> "+deque.removeLast()+": "+deque); 		//throws an exception if queue is empty.
		System.out.println("\tpollLast   -> "+deque.pollLast()+": "+deque); 				
		
	}

}
