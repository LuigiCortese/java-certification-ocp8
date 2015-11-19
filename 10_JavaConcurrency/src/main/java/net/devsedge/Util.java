package net.devsedge;

import static java.lang.System.out;

public class Util {
	
	public static Object lock = new Object();
		
	/**
	 * Starts a timer
	 * 
	 * @param millis
	 */
	public static void startTimer(long millis) {
		new Thread(new Timer(millis)).start();
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
	private long millis;
	
	Timer(long millis){
		this.millis=millis;
	}
	
	@Override
	public void run() {
		for (int currentSecond = 0; currentSecond < 12; currentSecond++) {
			out.println(currentSecond + ": ");
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}