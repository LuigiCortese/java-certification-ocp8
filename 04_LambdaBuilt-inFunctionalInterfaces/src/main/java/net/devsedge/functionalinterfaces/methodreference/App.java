package net.devsedge.functionalinterfaces.methodreference;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {
	public static void main(String[] args) {

		FunctionalInterface<One, Two, Three, Four> functionalInterface;

		System.out.println("Method reference to...");

		/*
		 * Method reference to a static method. 
		 * foo() implementation would look like this:
		 * 
		 *     void foo(One o,Two t,Three th,Four f){
		 *         Main.bar(o,t,th,f);
		 *     }
		 */
		functionalInterface = App::bar;
		functionalInterface.foo(new One(), new Two(), new Three(), new Four());

		/*
		 * Method reference to an instance method of an object of a particular type.
		 * foo() implementation would look like this:
		 * 
		 *     void foo(One o,Two t,Three th,Four f){
		 *         o.bar(t,th,f);
		 *     }
		 */
		functionalInterface = One::bar;
		functionalInterface.foo(new One(), new Two(), new Three(), new Four());
		
		/*
		 * Method reference to an instance method of an existing object.
		 * foo() implementation would look like this:
		 * 
		 *     One one;
		 *     void foo(One o,Two t,Three th,Four f){
		 *         one.rab(o,t,th,f);
		 *     }
		 */
		One one = new One();
		functionalInterface = one::rab;
		functionalInterface.foo(new One(), new Two(), new Three(), new Four());
		
		/*
		 * Method reference to a constructor.
		 * foo() implementation would look like this:
		 * 
		 *     void foo(One o,Two t,Three th,Four f){
		 *         new One(o,t,th,f);
		 *     }
		 */
		functionalInterface = One::new;
		functionalInterface.foo(new One(), new Two(), new Three(), new Four());

	}

	static void bar(One o, Two t, Three th, Four f) {
		System.out.println("\t - ...a static method");
	}
}

class One {
	One() {
	}

	One(One o, Two t, Three th, Four f) {
		System.out.println("\t - ...a constructor");
	}

	void bar(Two t, Three th, Four f) {
		System.out.println("\t - ...an instance method of an object of a particular type");
	}

	void rab(One o, Two t, Three th, Four f) {
		System.out.println("\t - ...an instance method of an existing object");
	}
}

class Two {}
class Three {}
class Four {}


/**
 * Functional Interface
 * 
 * @author Luigi Cortese
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
interface FunctionalInterface<A, B, C, D> {
	void foo(A a, B b, C c, D d);
}