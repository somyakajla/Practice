package ArrayAndString;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class PalimdromePermutation {
	public static void main (String[] args) {
		if (canFormPalindrome("naman")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
	  
	    if (canFormPalindrome("geeksogeeks")) 
	        System.out.println("Yes"); 
	    else
	        System.out.println("No"); 
		}
		/* static boolean canFormPalindrome(String str) { 
			 
		     Hashtable<Character, Integer> input = new Hashtable<Character, Integer>();
		     for(int i=0; i<str.length(); i++) {
		    	 if(input.containsKey(str.charAt(i))) {
		    		 Integer value = input.get(str.charAt(i));
		    		 input.put(str.charAt(i), value+1);
		    	 }
		    	 else {
		    		 input.put(str.charAt(i), 1);
		    	 }
		     }
		     boolean check = false;
		     Enumeration e = input.elements(); 
		     while(e.hasMoreElements()) {
		    	 if(e.nextElement().equals(1) && check == false) {
		    		 check = true;
		    	 }
		    	 else if(e.nextElement().equals(1) && check == true){
		    		 return false;
		    	 }
		     }
		     
		     return true;
		     
		 }*/
	
	static boolean canFormPalindrome(String str) { 
		  
        // Create a list 
        List<Character> list = new ArrayList<Character>(); 
  
        // For each character in input strings, 
        // remove character if list contains 
        // else add character to list 
        for (int i = 0; i < str.length(); i++) { 
            if (list.contains(str.charAt(i))) 
                list.remove((Character) str.charAt(i)); 
            else
                list.add(str.charAt(i)); 
        } 
  
        // if character length is even list is expected to empty 
        // or if character length is off list size is expected to be 1 
        if (str.length() % 2 == 0 && list.isEmpty() // if string length is even 
                || (str.length() % 2 == 1 && list.size() == 1)) // if string length is odd 
            return true; 
        else
            return false; 
  
    } 

}
