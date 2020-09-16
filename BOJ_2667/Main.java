import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	static boolean[][] map = new boolean[26][26];
	static boolean[][] isVisit = new boolean[26][26];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int cnt = 0;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < n; ++j)
				if (row.charAt(j) == '1')
					map[i][j] = true;
		}
		br.close();
		
		int[] houseCnt = new int[26 * 26];
		int complexCnt = 0;
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				if (map[i][j] && !isVisit[i][j]) {
					dfs(i, j);
					//bfs(i, j);
					
					houseCnt[complexCnt++] = cnt;
					cnt = 0;
				}
		
		Arrays.sort(houseCnt, 0, complexCnt);
		
		bw.write(complexCnt + "\n");
		for (int i = 0; i < complexCnt; ++i)
			bw.write(houseCnt[i] + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int currI, int currJ) {
		if (isVisit[currI][currJ]) return;
		
		isVisit[currI][currJ] = true;
		++cnt;
		
		for (int k = 0; k < 4; ++k) {
			int nextI = currI + direction[k][0];
			int nextJ = currJ + direction[k][1];
			
			if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > n - 1)
				continue;
			
			if (map[nextI][nextJ] && !isVisit[nextI][nextJ])
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
			++cnt;
			
			for (int k = 0; k < 4; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				
				if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > n - 1)
					continue;
				
				if (map[nextI][nextJ] && !isVisit[nextI][nextJ]) {
					queue.offer(new Pair(nextI, nextJ));
					isVisit[nextI][nextJ] = true;
				}
			}
		}
	}
	
}
