package net.devsedge.collections.comparator;

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

	public static void main(String[] args) {/*
		 * Creating an array of books
		 */
		
		Book[] books={
				new Book("The best Java book",33),
				new Book("Advanced Java book",22),
				new Book("Another Java book",11),
				};
		 
		/*
		 * Ordering the array by title
		 */
		
		System.out.println("Array not sorted: \n\t"+Arrays.toString(books));
		
		Arrays.sort(books,new TitleComparator());

		System.out.println("\nArray sorted by title: \n\t"+Arrays.toString(books));
		
		/*
		 * Ordering the array by ID
		 */
		
		Arrays.sort(books,new IDComparator());
		
		System.out.println("\nArray sorted by ID: \n\t"+Arrays.toString(books));
		
		/*
		 * Creating a list of books
		 */
		
		List<Book> otherBooks=Arrays.asList(
				new Book("The best Java book",33),
				new Book("Advanced Java book",22),
				new Book("Another Java book",11)
		);
		
		/*
		 * Ordering the list by title
		 */
		
		System.out.println("\nList not sorted: \n\t"+otherBooks);
		
		Collections.sort(otherBooks,new TitleComparator());
		
		System.out.println("\nList sorted by title: \n\t"+otherBooks);
		
		/*
		 * Ordering the list by ID
		 */
		
		Collections.sort(otherBooks,new IDComparator());
		
		System.out.println("\nList sorted by ID: \n\t"+otherBooks);
		
	}

}

class TitleComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
	
}

class IDComparator implements Comparator<Book>{
	
	@Override
	public int compare(Book o1, Book o2) {
		return Integer.compare(o1.getID(),o2.getID());
	}
	
}

class Book{

	private String title;
	private int ID;
	
	public Book(String title,int ID){
		this.title=title;
		this.ID=ID;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString(){
		return title+" - "+ID;
	}
}

