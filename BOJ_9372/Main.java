import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for (int j = 0; j < m; ++j) {
				sc.nextInt();
				sc.nextInt();
			}
			
			answer.append(n - 1).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
