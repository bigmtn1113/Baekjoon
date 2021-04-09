import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		
		sc.close();
		
		int[] alphabetArray = new int[26];
		
		for (int i = 0; i < name.length(); ++i) {
			++alphabetArray[name.charAt(i) - 'A'];
		}
		
		int cnt = 0;
		char centerAlphabet = ' ';
		
		for (int i = 0; i < 26; ++i) {
			if (alphabetArray[i] % 2 == 1) {
				++cnt;
				centerAlphabet = (char) (i + 'A');
			}
		}
		
		if (cnt > 1) {
			System.out.print("I'm Sorry Hansoo");
			System.exit(0);
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < 26; ++i) {
			if (alphabetArray[i] <= 1) {
				continue;
			}
			
			for (int j = 0; j < alphabetArray[i] / 2; ++j) {
				answer.append((char) (i + 'A'));
			}
		}
		
		if (cnt > 0) {
			answer.append(centerAlphabet);
		}
			
		for (int i = (cnt > 0) ? answer.length() - 2 : answer.length() - 1; i >= 0; --i) {
			answer.append(answer.charAt(i));
		}
		
		System.out.print(answer);
	}

}
