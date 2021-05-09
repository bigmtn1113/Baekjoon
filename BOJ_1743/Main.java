import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int garbage;
	
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(boolean[][] aisle, int i, int j) {
		for (int[] direction : directionArray) {
			int nextI = i + direction[0];
			int nextJ = j + direction[1];
			
			if ((nextI == 0) || (nextJ == 0) || (nextI == aisle.length) || (nextJ == aisle[0].length)) {
				continue;
			}
			
			if (aisle[nextI][nextJ] && !visited[nextI][nextJ]) {
				visited[nextI][nextJ] = true;
				++garbage;
				
				dfs(aisle, nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		boolean[][] aisle = new boolean[n + 1][m + 1];
		
		for (int i = 0; i < k; ++i) {
			aisle[sc.nextInt()][sc.nextInt()] = true;
		}
		
		sc.close();
		
		visited = new boolean[n + 1][m + 1];
		
		int answer = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (aisle[i][j] && !visited[i][j]) {
					visited[i][j] = true;
					garbage = 1;
					
					dfs(aisle, i, j);
					answer = Math.max(answer, garbage);
				}
			}
		}
		
		System.out.print(answer);
	}

}
