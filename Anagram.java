/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1New = preProcess(str1);
		String str2New = preProcess(str2);
		char[] array1 = str1New.toCharArray();
		char[] array2 = str2New.toCharArray();
		for (int i = 0 ; i < array1.length; i++){
			boolean result = false;
			for (int j = 0; j < array2.length; j++){
				if (array1[i] == array2[j]) {
					result = true;
					array2[j] = 0;
					break;
				}
			}

			if (!result){
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String lowerCase = str.toLowerCase();
		String cleaned = lowerCase.replaceAll("[!? ]", "");
		return cleaned;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char[] arrayStr = str.toCharArray();
		String strNew = "";
		for (int i = 0; i < str.length(); i++){
		int randomStr = (int) (Math.random() * (arrayStr.length - i));
		strNew += arrayStr[randomStr];
		arrayStr[randomStr] = arrayStr[arrayStr.length - i - 1];

		}
		return strNew;
	}
	}

