import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[][] graph;
	public static int[][] beadsCnt;
	public static boolean[] visited;
	
	public static void dfs(int bead, int currBead, int idx) {	// idx가 0이면 무거운 구슬들 탐색, 1이면 가벼운 구슬들 탐색
		for (int nextBead : graph[idx][currBead]) {
			if (!visited[nextBead]) {
				visited[nextBead] = true;
				++beadsCnt[idx][bead];
				
				dfs(bead, nextBead, idx);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList[2][n + 1];
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 1; j <= n; ++j) {
				graph[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < m; ++i) {
			int beadNum1 = sc.nextInt();
			int beadNum2 = sc.nextInt();
			
			graph[0][beadNum2].add(beadNum1);	// 무거운 구슬
			graph[1][beadNum1].add(beadNum2);	// 가벼운 구슬
		}
		
		sc.close();
		
		beadsCnt = new int[2][n + 1];
		visited = new boolean[n + 1];		// 무한루프가 존재해선 안되는데 존재하는 것 같으니 사용
		
		for (int idx = 0; idx < 2; ++idx) {
			for (int bead = 1; bead <= n; ++bead) {
				dfs(bead, bead, idx);
				Arrays.fill(visited, false);
			}
		}
		
		int middleWeightOfBeads = (n + 1) / 2;
		int answer = 0;
		
		for (int[] i : beadsCnt) {
			for (int j : i) {
				if (j >= middleWeightOfBeads) {		// j: 무겁거나 가벼운 구슬의 수
					++answer;
				}
			}
		}
		
		System.out.print(answer);
	}

}
