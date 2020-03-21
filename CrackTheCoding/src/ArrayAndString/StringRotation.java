package ArrayAndString;

public class StringRotation {
	public static void main(String args[]) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		if(isRotation(s1, s2))
			System.out.println("True");
		else
			System.out.println("False");
	}

	private static boolean isRotation(String s1, String s2) {
		
		return (s1.length() == s2.length()) &&  
	               ((s1 + s1).contains(s2)); 
	}

	

}
