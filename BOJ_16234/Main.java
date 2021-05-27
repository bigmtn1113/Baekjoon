import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	private int r;
	private int c;
	
	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
}

public class Main {
	public static Queue<Location> unionQueue = new LinkedList<>();
	
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static boolean[][] visited;
	
	public static int population = 0;
	public static int nationCnt = 0;
	
	public static void dfs(int[][] ground, int l, int r, int i, int j) {
		unionQueue.offer(new Location(i, j));
		
		population += ground[i][j];
		++nationCnt;
		
		for (int[] direction : directions) {
			int nextI = i + direction[0];
			int nextJ = j + direction[1];
			
			if ((nextI < 0) || (nextJ < 0) || (nextI == ground.length) || (nextJ == ground.length)) {
				continue;
			}
			
			if (visited[nextI][nextJ]) {
				continue;
			}
			
			int diff = Math.abs(ground[i][j] - ground[nextI][nextJ]);
			
			if ((l <= diff) && (diff <= r)) {
				visited[nextI][nextJ] = true;
				dfs(ground, l, r, nextI, nextJ);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] ground = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				ground[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		visited = new boolean[n][n];
		
		Queue<Integer> nationCntQueue = new LinkedList<>();
		Queue<Integer> avgQueue = new LinkedList<>();
		
		int answer = 0;
		
		while (true) {
			// 국경선 열어서 연합 만들고 연합 별 이동 인구 수 계산.
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						
						dfs(ground, l, r, i, j);
						
						nationCntQueue.offer(nationCnt);
						avgQueue.offer(population / nationCnt);
						
						population = 0;
						nationCnt = 0;
					}
				}
			}
			
			// 더 이상 인구 이동이 없을 경우
			if (nationCntQueue.size() == n * n) {
				break;
			}
			
			// 연합 별 인구 이동
			while (!nationCntQueue.isEmpty()) {
				int nationCnt = nationCntQueue.poll();
				int avg = avgQueue.poll();
				
				while (nationCnt-- > 0) {
					ground[unionQueue.peek().getR()][unionQueue.poll().getC()] = avg;
				}
			}
			
			++answer;
			
			for (boolean[] row : visited) {
				Arrays.fill(row, false);
			}
		}
		
		System.out.print(answer);
	}

}
