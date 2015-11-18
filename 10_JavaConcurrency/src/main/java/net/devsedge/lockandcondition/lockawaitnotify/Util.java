package net.devsedge.lockandcondition.lockawaitnotify;

import static java.lang.System.out;

public class Util {
	static void startTimer() {
		new Thread(new Timer()).start();
	}

	static void sleep_(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
		}
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