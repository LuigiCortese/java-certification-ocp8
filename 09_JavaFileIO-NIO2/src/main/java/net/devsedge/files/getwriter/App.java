package net.devsedge.files.getwriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * Creating a simple file with Path Api
		 */
		
		Path file = Paths.get("src/main/java","net/devsedge/files/getwriter","foo.txt");
		
		try(BufferedWriter bw = Files.newBufferedWriter(
				file, 
				Charset.forName("UTF-8"),
				new OpenOption[] {
						StandardOpenOption.TRUNCATE_EXISTING, 
						StandardOpenOption.CREATE})){
		
			bw.write("This text file is created using Path API");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
