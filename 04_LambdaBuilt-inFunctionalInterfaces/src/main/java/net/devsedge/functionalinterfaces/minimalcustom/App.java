package net.devsedge.functionalinterfaces.minimalcustom;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		System.out.println(foo(12,12,(a,b)->a*b));
		
	}
	
	static int foo(int a,int b,MathOperation m){
		return m.calculate(a,b);
	}

}

/**
 * This is a custom functional interface, it represents
 * a mathematical operation accepting two integers and returning one
 * 
 * @author Luigi Cortese
 *
 */
interface MathOperation{
	int calculate(int a,int b);
}