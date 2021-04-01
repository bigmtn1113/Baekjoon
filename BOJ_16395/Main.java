import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int[][] dp = new int[31][31];
		
		dp[1][1] = 1;
		
		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if ((j == 1) || (j == n)) {
					dp[i][j] = 1;
					continue;
				}
				
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		System.out.print(dp[n][k]);
	}
	
}
