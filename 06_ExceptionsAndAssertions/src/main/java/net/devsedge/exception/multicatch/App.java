package net.devsedge.exception.multicatch;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			foo();
		} catch (E1 | E2 | E3 e) {
			e.printStackTrace();
		} finally {
			System.out.println("In finally");
		}

	}
	
	static void foo()throws E1,E2,E3{}

}

class E1 extends Exception{}
class E2 extends Exception{}
class E3 extends Exception{}