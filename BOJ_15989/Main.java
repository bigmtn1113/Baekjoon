import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] dp = new int[4][10001];
		
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[3][0] = 1;
		
		int t = sc.nextInt();
		
		StringBuilder answer =  new StringBuilder();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 1; j < 4; ++j) {
				for (int k = 1; k < j; ++k) {
					if (dp[j][k] == 0) {
						dp[j][k] = dp[j - 1][k];
					}
				}
				
				for (int k = j; k <= n; ++k) {
					if (dp[j][k] == 0) {
						dp[j][k] = dp[j - 1][k] + dp[j][k - j];
					}
				}
			}
			
			answer.append(dp[3][n]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
