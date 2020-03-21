package ArrayAndString;

public class ReplaceAllSpaces {

	public static void main(String args[]) {
		String s = "Mr John Smith    ";
		char[] s1 = replaceStringMethod(s, 13);
		System.out.println("length is "+s1.length);
		for(int i=0; i<s1.length; i++) {
			
			System.out.print(s1[i]);
				
		}
		
	}

	private static char[] replaceStringMethod(String s, int trueLength) {
		char[] array = s.toCharArray();
		int spaceCount = 0;
		int index;
		for(int i=0; i<trueLength; i++) {
			if(array[i] == ' ') 
				spaceCount++;		
				
		}
		index = trueLength+spaceCount*2;
		// have to ask it's explanation  
		if(trueLength < s.length())
			array[trueLength] = '\0';
		for(int i=trueLength-1; i>=0; i-- ) {
		if(array[i] == ' ') {
			array[index-1] = '0';
			array[index-2] = '2';
			array[index-3] = '%';
			index = index-3;
		}
		else {
			array[index-1] = array[i];
			index--;
		}
		}

		
	return array;		
		
	}
}
