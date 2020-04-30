
package multithreading;

import java.util.Date;
import java.text.SimpleDateFormat;

public class CreateThreadPool implements Runnable{
	String name;
	
	public CreateThreadPool(String s) {
		this.name = s;
		
	}
	
	public void run() {
		
		try {
		
		for(int i = 0; i < 5; i++) {
			Date d = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
			if(i == 0) {
				
				System.out.println("Initialization time : "+sd.format(d)+ "for task name : "+name);
			
			} else {
				System.out.println("Execution time : "+sd.format(d)+ "for task name : "+name);
				
			}
			Thread.sleep(1000);
		}
		
		System.out.println("Task execution has completed : "+ name);
	}
	
	catch(Exception e) {
		System.out.println("Exception Caught"+e.getMessage());
	}
	
}

}
