package ArrayAndString;
/*
 * Question 3 types edits 
 * 1. insert 1 character
 * 2. remove 1 character 
 * 3. replace 1 character
 * write a function to check if they one edit away or 0 edit away
 * 
 * Requirements
 * 1. what should be return type if 1 / 0 edit away ? true / false
 * 2. what should be the max/min length of given strings 
 * 3. null strings are also allowed
 */

public class OneAway {
	
	public static void main(String args[]) {
		
		String s1 = "gfg"; 
	    String s2 = "gfge"; 
	    if(isEditDistanceOne(s1, s2)) 
	        System.out.print("Yes"); 
	    else
	        System.out.print("No");  
	}

	private static boolean isEditDistanceOne(String s, String p) {
		int count = 0;
		int m = s.length();
		int n = p.length();
		int i = 0, j = 0;
		while(i < m && j < n) {
			if(s.charAt(i) != p.charAt(j)) {
				if(count == 1)
					return false;
				if(m > n) {
					// insert element in string with sorter length
					i++;
				}
				else if(m < n) {
					// insert element in string with sorter length
					j++;
				}
				else {
					// replace element in one of these 2 string
					i++;
					j++;
				}
				// 1 operation is made count ++
				count++;
				
			}
			else {
				// if elements are equal move on to next element
				i++;
				j++;
			}
			
		}
		if(i < m || j < n) 
			count++;
		
		return count == 1;
	}

}
