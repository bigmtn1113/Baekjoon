import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String inputWord1 = sc.next();
		String inputWord2 = sc.next();
		
		sc.close();
		
		int[] word1AlphabetCnt = new int[26];
		int[] word2AlphabetCnt = new int[26];
		
		for (int i = 0; i < inputWord1.length(); ++i) {
			++word1AlphabetCnt[inputWord1.charAt(i) - 'a'];
		}
		
		for (int i = 0; i < inputWord2.length(); ++i) {
			++word2AlphabetCnt[inputWord2.charAt(i) - 'a'];
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 26; ++i) {
			cnt += Math.abs(word1AlphabetCnt[i] - word2AlphabetCnt[i]);
		}
		
		System.out.print(cnt);
	}
	
}
