package net.devsedge.files.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	static final Path rootPath = Paths.get("src/main/java/net/devsedge/files/streams");

	public static void main(String[] args) throws IOException {
		
		/*
		 * List: Return a lazily populated Stream, the elements of which are the entries in the directory. 
		 * The listing is not recursive. 
		 */
		
		System.out.println("---- Files.list ----\n");
		try(Stream<Path> list = Files.list(rootPath)){
			list.forEach(System.out::println);
		}
		
		/*
		 * Walk: Return a Stream that is lazily populated with Path by walking the file tree rooted 
		 * at a given starting file. The file tree is traversed depth-first, the elements in the stream 
		 * are Path objects that are obtained as if by resolving the relative path against start. 
		 */
		
		System.out.println("\n---- Files.walk (depth undefined) ----\n");
		try(Stream<Path> walk = Files.walk(rootPath)){
			walk.forEach(System.out::println);
		}
		
		System.out.println("\n---- Files.walk (depth 2) ----\n");
		try(Stream<Path> walk = Files.walk(rootPath,2)){
			walk.forEach(System.out::println);
		}
		
		/*
		 * Find: Return a Stream that is lazily populated with Path by searching for files in a file 
		 * tree rooted at a given starting file. 
		 * For each file encountered, the given BiPredicate is invoked with its Path and BasicFileAttributes.
		 */
		
		System.out.println("\n---- Files.find (depth 2) ----\n");
		try(Stream<Path> find = Files.find(
				rootPath,
				2,
				(path,attr)->path.toString().endsWith("txt"))){
			find.forEach(System.out::println);
		}
		
		System.out.println("\n---- Files.find (depth 4) ----\n");
		try(Stream<Path> find = Files.find(
				rootPath,
				4,
				(path,attr)->path.toString().endsWith("txt"))){
			find.forEach(System.out::println);
		}

		/*
		 * Lines: Read all lines from a file as a Stream. Bytes from the file are decoded into characters 
		 * using the UTF-8 charset. 
		 */

		System.out.println("\n---- Files.lines ----\n");
		try(Stream<String> lines = Files.lines(
				rootPath.resolve("c.dir/c.1.txt"))
				){
			lines.forEach(System.out::println);
		}
		
	}

}
