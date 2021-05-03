import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int cnt = 0;
	
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(int currI, int currJ) {
		visited[currI][currJ] = true;
		++cnt;
		
		for (int[] direction : directionArray) {
			int nextI = currI + direction[0];
			int nextJ = currJ + direction[1];
			
			if (nextI < 0 || nextJ < 0 || nextI == visited.length || nextJ == visited[0].length) {
				continue;
			}
			
			if (!visited[nextI][nextJ]) {
				dfs(nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		visited = new boolean[m][n];
		
		for (int i = 0; i < k; ++i) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int j = y1; j < y2; ++j) {
				for (int l = x1; l < x2; ++l) {
					visited[j][l] = true;
				}
			}
		}
		
		sc.close();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j]) {
					dfs(i, j);
					
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder answer = new StringBuilder(String.valueOf(list.size())).append("\n");
		
		for (int i : list) {
			answer.append(i).append(" ");
		}
		
		System.out.print(answer);
	}

}
