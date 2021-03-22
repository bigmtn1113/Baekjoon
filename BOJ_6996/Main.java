import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String a = sc.next();
			String b = sc.next();
			
			if (a.length() != b.length()) {
				System.out.println(a + " & " + b + " are NOT anagrams.");
				continue;
			}
			
			int[] alphabets = new int[26];
			
			for (int j = 0; j < a.length(); ++j) {
				++alphabets[a.charAt(j) - 'a'];
			}
			
			for (int j = 0; j < b.length(); ++j) {
				--alphabets[b.charAt(j) - 'a'];
			}
			
			boolean check = true;
			
			for (int alphabet : alphabets) {
				if (alphabet != 0) {
					check = false;
				}
			}
			
			System.out.println((check) ? a + " & " + b + " are anagrams." : a + " & " + b + " are NOT anagrams.");
		}
		
		sc.close();
	}
	
}
