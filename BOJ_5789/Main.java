import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			String input = sc.next();
			
			System.out.println((input.charAt(input.length() / 2 - 1) == input.charAt(input.length() / 2)) ? "Do-it" : "Do-it-Not");
		}
		
		sc.close();
	}
	
}
