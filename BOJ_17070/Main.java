import java.util.Scanner;

public class Main {
	
	public static boolean canGoNext(int[][] home, int nextI, int nextJ, int i, int j) {
		if (((nextI < home.length) && (nextJ < home.length))
				&& ((home[nextI][nextJ] == 0) && (home[i][j + 1] == 0) && (home[i + 1][j] == 0))) {
			return true;
		}
		
		return false;
	}
	
	public static boolean canGoNext(int[][] home, int nextI, int nextJ) {
		if (((nextI < home.length) && (nextJ < home.length))
				&& (home[nextI][nextJ] == 0)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] home = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				home[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int[] horizontal = {0, 1};
		int[] vertical = {1, 0};
		int[] diagonal = {1, 1};
		
		// dp[i][j][k]: i - 1행 j - 1열에 k방향으로 오는 경우의 수
		// k가 0이면 가로, 1이면 세로, 2면 대각선
		int[][][] dp = new int[n][n][3];
		dp[0][1][0] = 1;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if ((home[i][j] == 1)) {
					continue;
				}
				
				for (int k = 0; k < 3; ++k) {
					if (dp[i][j][k] == 0) {
						continue;
					}
					
					int nextI = 0;
					int nextJ = 0;
					
					switch (k) {
					case 0:
						nextI = i + horizontal[0];
						nextJ = j + horizontal[1];
						
						if (canGoNext(home, nextI, nextJ)) {
							dp[nextI][nextJ][0] += dp[i][j][0];
						}
						
						nextI = i + diagonal[0];
						nextJ = j + diagonal[1];
						
						if (canGoNext(home, nextI, nextJ, i, j)) {
							dp[nextI][nextJ][2] += dp[i][j][0];
						}
						break;
						
					case 1:
						nextI = i + vertical[0];
						nextJ = j + vertical[1];
						
						if (canGoNext(home, nextI, nextJ)) {
							dp[nextI][nextJ][1] += dp[i][j][1];
						}
						
						nextI = i + diagonal[0];
						nextJ = j + diagonal[1];
						
						if (canGoNext(home, nextI, nextJ, i, j)) {
							dp[nextI][nextJ][2] += dp[i][j][1];
						}
						break;
	
					case 2:
						nextI = i + horizontal[0];
						nextJ = j + horizontal[1];
						
						if (canGoNext(home, nextI, nextJ)) {
							dp[nextI][nextJ][0] += dp[i][j][2];
						}
						
						nextI = i + vertical[0];
						nextJ = j + vertical[1];
						
						if (canGoNext(home, nextI, nextJ)) {
							dp[nextI][nextJ][1] += dp[i][j][2];
						}
						
						nextI = i + diagonal[0];
						nextJ = j + diagonal[1];
						
						if (canGoNext(home, nextI, nextJ, i, j)) {
							dp[nextI][nextJ][2] += dp[i][j][2];
						}
						break;
					}
				}
			}
		}
		
		System.out.print(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}

}
