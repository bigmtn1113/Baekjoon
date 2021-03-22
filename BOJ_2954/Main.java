import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine() + "  ";
		
		sc.close();
		
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		for (int i = 0; i < input.length(); ) {
			char c = input.charAt(i);
			boolean check = false;
			
			for (char vowel : vowels) {
				if (c == vowel) {
					if ((input.charAt(i + 1) == 'p') && (input.charAt(i + 2) == c)) {
						check = true;
						break;
					}
				}
			}
			
			System.out.print(c);
			
			if (check) {
				i += 3;
			} else {
				++i;
			}
		}
	}
	
}
