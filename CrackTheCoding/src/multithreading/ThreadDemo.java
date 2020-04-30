package multithreading;

//public class ThreadDemo {
//	
//	public static void main(String args[]) {
//		
//		CreateThreads ct = new CreateThreads();
//		ct.start();
//		
//		
//	}
//
//}



public class ThreadDemo {
	public static void main(String args[]) {
		for (int i=0; i<4; i++) 
        { 
		
		Thread t = new Thread(new CreateThreads()); // Note: first create object of Thread class and then pass the object of new class 
		t.start();
        }
    }

}
