package net.devsedge.bytebased.datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
				FileOutputStream fos = new FileOutputStream("src/main/java/net/devsedge/bytebased/datastream/foo.txt");
				DataOutputStream dos = new DataOutputStream(fos)){
			dos.writeLong(123L);
			dos.writeBoolean(false);
			dos.writeUTF("UTF String");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 * Reading a file
		 */

		try(
				FileInputStream fis = new FileInputStream("src/main/java/net/devsedge/bytebased/datastream/foo.txt");
				DataInputStream dis = new DataInputStream(fis)){
			System.out.println(dis.readLong());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
