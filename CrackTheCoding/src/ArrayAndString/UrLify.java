package ArrayAndString;

/*
 * Question write a function to replace all the space by %20. you may assume that the string has sufficient space in the end to hold additional characters
 * 
 * Requirements 
 * 1. single space will be replaced by %20 or there could be multiple space 
 * 2. there could be possibility that multiple space could be encounter one after another before end of string
 */

public class UrLify {
	
	public static void main(String args[]) {
		String s = "Mr John Smith    ";
		char[] new_s = UrlifyMethod(s, 13);
		System.out.println(new_s);
	}

	private static char[] UrlifyMethod(String s, int n) {
		char[] array_s = s.toCharArray();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(array_s[i] == ' ')
				count++;
		}
		int index = n + (count *2);
		
		for(int i = n-1; i >= 0; i--) {
			if(array_s[i] == ' ') {
				array_s[index - 1] = '0';
				array_s[index - 2] = '2';
				array_s[index - 3] = '%';
				index = index - 3;
			} else {
				array_s[index - 1] = array_s[i];
				index = index - 1;
			}
			
		}
		
		

		return array_s;
	}

}
