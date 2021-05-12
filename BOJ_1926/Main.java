import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int area;
	
	public static void dfs(int[][] drawingPaper, int i, int j) {
		int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for (int[] direction : directionArray) {
			int nextI = i + direction[0];
			int nextJ = j + direction[1];
			
			if (nextI < 0 || nextJ < 0 || nextI == drawingPaper.length || nextJ == drawingPaper[0].length) {
				continue;
			}
			
			if ((drawingPaper[nextI][nextJ] == 1) && !visited[nextI][nextJ]) {
				visited[nextI][nextJ] = true;
				++area;
				
				dfs(drawingPaper, nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] drawingPaper = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				drawingPaper[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		visited = new boolean[n][m];
		
		int cnt = 0;
		int maxArea = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if ((drawingPaper[i][j] == 1) && !visited[i][j]) {
					visited[i][j] = true;
					area = 1;
					
					dfs(drawingPaper, i, j);
					
					maxArea = Math.max(maxArea, area);
					++cnt;
				}
			}
		}
		
		System.out.format("%d\n%d", cnt, maxArea);
	}

}
