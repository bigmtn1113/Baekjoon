import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] maze = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				maze[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int[][] directionArray = {{-1, 0}, {0, -1}, {-1, -1}};
		int[][] dp = new int[n][m];
		
		dp[0][0] = maze[0][0];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				for (int[] direction : directionArray) {
					int preI = i + direction[0];
					int preJ = j + direction[1];
					
					if (preI < 0 || preJ < 0 || preI == n || preJ == m) {
						continue;
					}
					
					dp[i][j] = Math.max(dp[i][j], dp[preI][preJ] + maze[i][j]);
				}
			}
		}
		
		System.out.print(dp[n - 1][m - 1]);
	}

}
