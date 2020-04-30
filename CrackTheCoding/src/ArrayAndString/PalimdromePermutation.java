package ArrayAndString;

import java.util.HashMap;
/*
 * requirements
 * 1. 
 */

public class PalimdromePermutation {
	public static void main (String[] args) {
		/*
		 * Test cases 
		 * 1. Negative 
		 * odd length with every character count is even :: not possible
		 * even length with 
		 */
		if (canFormPalindrome("naman")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
		if (canFormPalindrome("naman")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
	  
	    if (canFormPalindrome("geeksogeeks")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
	    if (canFormPalindrome("ge")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
	    if (canFormPalindrome("g")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
	    if (canFormPalindrome("")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
		}

	private static boolean canFormPalindrome(String s) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int size = s.length();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				if(map.get(c) % 2 == 1) {
					map.remove(c);
				}
				else {
					map.put(c, map.getOrDefault(c, 0)+1);
				}
				
			}
			else {
				map.put(c, map.getOrDefault(c, 0)+1);
			}
		}
		if(size % 2 == 0 && map.isEmpty() || size % 2 == 1 && ! map.isEmpty())
			return true;
		
		return false;
	}
		
	

}
