package BitManipulation;

public class BitOperations {
	

	static void bin(long n) 
	{ 
	    if (n > 1) 
	        bin(n / 2); 
	    System.out.print(n % 2); 
	} 
	 
	
	
	public static void main(String args[]) {
		
		 // print original bitset 
	    int N = 1201, M = 8, i = 3, j = 6; 
	    System.out.print("N = " + N + "("); 
	    bin(N); 
	    System.out.println(")"); 
	      
	    // print original bitset 
	    System.out.print("M = " + M + "("); 
	    bin(M); 
	    System.out.println(")"); 
	      
	    // Call function to getBit M to N 
	    boolean b = getBit(N, i); 
	    System.out.println( "result of getBit "+b); 
	    
	}



	private static boolean getBit(int n, int i) {
		// this shifts 1 by i bits towards left 
		// 1 << 3
		// 1000 will be the answer, shifts 1 by 3 bits towards left
		System.out.print(1<<i);
		// it set ith to 1 which I want to get
		// now, and operation will return me the required bit
		// 10010110001 & 1000 == 0 
		return  ((n & (1<<i)) == 0);
	}
	
	private static boolean setBit(int n, int i) {
		// this shifts 1 by i bits towards left 
		// 1 << 3
		// 1000 will be the answer, shifts 1 by 3 bits towards left
		System.out.print(1<<i);
		// it set ith to 1 which I want to get
		// now, or operation will change the bit which I want 
		// 10010110001 | 1000 
		return  ((n | (1<<i)) == 0);
	}
	//TODO
	private static int clearGivenBit(int n, int i) {
		// this shifts 1 by i bits towards left 
		// 1 << 3
		// 1000 will be the answer, shifts 1 by 3 bits towards left
		// it set ith to 1 then negate of it which will called mask
		// now, and operation with mask will clear the given bit 
		int mask = (~(1<<i));
		return  n & mask;
	}
	
	private static int clearmostsignificattoiBit(int n, int i) {
		// this shifts 1 by i bits towards left 
		// 1 << 3
		// 1000 will be the answer, shifts 1 by 3 bits towards left
		// it set ith to 1 then subtract 1 of it which will called mask
		// now, and operation with mask will clear the given bit 
		int mask = ((1<<i)-1);
		return  n & mask;
	}
	
	private static int clearito0Bit(int n, int i) {
		// this shifts 1 by i bits towards left 
		// 1 << 3
		// 1000 will be the answer, shifts 1 by 3 bits towards left
		// it set ith to 1 then subtract 1 of it which will called mask
		// now, and operation with mask will clear the given bit 
		int mask = (-1 << (i+1));
		return  n & mask;
	}
	
	private static int updateBit(int n, int i, boolean bits1) {
		int val = bits1 ? 1:0;
		int mask = ~ (1<<i);
		// create a number with bit i equal to v and other bits equal to 0
		// now or operation with cleared bit 
		return (n & mask) | (val << i);
		
	}
	

	}


