import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int m = sc.nextInt();
		
		int sum = 0;
		
		for (int i = m - 1; i > -1; --i) {
			sum += Math.pow(a, i) * sc.nextInt();
		}
		
		sc.close();
		
		String result = Integer.toString(sum, b);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < result.length(); ++i) {
			char c = result.charAt(i);
			
			answer.append((('a' <= c) && (c <= 'z')) ? (c - 'a' + 10) + " " : c + " ");
		}
		
		System.out.print(answer);
	}
	
}
