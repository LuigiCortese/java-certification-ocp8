package net.devsedge;

import static java.lang.System.out;

public class Util {
	
	public static Object lock = new Object();
		
	/**
	 * Starts a timer
	 * 
	 * @param millis
	 */
	public static void startTimer(int limit) {
		new Thread(new Timer(limit)).start();
	}
	
	/**
	 * Send current thread to "sleep" for the given amount of time
	 * @param m
	 */
	public static void sleep_(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * waits until another thread calls notify/notifyAll
	 */
	public static void wait_() {
		try {
			lock.wait();
		} catch (InterruptedException e) {
			out.println(Thread.currentThread().getName() + "* finished waiting in exception!");
		}
	}
	
}

class Timer implements Runnable {
	private int limit;
	
	Timer(int limit){
		this.limit=limit;
	}
	
	@Override
	public void run() {
		for (int currentSecond = 0; currentSecond < limit; currentSecond++) {
			out.println(currentSecond + ": ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}