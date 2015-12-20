package net.devsedge.abstractclass.basics;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		C c = new C();
	}
	
}

interface MyInt{
	/*
	 * All variables are by default static and final
	 */
    int i = 9;
	void foo();
}

abstract class MyAbs implements MyInt{
	/*
	 * an abstract method must be explicitly defined as "abstract"
	 */
	abstract void bar();
	/*
	 * a concrete method
	 */
	void concrete(){}
}

/*
 * The first concrete class in the hierarchy is required to implement
 * all the abstract methods
 */
class C extends MyAbs{

	@Override
	public void foo() {}

	@Override
	void bar() {}
}