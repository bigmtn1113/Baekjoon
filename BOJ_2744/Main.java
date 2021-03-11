import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		char[] word = new char[input.length()];
		
		for (int i = 0; i < word.length; ++i) {
			char c = input.charAt(i);
			
			if (('A' <= c) && (c <= 'Z')) {
				word[i] = (char) (c + 32);
			} else {
				word[i] = (char) (c - 32);
			}
		}
		
		for (char c : word) {
			System.out.print(c);
		}
	}
	
}
