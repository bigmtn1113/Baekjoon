import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] hpArray = new int[n + 1];
		int[] pleasureArray = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			hpArray[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= n; ++i) {
			pleasureArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[][] dp = new int[n + 1][100];
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j < 100; ++j) {
				if (j >= hpArray[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hpArray[i]] + pleasureArray[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.print(dp[n][99]);
	}

}
