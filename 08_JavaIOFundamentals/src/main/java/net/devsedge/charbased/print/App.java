package net.devsedge.charbased.print;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

		try(
				FileWriter fw = new FileWriter("src/main/java/net/devsedge/charbased/print/foo.txt");
				PrintWriter pw = new PrintWriter(fw);){
			pw.println("Writing a new line");
			pw.print(123L);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Reading the file
		 */
		
		try(
				FileReader fr = new FileReader("src/main/java/net/devsedge/charbased/print/foo.txt");){
			int c;
			/*
			 * notice that when end of file is reached, an integer of -1 is returned. That's different from a char of -1,
			 * that's why "c" must be an int. 
			 * What would it print if "c" was declared "char" (with appropriate castings)?
			 */
			while((c= fr.read())!=-1)
				System.out.print((char)c);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
