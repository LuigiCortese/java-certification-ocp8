package net.devsedge.nio2.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Reading attributes from view
		 */
		
		// Returns a file attribute view of a given type.
		BasicFileAttributeView bfaw = Files.getFileAttributeView(
						Paths.get("src/main/java/net/devsedge/nio2/attributeview/foo.txt"),
						BasicFileAttributeView.class);
		
		System.out.println("lastModifiedTime: "+bfaw.readAttributes().lastModifiedTime());
		System.out.println("lastAccessTime: "+bfaw.readAttributes().lastAccessTime());
		System.out.println("size: "+bfaw.readAttributes().size());
		
		/*
		 * Reading attributes from BasicFileAttributes
		 */
		
		// Reads a file's attributes as a bulk operation.
		BasicFileAttributes bfa = Files.readAttributes(
				Paths.get("src/main/java/net/devsedge/nio2/attributeview/foo.txt"),
				BasicFileAttributes.class);

		System.out.println("\nlastModifiedTime: "+bfa.lastModifiedTime());
		System.out.println("lastAccessTime: "+bfa.lastAccessTime());
		System.out.println("size: "+bfa.size());
		
		/*
		 * Reading attributes directly
		 */
		
		System.out.println("\nlastModifiedTime: "+Files.getAttribute(
				Paths.get("src/main/java/net/devsedge/nio2/attributeview/foo.txt"),
				"basic:lastModifiedTime"));		
		System.out.println("lastAccessTime: "+Files.getAttribute(
				Paths.get("src/main/java/net/devsedge/nio2/attributeview/foo.txt"),
				"basic:lastAccessTime"));
		System.out.println("size: "+Files.getAttribute(
				Paths.get("src/main/java/net/devsedge/nio2/attributeview/foo.txt"),
				"basic:size"));
		
	}

}
