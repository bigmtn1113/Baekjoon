import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] words = new String[n];
		String[] reverseWords = new String[n];
		
		for (int i = 0; i < n; ++i) {
			words[i] = sc.next();
			
			StringBuilder temp = new StringBuilder();
			for (int j = words[i].length() - 1; j >= 0 ; --j) {
				temp.append(words[i].charAt(j));
			}
			
			reverseWords[i] = temp.toString();
		}
		
		sc.close();
		
		for (String reverseWord : reverseWords) {
			for (String word : words) {
				if (reverseWord.equals(word)) {
					System.out.format("%d %c", word.length(), word.charAt(word.length() / 2));
					System.exit(0);
				}
			}
		}
	}
	
}
