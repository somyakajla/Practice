package ArrayAndString;

public class CompressedString {
	
	public static void main(String args[]) {
		
		String s = "aaaaac";
		String result = callCompressed(s);
		System.out.println("this is result"+" "+result);
	}

	
	/*private static String callCompressed(String s) {
		
		String finalResult = "";
		int consecutive = 0;
		for(int i=0; i<s.length(); i++) {
			consecutive++;
			if(i+1 < s.length() && s.charAt(i) != s.charAt(i+1)) {
				finalResult = finalResult+""+s.charAt(i)+consecutive;
				consecutive = 0;
			}
			if(i+1 == s.length()) {
				finalResult = finalResult+""+s.charAt(i)+consecutive;
			}
		}
		
		return finalResult.length() < s.length() ? finalResult : s;
	}*/
	
	private static String callCompressed(String s) {
		StringBuilder finalString = new StringBuilder();
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			count++;
			if(i+1 < s.length() && s.charAt(i) != s.charAt(i+1)) {
				finalString = finalString.append(s.charAt(i));
				finalString = finalString.append(count);
				count = 0;
			}
			if(i+1 == s.length()) {
				finalString = finalString.append(s.charAt(i));
				finalString = finalString.append(count);
			}
			
		}
		
		return finalString.length() < s.length() ? finalString.toString() : s;
	}
	

}
