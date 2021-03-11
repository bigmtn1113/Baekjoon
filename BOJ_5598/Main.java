import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		char[] word = new char[input.length()];
		
		for (int i = 0; i < word.length; ++i) {
			word[i] = input.charAt(i);
		}
		
		sc.close();
		
		for (char c : word) {
			System.out.print((c > 'C') ? (char) (c - 3) : (char) (c + 23));
		}
	}
	
}
