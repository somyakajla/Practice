package multithreading;


/*
 * 2 ways to create threads  
 * by extends thread class
 * by implements runnable
 */
 
// First Way
//public class CreateThreads extends Thread{
//	
//	public void run() {
//		
//		try {
//			System.out.println("Current thread Id"+Thread.currentThread().getId());
//			
//		} catch(Exception e) {
//			System.out.println("Exception caught"+e.getMessage());
//		}
//		
//	}
//	
//
//}


// second Way

public class CreateThreads implements Runnable {
	
	public void run() {
		
		try {
			System.out.println("Current thread Id"+Thread.currentThread().getId());
			
		} catch(Exception e) {
			System.out.println("Exception caught"+e.getMessage());
		}
		
	}
}


