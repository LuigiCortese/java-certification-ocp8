package net.devsedge.lockandcondition.reentrantreadwritelock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.devsedge.NameUtil;
import net.devsedge.Util;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	static NameUtil nameUtil;
	static ReentrantReadWriteLock lock;
	
	static{
		nameUtil=new NameUtil(20);
		lock=new ReentrantReadWriteLock();
	}
	
	public static void main(String[] args) {
		
		Util.startTimer(10);
		
		new Thread(new Reader()).start();
		new Thread(new Reader()).start();
		new Thread(new Reader()).start();
		new Thread(new Writer()).start();
		
	}

}

class Reader implements Runnable{
	
	private String name=App.nameUtil.getName();
	
	@Override
	public void run() {
		System.out.println(name+": waiting for R lock");
		App.lock.readLock().lock();
		System.out.println(name+": got R lock, reading");
		
		try { 
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000,6000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			App.lock.readLock().unlock();
			System.out.println(name+": releasing R lock");
		}
		
		System.out.println(name+": exiting");
	}
}

class Writer implements Runnable{
	
	private String name=App.nameUtil.getName();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+": waiting for RW lock");
		App.lock.writeLock().lock();
		System.out.println(name+": got RW lock, writing");
		
		try { 
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			App.lock.writeLock().unlock();
			System.out.println(name+": releasing WR lock");
		}
		
	}
}