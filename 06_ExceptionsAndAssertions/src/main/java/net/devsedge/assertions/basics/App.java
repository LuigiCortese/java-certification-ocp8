package net.devsedge.assertions.basics;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		new App();
	}
	
	App(){
		printAge(18);
		printInfo(19);
	}
	
	private void printAge(int age){
		assert age>=0:"Age must be a positive number";
		System.out.println("Age = "+age);
	}
	
	public void printInfo(int age){
		if(age<0)age*=-1;

		if(age>=0&&age<18)
			System.out.println("Underage");
		else if(age>=18)
			System.out.println("Adult");
		else
			assert false:"Age must be a positive number";
	}

}
