import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String input = sc.next();
			
			boolean[] alphabet = new boolean[26];
			int answer = 0;
			
			for (int j = 0; j < input.length(); ++j) {
				alphabet[input.charAt(j) - 'A'] = true;
			}
			
			for (int j = 0; j < 26; ++j) {
				if (!alphabet[j]) {
					answer += j + 65;
				}
			}
			
			System.out.println(answer);
		}
		
		sc.close();
	}
	
}
