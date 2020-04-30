package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	static final int max_T = 3;
	
	public static void main(String args[]) {
		
		// created  5 threads 
		Thread r1 = new Thread(new CreateThreadPool("Task1"));
		Thread r2 = new Thread(new CreateThreadPool("Task2"));
		Thread r3 = new Thread(new CreateThreadPool("Task3"));
		Thread r4 = new Thread(new CreateThreadPool("Task4"));
		Thread r5 = new Thread(new CreateThreadPool("Task5"));
		
		// thread pool with maximum 3 capacity
		
		ExecutorService pool = Executors.newFixedThreadPool(max_T);
		
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();	
		
	}

}
