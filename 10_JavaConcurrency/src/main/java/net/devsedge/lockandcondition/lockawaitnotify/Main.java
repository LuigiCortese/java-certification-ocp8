package net.devsedge.lockandcondition.lockawaitnotify;

import static java.lang.System.out;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import net.devsedge.Util;

public class Main {
	
	static Lock lock=new ReentrantLock();
	static Condition condition=lock.newCondition();

	public static void main(String[] args) {
		//run the timer
		Util.startTimer(1000);
		
		/*
		 * Three threads (on the same *Locker* object) will gain the lock in sequence
		 */
		Locker locker=new Locker();
		
		new Thread(locker,String.format("%4s", "X")).start();
		Util.sleep_(1000);
		
		new Thread(locker,String.format("%40s", "Y")).start();
		Util.sleep_(1000);
		
		new Thread(locker,String.format("%76s", "Z")).start();
		Util.sleep_(1000);
		
		/*
		 * All the lockers are now waiting, *Unlocker* will release the lock with "signalAll"
		 */
		new Thread(new Unlocker(),String.format("%112s", "A")).start();
	
	}

}

class Locker implements Runnable{
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		out.println(name+"  starts");
		out.println(name+"  trying to get in \"synch\" block...");
		Main.lock.lock();
		try{
			out.println(name+"* in \"synch\" block!");
			out.println(name+"  waiting (releases lock)...");
			try{Main.condition.await();
			}catch(InterruptedException e){}
			out.println(name+"* finished waiting out of exception!");
			out.println(name+"  exiting \"synch\" block");
		}finally{
			Main.lock.unlock();
		}
	}
}

class Unlocker implements Runnable{
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		out.println(name+"  starts");
		out.println(name+"  trying to get in \"synch\" block...");
		Main.lock.lock();
		try{
			out.println(name+"* in \"synch\" block!");
			out.println(name+"* sleeps for 3 secs");
			Util.sleep_(3000);
			out.println(name+"* awake!");
			out.println(name+"* signals");
			Main.condition.signalAll();
			out.println(name+"* sleeps for 3 secs");
			Util.sleep_(3000);
			out.println(name+"* awake!");
			out.println(name+"  exiting \"synch\" block");
		}finally{
			Main.lock.unlock();
		}
	}
}