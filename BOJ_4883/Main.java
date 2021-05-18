import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int[][] directionArray = {{0, 1}, {1, -1}, {1, 0}, {1, 1}};
		
		int k = 1;
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == 0) {
				break;
			}
			
			int[][] graph = new int[n + 1][4];
			
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= 3; ++j) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			int[][] dp = new int[n + 1][4];
			
			for (int[] row : dp) {
				Arrays.fill(row, 1, 4, 1000000000);
			}
			
			dp[1][2] = graph[1][2];		// 가장 윗쪽 가운데 정점
			
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= 3; ++j) {
					for (int[] direction : directionArray) {
						int[] next = {i + direction[0], j + direction[1]};
						
						if ((next[0] == 0) || (next[1] == 0) || (next[0] > n) || (next[1] > 3)) {
							continue;
						}
						
						dp[next[0]][next[1]] = Math.min(dp[next[0]][next[1]], dp[i][j] + graph[next[0]][next[1]]);
					}
				}
			}
			
			answer.append(k++).append(". ").append(dp[n][2]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
