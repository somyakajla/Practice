package ArrayAndString;

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
				if(m > n)
					i++;
				else if(m < n)
					j++;
				else {
					i++;
					j++;
				}
				count++;
				
			}
			else {
				i++;
				j++;
			}
			
		}
		if(i < m || j < n) 
			count++;
		
		return count == 1;
	}

}
