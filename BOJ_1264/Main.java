import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		while (true) {
			String input = sc.nextLine().toLowerCase();
			
			if (input.equals("#")) {
				break;
			}
			
			int cnt = 0;
			
			for (int i = 0; i < input.length(); ++i) {
				char c = input.charAt(i);
				
				for (char vowel : vowels) {
					if (vowel == c) {
						++cnt;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
		sc.close();
	}
	
}
