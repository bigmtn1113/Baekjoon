import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] vertex = new ArrayList[2501];
	static boolean[] isVisit = new boolean[2501];
	static int cnt = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int field[][] = new int[n][m];
			
			for (int j = 0; j < m * n; ++j)
				vertex[j] = new ArrayList<>();
			
			for (int j = 0; j < k; ++j) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				
				++field[row][col];
			}
			
			for (int j = 0; j < n; ++j) {
				for (int l = 0; l < m; ++l) {
					if (field[j][l] == 0) continue;
					int curr = j * m + l;
					
					if (j > 0 && field[j - 1][l] > 0) vertex[curr].add(curr - m);	// 위
					if (j < n - 1 && field[j + 1][l] > 0) vertex[curr].add(curr + m);	// 아래
					if (l > 0 && field[j][l - 1] > 0) vertex[curr].add(curr - 1);	// 왼
					if (l < m - 1 && field[j][l + 1] > 0) vertex[curr].add(curr + 1);	// 오
				}
			}
			
			int earthworm = 0;
			for (int j = 0; j < n; ++j) {
				for (int l = 0; l < m; ++l) {
					if (field[j][l] > 0 && !isVisit[j * m + l]) {
						dfs(j * m + l);
						//bfs(j * m + l);
						
						++earthworm;
						cnt = 0;
					}
				}
			}
			bw.write(earthworm + "\n");
			
			for (int j = 0; j < m * n; ++j)
				isVisit[j] = false;
		}
		
		bw.flush();
		bw.close();
	}

	static void dfs(int v) {
		if (isVisit[v]) return;
		
		isVisit[v] = true;
		++cnt;
		
		for (int i : vertex[v])
			if (!isVisit[i])
				dfs(i);
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		isVisit[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			++cnt;
			
			for (int i : vertex[curr])
				if (!isVisit[i]) {
					queue.offer(i);
					isVisit[i] = true;
				}
		}
	}
}
