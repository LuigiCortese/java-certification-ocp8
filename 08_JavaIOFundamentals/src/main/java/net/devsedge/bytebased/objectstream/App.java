package net.devsedge.bytebased.objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream.
 * 
 *  - Objects to be written must implement serializable
 *  
 *  - Any object, including Strings and arrays, is written with writeObject.
 *  
 *  - Multiple objects or primitives can be written to the stream. 
 *  
 *  - The objects must be read back from the corresponding ObjectInputstream 
 *    with the same types and in the same order as they were written. 
 *  
 *  - Primitive data types can also be written to the stream using the appropriate 
 *    methods from DataOutput.
 *    
 *  - Strings can also be written using the writeUTF method.
 *  
 *  - The default serialization mechanism for an object writes 
 *       * the class of the object, 
 *       * the class signature, 
 *       * and the values of all non-transient and non-static fields.
 *       
 *  - References to other objects (except in transient or static fields) cause those 
 *    objects to be written also. 
 *    
 *  - Classes that require special handling during the serialization and deserialization 
 *    process must implement special methods with these exact signatures:  
 *    
 *       1) private void readObject(java.io.ObjectInputStream stream) 		throws IOException, ClassNotFoundException;
 *       
 *       2) private void writeObject(java.io.ObjectOutputStream stream) 	throws IOException
 *       
 *       		responsible for writing the state of the object for its particular class 
 *       		so that the corresponding readObject method can restore it.  State is saved 
 *       		by writing the individual fields to the ObjectOutputStream using the writeObject 
 *       		method or by using the methods for primitive data types supported by DataOutput.
 *       		Must call --defaultWriteObject--
 *       
 *       3) private void readObjectNoData()									throws ObjectStreamException;
 *       
 *   - Subclasses of Objects that are not serializable can be serializable. In this case 
 *     the non-serializable class must have a no-arg constructor to allow its fields to be initialized.
 *     
 *   - Constructor of the class for an object being deserialized is never invoked.
 *   
 *   - If the object graph contains non-serializable objects, an exception is thrown and nothing 
 *     is serialized. Object graph means all the objects that are linked/referenced by the first 
 *     object (directly or indirectly) that is being serialized.
 *     
 *   - Any field that is not marked transient but points to an object of a class that does not 
 *     implement Serializable, will cause an exception to be thrown.
 *     
 * @author Luigi Cortese
 *
 */

public class App {

	public static void main(String[] args) {
		/*
		 * Notice how result changes if you 
		 *   a) execute this code how it is, or
		 *   b) ececute this code 
		 *   		- one first time by commenting only line //2
		 *   		- and then, one second time, by commenting only line //1
		 *   
		 *  A good exercise is trying to figure out why without running the program.
		 */
		writing(); // 1
		reading(); // 2
	}

	/**
	 * Writes a Foo object
	 */
	private static void writing(){
		
		System.out.println("Just about to create foo...");
		
		Foo foo = new Foo();

		System.out.println("\n...created:\n\t"+foo);

		foo.addTen();		
		
		System.out.println("\nJust modified foo:\n\t"+foo);
		
		try (FileOutputStream fos = new FileOutputStream("src/main/java/net/devsedge/bytebased/objectstream/foo.ser"); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(foo);
			
			System.out.println("\nJust written foo to file.");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		foo.addTen();		
		
		System.out.println("\nJust modified foo again:\n\t"+foo);
	}		
	
	/**
	 * Reads a Foo object
	 */
	private static void reading(){
		try (FileInputStream fis = new FileInputStream("src/main/java/net/devsedge/bytebased/objectstream/foo.ser"); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			System.out.println("\nJust about to retrieve foo...");

			Foo foo=(Foo) ois.readObject();
			
			System.out.println("\n...retrieved:\n\t"+foo);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

}

class Foo implements Serializable{
	
	private static final long serialVersionUID = 4725343702835190234L;
	
	static int init(String name,int value){
		System.out.println("\t~~~ Initializing "+name+" to "+value+" ~~~");
		return value;
	}
	
	//initialized
	int i=init("i",1);
	static int j=init("j",2);
	transient int k=init("k",3);
	static transient int l=init("l",4);
	
	//not initialized
	int m;
	static int n;
	transient int o;
	static transient int p;
	
	@Override
	public String toString(){
		return "(i)i="+i+" (si)j="+j+" (ti)k="+k+" (sti)l="+l+" m="+m+" (s)n="+n+" (t)o="+o+" (st)p="+p+"\n"
				+ "\t\ti = initialized\n"
				+ "\t\ts = static\n"
				+ "\t\tt = transient";
	}
	
	public void addTen(){
		i+=10;
		j+=10;
		k+=10;
		l+=10;
		m+=10;
		n+=10;
		o+=10;
		p+=10;
	}
}