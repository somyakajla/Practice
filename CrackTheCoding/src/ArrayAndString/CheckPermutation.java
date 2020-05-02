package ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
	
	public static void main(String args[]) {
		
		assert checkPermutation("test", "test") == true;
		assert checkPermutationHashMap("", "t") == false;
		
	}

	private static boolean checkPermutationHashMap(String s1, String s2) {
		if (s1.length() != s2.length() || s1 == null || s2 == null)
			return false;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);

		}
		for (char cs2 : s2.toCharArray()) {
			if (map.containsKey(cs2)) {
				if (map.get(cs2) == 1)
					map.remove(cs2);

				else
					map.put(cs2, map.get(cs2) - 1);

			} else
				return false;

		}
		if (map.isEmpty())
			return true;
		else
			return false;
	}
	
	private static boolean checkPermutation(String s, String t) {
			if(s.length() != t.length())
				return false;
			
			char[] sChar = s.toCharArray();
			char[] tChar = t.toCharArray();
			Arrays.sort(sChar);
			Arrays.sort(tChar);
			for(int i=0; i<s.length() && i<t.length();i++) {
				if(sChar[i] != tChar[i])
					return false;
			}	
		return true;
	}
}


