import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(int[][] region, int currI, int currJ) {
		visited[currI][currJ] = true;
		
		for (int[] direction : directionArray) {
			int nextI = currI + direction[0];
			int nextJ = currJ + direction[1];
			
			if (nextI < 0 || nextJ < 0 || nextI == region.length || nextJ == region.length) {
				continue;
			}
			
			if (!visited[nextI][nextJ]) {
				dfs(region, nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] region = new int[n][n];
		int maxHeight = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				region[i][j] = sc.nextInt();
				
				maxHeight = Math.max(maxHeight, region[i][j]);
			}
		}
		
		sc.close();
		
		int answer = 0;
		
		for (int i = 0; i < maxHeight; ++i) {
			visited = new boolean[n][n];
			
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					if (region[j][k] <= i) {
						visited[j][k] = true;
					}
				}
			}
			
			int cnt = 0;
			
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					if (!visited[j][k]) {
						dfs(region, j, k);
						
						++cnt;
					}
				}
			}
			
			answer = Math.max(answer, cnt);
		}
		
		System.out.print(answer);
	}

}
