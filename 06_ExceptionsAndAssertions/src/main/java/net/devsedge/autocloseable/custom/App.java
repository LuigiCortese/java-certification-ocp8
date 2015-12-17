package net.devsedge.autocloseable.custom;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		try(
				MyCloseable mc = new MyCloseable();
				MyAutoCloseable mac = new MyAutoCloseable(mc);){
			
			mc.doStuff();
			mac.doStuff();
			throw new Ex();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class Ex extends Exception{}
}
/**
 * 
 * @author Luigi Cortese
 *
 */
class MyAutoCloseable implements AutoCloseable{

	private MyCloseable c;
	
	MyAutoCloseable(MyCloseable c){
		this.c=c;
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Closing MyAutoCloseable");
	}
	
	void doStuff(){
		System.out.print("MyAutoCloseable: ");
		c.doStuff();
	}
}
/**
 * 
 * @author Luigi Cortese
 *
 */
class MyCloseable implements Closeable{

	@Override
	public void close() throws IOException {
		System.out.println("Closing MyCloseable");
	}
	
	void doStuff(){
		System.out.println("Doing some stuff...");
	}
	
}