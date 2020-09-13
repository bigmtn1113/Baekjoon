import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<Integer>[] vertex = new ArrayList[26 * 26];
	static boolean[] isVisit = new boolean[26 * 26];
	static int cnt = 0;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		
		for (int i = 0; i < n * n; ++i)
			vertex[i] = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			String row = br.readLine();
			
			for (int j = 0; j < n; ++j)
				map[i][j] = row.charAt(j) - '0';
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j] == 0) continue;
				int curr = i * n + j;
				
				if (i > 0 && map[i - 1][j] > 0) vertex[curr].add(curr - n);	// À§
				if (i < n - 1 && map[i + 1][j] > 0) vertex[curr].add(curr + n);	// ¾Æ·¡
				if (j > 0 && map[i][j - 1] > 0) vertex[curr].add(curr - 1);	// ¿Þ
				if (j < n - 1 && map[i][j + 1] > 0) vertex[curr].add(curr + 1);	// ¿À
			}
		}
		br.close();
		
		int[] houseCnt = new int[26 * 26];
		int complexCnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j] > 0 && !isVisit[i * n + j]) {
					dfs(i * n + j);
					//bfs(i * n + j);
					
					houseCnt[complexCnt++] = cnt;
					cnt = 0;
				}
			}
		}
		
		Arrays.sort(houseCnt, 0, complexCnt);
		
		bw.write(complexCnt + "\n");
		for (int i = 0; i < complexCnt; ++i)
			bw.write(houseCnt[i] + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v) throws IOException {
		if (isVisit[v]) return;
		
		isVisit[v] = true;
		++cnt;
		
		for (int i : vertex[v])
			if (!isVisit[i])
				dfs(i);
	}
	
	static void bfs(int v) throws IOException{		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		isVisit[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			++cnt;
			
			for (int i : vertex[curr]) {
				if (!isVisit[i]) {
					queue.offer(i);
					isVisit[i] = true;
				}
			}
		}
	}
}