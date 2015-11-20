package net.devsedge.executorservice.withcallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import net.devsedge.Util;


public class App {

	public static void main(String[] args) {
		/*
		 * The most useful purpose of an ExecutorService is to execute 
		 * one or more Callable objects. These objects can return a value 
		 */
		
		// creating the worker
		ExecutorService executor=Executors.newCachedThreadPool();

		// creating the jobs
		List<Callable<String>> callableList=new ArrayList<>();
		for (int i = 0; i < 4; i++)
			callableList.add(new MyCallable(ThreadLocalRandom.current().nextInt(3,7)));
		
		// running the jobs
		List<Future<String>>futureList=new ArrayList<>();
		for (Callable<String> callable:callableList)
			futureList.add(executor.submit(callable));
		
		/*
		 *  stopping the executor: default behavior is to wait for a maximum of 60 seconds of inactivity
		 *  before stopping every thread. 
		 *  This will guarantee every thread to be terminated as soon as it ends its execution
		 */
		executor.shutdown();
		
		// waiting for every task execution to be completed
		try {
			executor.awaitTermination(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 *  getting outputs from threads. 
		 *  Here we're starting to get the outputs when all the threads have finished, not the
		 *  best approach, but we need to keep it simple. Read here for more info:
		 *  
		 *  http://www.nurkiewicz.com/2013/02/executorcompletionservice-in-practice.html
		 */
		
		try{
			for(Future<String>future:futureList)
				System.out.println(future.get());
		}catch(InterruptedException | ExecutionException e){}
	}

}

class MyCallable implements Callable<String>{
	private final static int spacePrefix=20;
	private static char id='A';
	private String name;
	private int loops;
	{
		name=String.format("%"+((id-'A')*spacePrefix+1)+"s", id);
		id++;
	}
	public MyCallable(int loops){
		this.loops=loops;
	}
	@Override
	public String call(){
		String res="";
		System.out.println(name+": counting to "+loops+":");
		for(int i=1;i<loops+1;i++)
		{
			res+=i;
			System.out.println(name+": "+i+"...");
			Util.sleep_(ThreadLocalRandom.current().nextInt(300,1000));
		}
		return name+": "+res;
	}
}
