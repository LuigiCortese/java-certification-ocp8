package net.devsedge.collections.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Creating an array of books
		 */
		
		Book[] books={
				new Book("The best Java book",33),
				new Book("Another Java book",22),
				new Book("Another Java book",11),
				};
		 
		/*
		 * Ordering the array
		 */
		
		System.out.println("Array not sorted: \n\t"+Arrays.toString(books));
		
		Arrays.sort(books);

		System.out.println("\nArray sorted: \n\t"+Arrays.toString(books));
		
		/*
		 * Creating a List of books
		 */
		
		List<Book> otherBooks=Arrays.asList(
				new Book("The best Java book",33),
				new Book("Another Java book",22),
				new Book("Another Java book",11)
		);
		
		/*
		 * Ordering the array
		 */
		
		System.out.println("\nList not sorted: \n\t"+otherBooks);
		
		Collections.sort(otherBooks);
		
		System.out.println("\nList sorted: \n\t"+otherBooks);
		
	}

}

class Book implements Comparable<Book>{

	private String title;
	private int ID;
	
	public Book(String title,int ID){
		this.title=title;
		this.ID=ID;
	}
	
	@Override
	public int compareTo(Book o) {
		int res=title.compareTo(o.title);
		return res!=0?res:Integer.compare(ID,o.ID);
	}
	
	@Override
	public String toString(){
		return title+" - "+ID;
	}
}