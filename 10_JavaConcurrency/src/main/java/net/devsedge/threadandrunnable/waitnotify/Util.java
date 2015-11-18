package net.devsedge.threadandrunnable.waitnotify;

import static java.lang.System.out;

public class Util {
	static void sleep_(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
		}
	}

	static void wait_() {
		try {
			lock.wait();
		} catch (InterruptedException e) {
			out.println(Thread.currentThread().getName() + "* finished waiting in exception!");
		}
	}

	// create the lock object
	static Object lock = new Object();

	static void startTimer() {
		new Thread(new Timer()).start();
	}
}

class Timer implements Runnable {
	@Override
	public void run() {
		for (int currentSecond = 0; currentSecond < 12; currentSecond++) {
			out.println(currentSecond + ": ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}