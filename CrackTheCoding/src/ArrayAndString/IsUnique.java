package ArrayAndString;

/*
 * Implements the algo to determine if a string has all unique characters what is u can't use additional data structure
 */
/*
 * requirements 
 * 
 * 1. What type of characters could this string hold example: ASCII(7 bits to represent the character), extended ASCII(8 bits to represent the character) , 
 * Unicode(16 bits) or only English characters // let's assume ASCII character 127
 * 2. IS this string is case sensitive means, A or a are different characters or same? Assume yes
 * 3. What could be the minimum / maximum size of String.
 */
public class IsUnique {
	
	private static boolean status(String s) {
			
		if(s == null || s.length() > 128)
			return false;
		
		boolean [] check = new boolean[128];
		
		for(int i = 0; i < s.length(); i++) {
			// important stored value at index i by s.charAt() of int type 
			int temp = s.charAt(i);
			if(check[temp]) {
				return false;
			}
			check[temp] = true;
			
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		/*
		 * Test cases 
		 * 1. Boundary Test cases 
		 * 2. Negative Test cases
		 * 3. Normal Test cases
		 */
		//3. String s = "aA@!~4";
		//String s = "";
		String s = null;
		boolean find = status(s);
		System.out.println(find);
		
	}

}
