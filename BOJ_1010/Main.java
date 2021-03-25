import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] dp = new int[30][30];
		
		for (int i = 1; i < 30; ++i) {
			dp[1][i] = i;
		}
		
		for (int i = 2; i < 30; ++i) {
			for (int j = 2; j < 30; ++j) {
				for (int k = j - 1; k > 0; --k) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		
		int t = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			answer.append(dp[n][m]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
