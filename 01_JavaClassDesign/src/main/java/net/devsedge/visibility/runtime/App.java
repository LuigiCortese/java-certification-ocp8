package net.devsedge.visibility.runtime;

public class App extends Super{

	public static void main(String[] args) {
		Super app = new App();
		/*
		 * Uncommenting next line causes a compilation error. The method is not overridden
		 * and it's declared "private" in Super class.
		 */
//		app.foo();
	}

	/*
	 * Here you're not overriding Super.foo because it's declared private.
	 * If you try to uncomment @Override annotation you get a compilation
	 * error on the next line
	 */
//	@Override
	public void foo(){}
}

class Super{
	private void foo(){}
}