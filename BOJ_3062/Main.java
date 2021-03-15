import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String input = sc.next();
			
			String reverseInput = "";
			
			for (int j = input.length() - 1; j >= 0; --j) {
				reverseInput += input.charAt(j);
			}
			
			String result = Integer.toString(Integer.parseInt(input) + Integer.parseInt(reverseInput));
			
			boolean check = true;
			
			for (int j = 0; j < result.length() / 2; ++j) {
				if (result.charAt(j) != result.charAt(result.length() - 1 - j)) {
					check = false;
				}
			}
			
			System.out.println((check) ? "YES" : "NO");
		}
		
		sc.close();
		
	}
	
}
