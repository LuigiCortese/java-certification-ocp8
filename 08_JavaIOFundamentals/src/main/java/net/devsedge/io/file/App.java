package net.devsedge.io.file;

import java.io.File;
import java.io.IOException;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Creating a File object, it may be bound to an actual file or directory if it exist, otherwise
		 * it's an abstract representation.
		 * 
		 * No file is being written in the file system yet.
		 */
		
		File file=new File("src/main/java/net/devsedge/io/file/foo.txt");
		
		/*
		 * Checking if file exist.
		 */
		
		System.out.println(file.exists());
		
		/*
		 * Checking if file is actually a file...
		 */
		
		System.out.println(file.isFile());
		
		/*
		 * ...or a directory
		 */
		
		System.out.println(file.isDirectory());
		
		/*
		 * Writing file to disk if it doesn't exist yet.
		 * When writing a file, specified path must exist, intermediate directories
		 * in the path won't be created and an exception will be thrown
		 */
		
		if(!file.exists())
			file.createNewFile();
		
		/*
		 * Create a new File object representing a directory
		 */
		
		File dir = new File("src/main/java/net/devsedge/io/file/my.dir");

		/*
		 * Writing directory to disk
		 */
		
		dir.mkdir();
		
		/*
		 * Create a new File object representing a directory
		 */
		
		File dir2 = new File("src/main/java/net/devsedge/io/file/intermediate.dir/my.dir");
		
		/*
		 * Next instruction won't do anything, because intermediate directory doesn't exist
		 */
		
		dir2.mkdir();
		
		/*
		 * This method creates intermediate directories
		 */
		
		dir2.mkdirs();
	}

}
