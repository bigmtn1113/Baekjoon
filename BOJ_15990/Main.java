import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int[][] dp = new int[100001][4];
		
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = dp[3][2] = dp[3][3] = 1;
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 4; j <= n; ++j) {
				if (dp[j][1] > 0) {
					continue;
				}
				
				dp[j][1] = (int) (((long) dp[j - 1][2] + dp[j - 1][3]) % 1000000009);
				dp[j][2] = (int) (((long) dp[j - 2][1] + dp[j - 2][3]) % 1000000009);
				dp[j][3] = (int) (((long) dp[j - 3][1] + dp[j - 3][2]) % 1000000009);
			}
			
			answer.append(((long) dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
