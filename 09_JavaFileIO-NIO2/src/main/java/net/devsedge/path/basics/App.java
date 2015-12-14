package net.devsedge.path.basics;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	static int i;
	
	public static void main(String[] args) {
		
		/*
		 * Normalize: removes redundant name elements
		 */
		
		Path p = Paths.get("a",".","b","..","b","c");
		
		System.out.println(++i+") Normalizing "
				+ "\n\t"+p
				+ "\n\t----"
				+ "\n\t"+p.normalize()+"\n");
		
		/*
		 * Resolve returns
		 * 
		 *  - p2, if p2 is an absolute path
		 *  - p1, if p2 is an empty path 
		 *  - p1+p2 otherwise
		 */
		
		Path p1 = Paths.get("a","b","c");
		Path p2 = Paths.get("d:","e","f");
		
		System.out.println(++i+") Resolving (p2 is an absolute path): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolve(p2)+"\n");
		
		p2 = Paths.get("");
		
		System.out.println(++i+") Resolving (p2 is an empty path): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolve(p2)+"\n");
		
		p2 = Paths.get("d","e","f");
		
		System.out.println(++i+") Resolving (joining paths): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolve(p2)+"\n");
		
		p2 = Paths.get("a","b","c");
		
		System.out.println(++i+") Resolving (joining paths): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolve(p2)+"\n");
		
		/*
		 * ResolveSibling returns
		 * 
		 *  - p2, if p2 is absolute or p1 does not have a parent path
		 *  - p1's parent, if p2 is empty
		 *  - p1+p2's parent otherwise
		 */
		
		p1 = Paths.get("a","b","c");
		p2 = Paths.get("d:","e","f");
		
		System.out.println(++i+") Resolving sibling (p2 is an absolute path): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolveSibling(p2)+"\n");
		
		p2 = Paths.get("");
		
		System.out.println(++i+") Resolving sibling (p2 is an empty path): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolveSibling(p2)+"\n");
		
		p2 = Paths.get("d","e","f");
		
		System.out.println(++i+") Resolving sibling (joining paths): "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.resolveSibling(p2)+"\n");
		
		/*
		 * Relativize: returns a relative path between p1 and p2
		 */
		
		p1 = Paths.get("a","b","c");
		p2 = Paths.get("d","e","f");
		
		System.out.println(++i+") Relativizing: "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.relativize(p2)+"\n");

		p2 = Paths.get("a","b","d");
		
		System.out.println(++i+") Relativizing: "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.relativize(p2)+"\n");
		
		p2 = Paths.get("a","b","c","d","e");
		
		System.out.println(++i+") Relativizing: "
				+ "\n\t"+p1
				+ "\n\t"+p2
				+ "\n\t----"
				+ "\n\t"+p1.relativize(p2)+"\n");
		
		/*
		 * Subpath
		 */
		
		p1 = Paths.get("a","b","c","d","e");
		
		System.out.println(++i+") Subpath (0,2): "
				+ "\n\t"+p1
				+ "\n\t----"
				+ "\n\t"+p1.subpath(0,2)+"\n");
		
		p1 = Paths.get("a:","b","c","d","e");
		
		System.out.println(++i+") Subpath (0,2): "
				+ "\n\t"+p1
				+ "\n\t----"
				+ "\n\t"+p1.subpath(0,2)+"\n");
		
		p1 = Paths.get("a:","b","..","b","c");
		
		System.out.println(++i+") Subpath (0,3): "
				+ "\n\t"+p1
				+ "\n\t----"
				+ "\n\t"+p1.subpath(0,3)+"\n");
	}

}
