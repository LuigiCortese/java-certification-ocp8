package net.devsedge.forkjoin.withtask;

import static java.lang.System.out;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import net.devsedge.NameUtil;

public class App {

	static int[] data={1,2,3,4,5,6,7,8,9,10,11,12};
	static NameUtil nameUtil=new NameUtil(20);
	
	public static void main(String[] args) {

		/*
		 * The problem here is summing the integers stored in array "data". 
		 * 
		 * Every workload greater than 3 numbers is considered too big and needs to be splitted.
		 * 
		 * 3 or less is an acceptable amount of work.
		 */
		
		// creating the worker
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		// creating the job
		RecursiveTask<Integer> recursiveTask = new MyRecursiveTask('*',0,data.length-1);
		
		// running the job
		Integer sum=forkJoinPool.invoke(recursiveTask);

		System.out.println(sum);
	}

}

class MyRecursiveTask extends RecursiveTask<Integer>{
	
	private String name;
	private static final long serialVersionUID = 839423778891909774L;
	private int start,mid,end;
	
	{
		name=App.nameUtil.getName();
	}
	
	
	public MyRecursiveTask(char origin,int start,int end){
		out.println(name+": from "+origin);
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected Integer compute(){
		out.println(name+": evaluating ["+start+","+end+"]");

		// if workload is manageable
		if(end-start+1<=3){
			out.println(name+": not too big, working...");
			int sum=0;
			for(int i=start;i<=end;i++){
				sum+=App.data[i];
			}
			return sum;
		}
		
		// if workload is too big
		else{
			
			mid=((end-start+1)/2)+start;
			out.println(name+": too big, dividing ["+start+","+(mid-1)+"]["+mid+","+end+"]");
			MyRecursiveTask recursiveTaskLeft = new MyRecursiveTask(name.charAt(name.length() - 1),start,mid-1);
			MyRecursiveTask recursiveTaskRight = new MyRecursiveTask(name.charAt(name.length() - 1),mid,end);
			
			// queue left task (starts execution)
			recursiveTaskLeft.fork();
			
			// work on right half of the task
			int rightSum=recursiveTaskRight.compute();
	
			// wait for left task to be completed
			int leftSum=recursiveTaskLeft.join();
			
			return rightSum+leftSum;
			
		}
	}
}