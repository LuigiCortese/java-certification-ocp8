package net.devsedge.executorservice.withrunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import net.devsedge.Util;

public class App {

	public static void main(String[] args) {
		/*
		 * The most basic (and least useful) purpose of an ExecutorService is
		 * to execute one or more Runnable objects
		 */
		
		// creating the worker
		ExecutorService executor=Executors.newCachedThreadPool();

		// creating the jobs
		Runnable[] jobsList=new Runnable[5];
		for(int i=0;i<5;i++)
			jobsList[i]=new MyRunnable(ThreadLocalRandom.current().nextInt(3,7));

		// running the jobs
		for(Runnable runnable:jobsList)
			executor.execute(runnable);
		
		/*
		 *  stopping the executor: default behavior is to wait for a maximum of 60 seconds of inactivity
		 *  before stopping every thread. 
		 *  This will guarantee every thread to be terminated as soon as it ends its execution
		 */
		executor.shutdown();
	}
	

}

class MyRunnable implements Runnable{
	private final static int spacePrefix=20;
	private static char id='A';
	private String name;
	private int loops;
	{
		name=String.format("%"+((id-'A')*spacePrefix+1)+"s", id);
		id++;
	}
	public MyRunnable(int loops){
		this.loops=loops;
	}
	@Override
	public void run(){
		System.out.println(name+": counting to "+loops+":");
		for(int i=1;i<loops+1;i++)
		{
			System.out.println(name+": "+i+"...");
			Util.sleep_(ThreadLocalRandom.current().nextInt(300,1000));
		}
	}
}
