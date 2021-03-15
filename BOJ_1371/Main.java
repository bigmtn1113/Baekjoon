import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] alphabets = new int[26];
		
		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			
			for (int i = 0; i < input.length; ++i) {
				for (int j = 0; j < input[i].length(); ++j) {
					++alphabets[input[i].charAt(j) - 'a'];
				}
			}
		}
		
		sc.close();
		
		int maxCnt = 0;
		
		for (int alphabet : alphabets) {
			maxCnt = Math.max(maxCnt, alphabet);
		}
		
		for (int i = 0; i < 26; ++i) {
			if (alphabets[i] == maxCnt) {
				System.out.print((char) (i + 'a'));
			}
		}
	}
	
}
