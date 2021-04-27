import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] gameBoard = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				gameBoard[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		long[][] dp = new long[n][n];
		
		dp[0][0] = 1;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (dp[i][j] == 0) {
					continue;
				}
				
				if ((i == n - 1) && (j == n - 1)) {
					break;
				}
				
				if (j + gameBoard[i][j] < n) {
					dp[i][j + gameBoard[i][j]] += dp[i][j];
				}
				
				if (i + gameBoard[i][j] < n) {
					dp[i + gameBoard[i][j]][j] += dp[i][j];
				}
			}
		}
		
		System.out.print(dp[n - 1][n - 1]);
	}

}
