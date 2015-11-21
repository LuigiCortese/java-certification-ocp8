package net.devsedge.forkjoin.withaction;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import static java.lang.System.out;

public class App {

	static int[] data={1,2,3,4,5,6,7,8,9,10,11,12};
	
	public static void main(String[] args) {

		/*
		 * The problem here is to add a value of 1000 to every single element of array "data";
		 * 
		 * Every workload greater than 3 numbers is considered too big and needs to be splitted.
		 * 
		 * 3 or less is an acceptable amount of work.
		 */
		
		// creating the worker
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		// creating the job
		RecursiveAction recursiveAction = new MyRecursiveAction('*',0,data.length-1);
		
		// running the job
		forkJoinPool.invoke(recursiveAction);

		System.out.println(Arrays.toString(data));
	}

}

class MyRecursiveAction extends RecursiveAction{
	
	private static char id='A';
	private char origin;
	private String name;
	private final static int spacePrefix=20;
	
	private static final long serialVersionUID = 839423778891909774L;
	private int start,end;
	
	{
		name=String.format("%"+((id-'A')*spacePrefix+1)+"s", id);
		id++;
	}
	
	
	public MyRecursiveAction(char origin,int start,int end){
		out.println(name+": from "+origin);
		this.origin=origin;
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected void compute(){
		out.println(name+": starts ["+start+","+end+"]");

		// if workload is manageable
		if(end-start+1<=3){
			out.println(name+": not too big, working...");
			for(int i=start;i<=end;i++){
				App.data[i]+=1000;
			}
		}
		
		// if workload is too big
		else{
			
			int mid=((end-start+1)/2)+start;
			out.println(name+": too big, dividing ["+start+","+(mid-1)+"]["+mid+","+end+"]");
			MyRecursiveAction recursiveActionLeft = new MyRecursiveAction(name.charAt(name.length() - 1),start,mid-1);
			MyRecursiveAction recursiveActionRight = new MyRecursiveAction(name.charAt(name.length() - 1),mid,end);
			
			// queue left task (starts execution)
			recursiveActionLeft.fork();
			
			// work on right half of the task
			recursiveActionRight.compute();
	
			// wait for left task to be completed
			recursiveActionLeft.join();
			
		}
	}
}