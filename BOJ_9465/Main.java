import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		int[][] stickerScoreArray = new int[2][100000];
		int[][] dp = new int[2][100000];
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 0; j < 2; ++j) {
				for (int k = 0; k < n; ++k) {
					stickerScoreArray[j][k] = sc.nextInt();
				}
			}
			
			dp[0][0] = stickerScoreArray[0][0];
			dp[1][0] = stickerScoreArray[1][0];
			dp[0][1] = stickerScoreArray[0][1] + dp[1][0];
			dp[1][1] = stickerScoreArray[1][1] + dp[0][0];
			
			for (int j = 2; j < n; ++j) {
				dp[0][j] = Math.max(stickerScoreArray[0][j] + dp[1][j - 1], stickerScoreArray[0][j] + dp[1][j - 2]);
				dp[1][j] = Math.max(stickerScoreArray[1][j] + dp[0][j - 1], stickerScoreArray[1][j] + dp[0][j - 2]);
			}
			
			answer.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
