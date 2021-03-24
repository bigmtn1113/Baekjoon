import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < t; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int tempA = a;
			int tempB = b;
			
			while (tempA % tempB != 0) {
				int temp = tempA;
				tempA = tempB;
				tempB = temp % tempB;
			}
			
			answer.append(a * b / tempB).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
