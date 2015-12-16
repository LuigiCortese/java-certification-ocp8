package net.devsedge.exception.trycatch;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		try{
			throw new Exception();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
