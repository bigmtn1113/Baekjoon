import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] vertex = new ArrayList[10001];
	static boolean[] isVisit = new boolean[10001];
	static int[] cellCnt = new int[10001];

	public static void main(String[] args) throws IOException{
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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n * m; ++i)
			vertex[i] = new ArrayList<>();
		
		int[][] maze = new int[n][m];
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < m; ++j)
				maze[i][j] = row.charAt(j) - '0';
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (maze[i][j] == 0) continue;
				int curr = i * m + j;
				
				if (i > 0 && maze[i - 1][j] > 0) vertex[curr].add(curr - m);	// 위
				if (i < n - 1 && maze[i + 1][j] > 0) vertex[curr].add(curr + m);	// 아래
				if (j > 0 && maze[i][j - 1] > 0) vertex[curr].add(curr - 1);	// 왼
				if (j < m - 1 && maze[i][j + 1] > 0) vertex[curr].add(curr + 1);	// 오
			}
		}
		
		for (int i = 0; i < n * m; ++i)
			Collections.sort(vertex[i]);
		
		bfs(0);	// 첫 정점을 1이 아니라 0으로 설정
		
		bw.write(String.valueOf(cellCnt[n * m - 1] + 1));	// 첫 정점의 칸 수가 0이라 +1
		bw.flush();
		bw.close();
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		isVisit[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int next : vertex[curr])
				if (!isVisit[next]) {
					queue.offer(next);
					cellCnt[next] = cellCnt[curr] + 1;	// 다음 방문할 정점은 현재 정점의 다음 칸이므로 현재 칸+1
					isVisit[next] = true;
				}
		}
	}
}
