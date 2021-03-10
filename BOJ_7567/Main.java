import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		int height = 10;
		
		char previousBowl = input.charAt(0);
		
		for (int i = 1; i < input.length(); ++i) {
			char c = input.charAt(i);
			
			if (c == '(') {
				if (previousBowl == '(') {
					height += 5;
				} else {
					height += 10;
				}
			} else {
				if (previousBowl == ')') {
					height += 5;
				} else {
					height += 10;
				}
			}
			
			previousBowl = c;
		}
		
		System.out.print(height);
	}
	
}
