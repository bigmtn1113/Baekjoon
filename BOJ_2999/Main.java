import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		int inputLength = input.length();
		int maxR = 0;
		
		for (int i = 1; i * i <= inputLength; ++i) {
			if (inputLength % i == 0) {
				maxR = Math.max(maxR, i);
			}
		}
		
		for (int i = 0; i < maxR; ++i) {
			for (int j = i; j < inputLength; j += maxR) {
				System.out.print(input.charAt(j));
			}
		}
	}
	
}
