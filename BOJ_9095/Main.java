import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int[] dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 4; j <= n; ++j) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}
			
			answer.append(dp[n]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
