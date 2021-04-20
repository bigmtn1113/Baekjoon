import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
	
	public static void dfs(int[][] map, int row, int col) {
		if (visited[row][col]) {
			return;
		}
		
		visited[row][col] = true;
		
		for (int[] direction : directionArray) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			
			if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
				continue;
			}
			
			if ((map[nextRow][nextCol] == 1) && !visited[nextRow][nextCol]) {
				dfs(map, nextRow, nextCol);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if ((w == 0) && (h == 0)) {
				break;
			}
			
			int[][] map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j) {
					if ((map[i][j] == 1) && !visited[i][j]) {
						dfs(map, i, j);
						++cnt;
					}
				}
			}
			
			answer.append(cnt).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
