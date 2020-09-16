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
	static boolean[][] maze = new boolean[101][101];
	static int[][] isVisit = new int[101][101];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*ex) 7 7
			1011111
			1110001
			1000001
			1000001
			1000001
			1000001
			1111111
			
			1 0 5 6 7 8 9
			2 3 4 0 0 0 10
			3 0 0 0 0 0 11
			4 0 0 0 0 0 12
			5 0 0 0 0 0 13
			6 0 0 0 0 0 14
			7 8 9 10 11 12 13
			
			맨 마지막은 이미 13이 되었기 때문에
			15가  되지 못한다.
		*/
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < m; ++j)
				if (row.charAt(j) == '1')
					maze[i][j] = true;
		}
		br.close();
		
		bfs(0, 0);
		
		bw.write(String.valueOf(isVisit[n - 1][m - 1]));
		bw.flush();
		bw.close();
	}
	
	static void bfs(int currI, int currJ) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(currI, currJ));
		isVisit[currI][currJ] = 1;
		
		while (!queue.isEmpty()) {
			currI = queue.peek().first();
			currJ = queue.peek().second();
			queue.poll();
			
			for (int k = 0; k < 4; ++k) {
				int nextI = currI + direction[k][0];
				int nextJ = currJ + direction[k][1];
				
				if (nextI < 0 || nextI > n - 1 || nextJ < 0 || nextJ > m - 1)
					continue;
				
				if (maze[nextI][nextJ] && isVisit[nextI][nextJ] == 0) {
					queue.offer(new Pair(nextI, nextJ));
					isVisit[nextI][nextJ] = isVisit[currI][currJ] + 1;	// 다음 방문할 정점은 현재 정점의 다음 칸이므로 현재 칸+1
				}
			}
		}
	}
	
}
