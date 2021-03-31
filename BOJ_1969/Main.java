import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] dnaArray = new String[n];
		
		for (int i = 0; i < n; ++i) {
			dnaArray[i] = sc.next();
		}
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		int sum = 0;
		
		for (int i = 0; i < m; ++i) {
			int[] alphabet = new int[26];
			
			int maxAlphabet = 0;
			int maxAlphabetIndex = 0;
			
			for (int j = 0; j < n; ++j) {
				int c = dnaArray[j].charAt(i) - 'A';
				
				if (++alphabet[c] > maxAlphabet) {
					maxAlphabet = alphabet[c];
					maxAlphabetIndex = c;
				}
			}
			
			int temp = 'Z';
			boolean check = false;
			
			for (int j = 0; j < 26; ++j) {
				if (alphabet[j] == maxAlphabet) {
					temp = Math.min(j + 'A', temp);
					check = true;
				}
				
				sum += alphabet[j];
			}
			
			sum -= maxAlphabet;
			
			answer.append((check) ? (char) temp : (char) (maxAlphabetIndex + 'A'));
		}
		
		System.out.print(answer.append("\n" + sum));
	}
	
}
