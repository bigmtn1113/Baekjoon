import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int i;
	int j;
	
	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	int first() { return i; }
	int second() { return j; }
}

public class Main {
	static boolean[][] field = new boolean[51][51];
	static boolean[][] isVisit = new boolean[51][51];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int m, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < k; ++j) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				field[row][col] = true;
			}
			
			int earthwormCnt = 0;
			for (int a = 0; a < n; ++a)
				for (int b = 0; b < m; ++b)
					if (field[a][b] && !isVisit[a][b]) {
						dfs(a, b);
						//bfs(a, b);
						
						++earthwormCnt;
					}
			
			bw.write(earthwormCnt + "\n");
			
			for (int a = 0; a < 51; ++a) {
				Arrays.fill(field[a], false);
				Arrays.fill(isVisit[a], false);
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int currI, int currJ) {
		if (isVisit[currI][currJ]) return;
		
		isVisit[currI][currJ] = true;
		
		for (int k = 0; k < 4; ++k) {
			int nextI = currI + direction[k][0];
			int nextJ = currJ + direction[k][1];
			
			if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1)
				continue;
			
			if (field[nextI][nextJ] && !isVisit[nextI][nextJ])
				dfs(nextI, nextJ);
		}
	}
	
	static void bfs(int currI, int currJ) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(currI, currJ));
		isVisit[currI][currJ] = true;
		
		while (!queue.isEmpty()) {
			currI = queue.peek().first();
			currJ = queue.peek().second();
			queue.poll();
			
			for (int k = 0; k < 4; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				
				if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1)
					continue;
				
				if (field[nextI][nextJ] && !isVisit[nextI][nextJ]) {
					queue.offer(new Pair(nextI, nextJ));
					isVisit[nextI][nextJ] = true;
				}
			}
		}
	}
	
}
