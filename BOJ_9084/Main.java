import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] coins = new int[n + 1];
			
			for (int j = 1; j <= n; ++j) {
				coins[j] = sc.nextInt();
			}
			
			int m = sc.nextInt();
			
			int[][] dp = new int[n + 1][m + 1];
			
			for (int j = 1; j <= n; ++j) {
				dp[j][0] = 1;
				
				for (int k = coins[1]; k <= m; ++k) {
					if (k < coins[j]) {
						dp[j][k] = dp[j - 1][k];
					} else {
						dp[j][k] = dp[j - 1][k] + dp[j][k - coins[j]];
					}
				}
			}
			
			answer.append(dp[n][m]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
