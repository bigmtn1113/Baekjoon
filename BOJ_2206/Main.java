import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tuple {
	int i;
	int j;
	int wall;
	
	Tuple(int i, int j, int wall) {
		this.i = i;
		this.j = j;
		this.wall = wall;
	}
	
	int first() { return this.i; }
	int second() { return this.j; }
	int third() { return this.wall; }
}

public class Main {
	static boolean[][] map = new boolean[1001][1001];
	static int[][][] visit = new int[1001][1001][2];
	static int[][] direction = {{-1, 0}, {1 ,0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < m; ++j)
				if (row.charAt(j) == '1')
					map[i][j] = true;
		}
		br.close();
		
		bfs(0, 0);
		int[] wall = {visit[n - 1][m - 1][0], visit[n - 1][m - 1][1]};	// 벽을 부수지 않은 경우, 벽을 한번 부순 경우
		
		if (wall[0] == 0)	// 벽을 부숴도 갈 수 없는 경우 : 벽을 한번 부숴야만 갈 수 있는 경우
			bw.write(wall[1] == 0 ? "-1" : String.valueOf(wall[1]));
		else	// 부술 벽이 없는 경우 : 벽을 부수지 않아도 갈 수 있고 부숴도 갈 수 있는 경우
			bw.write(wall[1] == 0 ? String.valueOf(wall[0]) : String.valueOf(Math.min(wall[0], wall[1]))); 
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int i, int j) {
		Queue<Tuple> queue = new LinkedList<>();
		queue.offer(new Tuple(i, j, 0));
		visit[i][j][0] = 1;
		
		while (!queue.isEmpty()) {
			int currI = queue.peek().first();
			int currJ = queue.peek().second();
			int wall = queue.peek().third();
			queue.poll();
			
			for (int k = 0; k < 4; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				
				if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1 || visit[nextI][nextJ][wall] != 0)
					continue;
				
				if (!map[nextI][nextJ]) {
					queue.offer(new Tuple(nextI, nextJ, wall));
					visit[nextI][nextJ][wall] = visit[currI][currJ][wall] + 1;
				} else if(wall != 1) {	// 가야할 곳에 벽이 있는데 벽을 한번도 부수지 않은 경우
					queue.offer(new Tuple(nextI, nextJ, 1));
					visit[nextI][nextJ][1] = visit[currI][currJ][wall] + 1;
				}
			}
		}
	}
}
