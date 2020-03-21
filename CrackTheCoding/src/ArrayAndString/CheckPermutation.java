package ArrayAndString;

import java.util.HashMap;

public class CheckPermutation {

	 /*
	  * Question 2. check permutation: given 2 strings, write the method to decide if one is a permutation of the other
	  * 
	  * note: permutation same character with different arrangement
	  * Requirements:
	  * 1. what are the expected time complexity
	  * 2. which is more important better time complexity or space complexity
	  * 3. Are strings case sensitive? for example, Abc , abc are permutations or not??
	  * 4. string could be null or empty?
	  * 5. String min/max size()of string?
	  * what should I return once they both are permutation and when they are not? true/ false
	  * 
	  */
	
	/*
	 * Idea 1.  : sort both string and then check if they are equal or not
	 * complexity : sort s1 = n(log(n))
	 * sort s2 = n(log(n));
	 * .equals method O(n)
	 * overall complexity: 2nlogn + n == O(n(log(n))
 	 */
	
	/*
	 * Idea 2. : HashMap<Char, Integer> of char and their count 
	 * now read the second string and check if that char is present in the hash map if yes then decrease its frequency from map and move to next char 
	 * in the end if hash map is empty then both are permutation return 
	 * Complexity : space O(n) where n is the unique character in the string first
	 * time complexity O(n) to put char of string s1 into hash map
	 * O(n) to compare the elements of s2 from hash map 
	 * overall O(n) 
	 */
	
	public static void main(String args[]) {
		/*
		 * Test cases 
		 * 1. boundary test cases 
		 * 2. normal test cases
		 * 3. Negative test cases 
		 */
		String s1 = "test";  
        String s2 = "ttsE";  
//		String s1 = "aA";
//		String s2 = "aa";
		
		boolean status = checkPermutation(s1, s2);
		System.out.println(status);
		
	}

	/*
	 * Idea 1
	 */
//	private static boolean checkPermutation(String s1, String s2) {
//		if(s1.length() != s2.length() || s1 == null || s2 == null)
//			return false;
//		
//		//n(log(n));
//		char[] array_s1 = s1.toCharArray();
//		Arrays.sort(array_s1);
//		
//		//n(log(n));
//		char[] array_s2 = s2.toCharArray();
//		Arrays.sort(array_s2);
//		
//		for(int i = 0; i < array_s1.length; i++) {
//			if(array_s1[i] != array_s2[i])
//				return false;
//		}
//	
//		return true;
//		
//	}
	
	/*
	 * Idea 2
	 */
	private static boolean checkPermutation(String s1, String s2) {
		if(s1.length() != s2.length() || s1 == null || s2 == null)
			return false;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c: s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			
		}
		for(char cs2: s2.toCharArray()) {
			if(map.containsKey(cs2)) {
				if(map.get(cs2) == 1) 
					map.remove(cs2);
				
				else
					map.put(cs2, map.get(cs2)-1);
				
			}
			else
				return false;
			
		}
		if(map.isEmpty())
			return true;
		else
			return false;
	}
	
}

	
//	/*private static boolean checkPermutation(String s, String t) {
//		
//		if(s.length() != t.length())
//			return false;
//		char[] sChar = s.toCharArray();
//		char[] tChar = t.toCharArray();
//		Arrays.sort(sChar);
//		Arrays.sort(tChar);
//		for(int i=0; i<s.length() && i<t.length();i++) {
//			if(sChar[i] != tChar[i])
//				return false;
//		}	
//		return true;
//	}*/
//	
//	/*
//	 * check it by count character
//	 * Assumed ASCII format 128
//	 */
//	private static boolean checkPermutation(String s, String t) {
//		
//		if(s.length() != t.length())
//			return false;
//		int[] letters = new int[128];  // ASCII characters
//		for(int i = 0; i < s.length(); i++) {
//			letters[s.charAt(i)]++;	
//			//System.out.println(s.charAt(i));
//			//System.out.println(letters[s.charAt(i)]++);
//		}
//		for(int i = 0; i < t.length(); i++) {
//			letters[t.charAt(i)]--;	
//			if( letters[t.charAt(i)] < 0)
//				return false;
//		}
//		return true;
//		
//	}
//	public static void main(String args[]) {
//		String str1 = "test";  
//	    String str2 = "ttse";  
//	    if (checkPermutation(str1, str2))  
//	    System.out.println("Yes");  
//	    else
//	    System.out.println("No");  
//		
//	}


