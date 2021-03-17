import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		sc.close();
		
		int sum = 0;
		
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			
			if (('a' <= c) && (c <= 'z')) {
				sum += c - 96;
			} else {
				sum += c - 38;
			}
		}
		
		boolean check = false;
		
		for (int i = 2; i < sum; ++i) {
			if (sum % i == 0) {
				check = true;
			}
		}
		
		System.out.print((!check || sum < 3) ? "It is a prime word." : "It is not a prime word.");
	}
	
}
