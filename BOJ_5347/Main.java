import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int tempA = a;
			int tempB = b;
			
			if (tempA < tempB) {
				int temp = tempA;
				tempA = tempB;
				tempB = temp;
			}
			
			while (tempA % tempB != 0) {
				int temp = tempA;
				tempA = tempB;
				tempB = temp % tempB;
			}
			
			answer.append((long) a * b / tempB).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
