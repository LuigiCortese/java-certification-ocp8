package net.devsedge.charbased.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Writing a file
		 */
		
		try(FileWriter fw = new FileWriter("src/main/java/net/devsedge/charbased/file/foo.ser")){
			fw.write("Writing a line here...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Reading a file
		 */
		
		try(FileReader fr = new FileReader("src/main/java/net/devsedge/charbased/file/foo.ser")){
			char[]readArray=new char[30];
			fr.read(readArray);
			System.out.println(readArray);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
