package net.devsedge.bytebased.objectstreamwithstate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class App {

	public static void main(String[] args){
		
		/*
		 * Writing Foo object to file
		 */
		
		try(
				FileOutputStream fos=new FileOutputStream("src/main/java/net/devsedge/bytebased/objectstreamwithstate/foo.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(new Foo("Luigi","Cortese","Developer"));			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Reading Foo object from file
		 */
		
		try(
				FileInputStream fis=new FileInputStream("src/main/java/net/devsedge/bytebased/objectstreamwithstate/foo.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			System.out.println(ois.readObject());			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class Foo implements Serializable{
	
	private static final long serialVersionUID = -699850770639911026L;
	
	transient Person person;
	String category;
	
	Foo(String name, String surname,String category){
		person=new Person(name,surname);
		this.category=category;
	}
	
	/**
	 * Writes on file this (Foo) object and fields from transient member "person"
	 * 
	 * @param oos
	 * @throws Exception
	 */
	private void writeObject(ObjectOutputStream oos) throws Exception{
		oos.defaultWriteObject();
		oos.writeObject(person.getName());
		oos.writeObject(person.getSurname());
	}
	
	/**
	 * Reads from file this (Foo) object and assembles "person" field
	 * 
	 * @param ois
	 * @throws Exception
	 */
	private void readObject(ObjectInputStream ois) throws Exception{
		ois.defaultReadObject();
		String name=(String)ois.readObject();
		String surname=(String)ois.readObject();
		person=new Person(name, surname);
	}
	
	@Override
	public String toString(){
		return person.getName()+" "+person.getSurname()+", "+category;
	}
}

class Person{
	private String name,surname;
	Person(String name,String surname){
		this.name=name;
		this.surname=surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}