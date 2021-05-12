import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int r = 0;
		int c = 0;
		
		if (k == 0) {
			r = n;
			c = m;
		} else {
			r = (k % m != 0) ? k / m + 1: k / m;
			c = (k % m != 0) ? k % m: m;
		}
		
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= r; ++i) {
			for (int j = 1; j <= c; ++j) {
				dp[i][j] = Math.max(dp[i - 1][j] + dp[i][j - 1], 1);
			}
		}
		
		int answer = dp[r][c];
		
		dp[r - 1][c] = dp[r][c - 1] = 0;
		
		for (int i = r; i <= n; ++i) {
			for (int j = c; j <= m; ++j) {
				dp[i][j] = Math.max(dp[i - 1][j] + dp[i][j - 1], 1);
			}
		}
		
		System.out.print(answer * dp[n][m]);
	}

}
