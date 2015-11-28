package net.devsedge.threadandrunnable.waitnotify;
import static java.lang.System.out;

import net.devsedge.NameUtil;
import net.devsedge.Util;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {
	
	static NameUtil nameUtil=new NameUtil(30);
	
	public static void main(String[] args) {
		new App();
	}

	App(){
		//run the timer
		Util.startTimer(11);
		
		/*
		 * Three threads will gain the lock in sequence
		 */
		for (int i = 0; i < 3; i++) {
			new Thread(new Locker()).start();
			Util.sleep_(1000);
		}
		
		/*
		 * All the lockers are now waiting, *Unlocker* will release the lock with "notifyAll"
		 */
		new Thread(new Unlocker()).start();
	}	
}

class Locker implements Runnable{
	
	private String name=App.nameUtil.getName();
	
	@Override
	public void run() {
		out.println(name+"  starts");
		out.println(name+"  trying to get in synch block...");
		synchronized(Util.lock){
			out.println(name+"* in synch block!");
			out.println(name+"  waiting (releases lock)...");
			Util.wait_();
			out.println(name+"* finished waiting out of exception!");
			out.println(name+"  exiting synch block");
		}
	}
}


class Unlocker implements Runnable{
	
	private String name=App.nameUtil.getName();
	
	@Override
	public void run() {
		out.println(name+"  starts");
		out.println(name+"  trying to get in synch block...");
		synchronized(Util.lock){
			out.println(name+"* in synch block!");
			out.println(name+"* sleeps for 3 secs");
			Util.sleep_(3000);
			out.println(name+"* awake!");
			out.println(name+"* notifies");
			Util.lock.notifyAll();
			out.println(name+"* sleeps for 3 secs");
			Util.sleep_(3000);
			out.println(name+"* awake!");
			out.println(name+"  exiting synch block");
		}
	}
}