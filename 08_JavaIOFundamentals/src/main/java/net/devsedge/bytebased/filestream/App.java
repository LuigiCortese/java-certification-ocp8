package net.devsedge.bytebased.filestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {

		/*
		 * Writes a file byte by byte
		 */
		
		try (FileOutputStream fos = new FileOutputStream("src/main/java/net/devsedge/bytebased/filestream/foo.txt")) {
			
			char out = 'A';
			
			do {
				fos.write(out);
			} while (out++ != 'Z');
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Reads the file byte by byte
		 */
		
		try (FileInputStream fis=new FileInputStream("src/main/java/net/devsedge/bytebased/filestream/foo.txt")){
			
			int data = fis.read();
			
            while (data != -1) {
            	
                System.out.print((char)data);
                
                data = fis.read();
            }

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
