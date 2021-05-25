import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(char[][] grid, int currI, int currJ, char color) {
		for (int[] direction : directions) {
			int nextI = currI + direction[0];
			int nextJ = currJ + direction[1];
			
			if ((nextI < 0) || (nextJ < 0) || (nextI == grid.length) || (nextJ == grid.length)) {
				continue;
			}
			
			if (!visited[nextI][nextJ] && (grid[nextI][nextJ] == color)) {
				visited[nextI][nextJ] = true;
				dfs(grid, nextI, nextJ, color);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		char[][] grid = new char[n][n];
		
		for (int i = 0; i < n; ++i) {
			grid[i] = sc.next().toCharArray();
		}
		
		sc.close();
		
		visited = new boolean[n][n];
		
		int normal = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j]) {
					dfs(grid, i, j, grid[i][j]);
					++normal;
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}
		
		for (boolean[] row : visited) {
			Arrays.fill(row, false);
		}
		
		int colorWeakness = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j]) {
					dfs(grid, i, j, grid[i][j]);
					++colorWeakness;
				}
			}
		}
		
		System.out.format("%d %d", normal, colorWeakness);
	}

}
