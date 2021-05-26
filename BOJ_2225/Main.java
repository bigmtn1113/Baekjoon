import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		/* 세로는 0(정수가 0부터 시작하므로) ~ n, 가로는 1 ~ k
			1 2 3 4 5
		0	1 1 1 1 1
		1	1 2 3 4 5
		2	1 3 6 10 15
		3	1 4 10 20 35
		4	1 5 15 35 70
		5	1 6 21 56 126
		*/
		
		int[][] dp = new int[n + 1][k + 1];
		
		Arrays.fill(dp[0], 1);
		
		for (int i = 0; i <= n; ++i) {
			dp[i][1] = 1;
		}
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 2; j <= k; ++j) {
				for (int t = 0; t <= i; ++t) {
					dp[i][j] = (dp[i][j] + dp[t][j - 1]) % 1000000000;
				}
			}
		}
		
		System.out.print(dp[n][k]);
	}

}
