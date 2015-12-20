package net.devsedge.finalkeyword.basics;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	final int i;
	App(){
		/*
		 * final variables can only be initialized
		 *  - when declared
		 *  - in <init> or <clinit>
		 *  - in constructor
		 */
		i=0;
	}
	public static void main(String[] args) {
		
		int x=1;
		int y=1;
		y=2;
		
		class C{
			void foo(){
				int a=x;
				
				/*
				 * Here you can only access *final* or *effectively final* variables.
				 * Uncommenting next line would cause compilation error
				 */
				
				//int b=y;
			}
		}
	}

}

/*
 * Final classes cannot be extendend
 */
final class A{}

// This is a compile time error
//class B extends A{}