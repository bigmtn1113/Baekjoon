import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static StringBuilder answer = new StringBuilder();
	
	public static void makeCipher(char[] kindsOfChars, int l, int preIdx, String cipher) {
		if (cipher.length() == l) {
			int vowelCnt = 0;
			int consonantCnt = 0;
			
			for (int i = 0; i < l; ++i) {
				char temp = cipher.charAt(i);
				
				switch (temp) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					++vowelCnt;
					break;

				default:
					++consonantCnt;
					break;
				}
			}
			
			if ((vowelCnt >= 1) && (consonantCnt >= 2)) {
				answer.append(cipher).append("\n");
			}
			
			return;
		}
		
		for (int i = preIdx + 1; i < kindsOfChars.length; ++i) {
			makeCipher(kindsOfChars, l, i, cipher + kindsOfChars[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int c = sc.nextInt();
		
		char[] kindsOfChars = new char[c];
		
		for (int i = 0; i < c; ++i) {
			kindsOfChars[i] = sc.next().charAt(0);
		}
		
		sc.close();
		
		Arrays.sort(kindsOfChars);
		
		makeCipher(kindsOfChars, l, -1, "");
		
		System.out.print(answer);
	}

}
