package net.devsedge.cyclicbarrier.basic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static CyclicBarrier barrier;

	static {
		/*
		 * 4  - is the max number of waiting threads (the barrier)
		 * 
		 * new ActionRunnable() - is the action to be executed every 
		 *                        time the barrier is reached
		 */
		barrier = new CyclicBarrier(4,new ActionRunnable());
	}

	public static void main(String[] args) {
		
		/*
		 * Every [500...1000] milliseconds a Thread is started
		 */
		for(int i=0;i<8;i++){
			new Thread(new MyRunnable(),""+i).start();
			try { 
				Thread.sleep(ThreadLocalRandom.current().nextLong(1000,1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyRunnable implements Runnable {
	private static int id=1;
	private String name;
	{
		name=String.format("%"+(id*4)+"s", id);
		id++;
	}
	@Override
	public void run() {
		try {
			System.out.println(name+" run, now awaiting ("+(Main.barrier.getNumberWaiting()+1)+" total)");
			Main.barrier.await();
			System.out.println(name+" stopped awaiting!");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class ActionRunnable implements Runnable{
	@Override
	public void run(){
		System.out.println("----------------");
		System.out.println("Action triggered");
		System.out.println("----------------");
	}
}