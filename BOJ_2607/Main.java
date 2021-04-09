import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String firstWord = sc.next();
		
		int[] firstWordAlphabet = new int[26];
		
		for (int i = 0; i < firstWord.length(); ++i) {
			++firstWordAlphabet[firstWord.charAt(i) - 'A'];
		}
		
		int answer = 0;
		
		for (int i = 1; i < n; ++i) {
			String word = sc.next();
			
			if (Math.abs(firstWord.length() - word.length()) > 1) {
				continue;
			}
			
			int[] WordAlphabet = new int[26];
			
			for (int j = 0; j < word.length(); ++j) {
				++WordAlphabet[word.charAt(j) - 'A'];
			}
			
			int cnt = 0;
			
			for (int j = 0; j < 26; ++j) {
				if (Math.abs(firstWordAlphabet[j] - WordAlphabet[j]) > 0) {
					cnt += Math.abs(firstWordAlphabet[j] - WordAlphabet[j]);
				}
			}
			
			if (cnt < 3) {
				++answer;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
