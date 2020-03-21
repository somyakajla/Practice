package ArrayAndString;

import java.util.Hashtable;

public class stringImplementation {

	/*
	 * 1. n*n time by traversing string by for loop with optimized solution
	 */
	/*private static Boolean findUniqueChar(String s) {

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}*/
	
	/*
	 * 2. use hashtable in n time
	 */
	/*private static Boolean findUniqueChar(String s) {

		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (ht.containsKey(s.charAt(i)))
				return false;
			else
				ht.put(s.charAt(i), 1);
		}

		return true;
	}*/
	
	/*
	 * 3.A see solution in back
	 * Assumed ASCII string which has 128 character
	 * we can assume extended ASCII string pattern 
	 * Time complexity n with extra data structure  
	 */
	/*private static Boolean findUniqueChar(String s) {
		if(s.length() > 128)
			return false;
		boolean[] array = new boolean[128];
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			//System.out.println(index);
			if(array[index]) {
				return false;
			}
			array[index] = true;
			
		}
		return true;

	}*/
	
	/*
	 * 3.B see solution in back
	 * Assumed ASCII string which has 128 character
	 * we can assume extended ASCII string pattern  
	 */
	private static Boolean findUniqueChar(String s) {
		if(s.length() > 128)
			return false;
		boolean[] array = new boolean[128];
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			//System.out.println(index);
			if(array[index]) {
				return false;
			}
			array[index] = true;
			
		}
		return true;

	}
	
	public static void main(String args[]) {
		 Boolean b = findUniqueChar("sSomya");
		System.out.print(b);
		
	}

}
