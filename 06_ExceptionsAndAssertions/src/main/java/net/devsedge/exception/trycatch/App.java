package net.devsedge.exception.trycatch;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) throws E1, E2 {
		foo();
	}
	
	static void foo() throws E1,E2{
		try{
			bar();
		}catch(Exception e){
			/*
			 * This catch is not catching all exceptions, but here "Exception" is
			 * <<any exceptions that bar() happens to throw>>.
			 * this is equivalent to
			 *     catch(E1|E2 e)
			 */
			
			//CASE 1
//			throw new Exception(); //won't compile    
			
			//CASE 2
//			e=null; //causes next row not to compile. Being this case equivalent to a
					//multicatch, in multicatch variable is final. If you now reassing
					//the variable, you're going back to classical non-multicatch.
			
			throw e; //won't compile in Java 6
		}
	}
	
	static void bar() throws E1,E2{}

}

class E1 extends Exception{}
class E2 extends Exception{}