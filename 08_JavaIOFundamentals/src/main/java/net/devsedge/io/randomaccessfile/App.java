package net.devsedge.io.randomaccessfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {

		/*
		 * Creating a file
		 */
		
		createFile();
		
		/*
		 * Reading file 
		 */
		
		readFile();
		
		/*
		 * Writing on existing file (content will be overwritten)
		 */
		
		try(
				RandomAccessFile raf = new RandomAccessFile("src/main/java/net/devsedge/io/randomaccessfile/foo.txt","rw")){
			raf.seek(6);
			raf.write(new byte[]{65,66,67,68,69,70,71,72});
			raf.skipBytes(14);
			raf.write(new byte[]{65,66,67,68,69,70,71,72,73,74,75});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Reading modified file
		 */
		
		readFile();

	}
	
	static void createFile(){
		try(
				PrintWriter pw = new PrintWriter("src/main/java/net/devsedge/io/randomaccessfile/foo.txt");){
			pw.println("This is the first line,");
			pw.println("this is the second line");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void readFile(){
		try(
				FileReader fr = new FileReader("src/main/java/net/devsedge/io/randomaccessfile/foo.txt");
				BufferedReader br = new BufferedReader(fr);){
			String s=null;
			while((s=br.readLine())!=null)
				System.out.println(s);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
