
public class StringImpl {
	public static float convert(String s) {	
		
		if (s == null || s.isEmpty())
			return 0;

		float element = 0; // to store result
		int point = 0; // to keep the index of point from front
		int signed = 1; // To keep -ve sign 
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				point = i;
			} else if (s.charAt(i) == '-') {
				signed = signed * -1;
			} else {
				element = element * 10 + s.charAt(i) - '0';
			}
		}	
		
		int j = s.length() - point - 1; // 6 - 3 == 3

		while (j > 0) {
			element /= 10;
			j--;
		}
		return signed * element;
	}

	public static void main(String args[]) {
		// System.out.println(convert("54.98"));
		System.out.println(convert("98"));
		System.out.println(convertStringtoInt("-23.87"));
	}
	
		public static float convertStringtoInt(String s) {	
			
			float d = 0;
			
		    if (s == null || s.isEmpty()) {
		        return 0;
		    }
		    try {
		        d = Float.parseFloat(s);
		    } catch (NumberFormatException nfe) {
		        return 0;
		    }
		    return d;
			
		}
}
