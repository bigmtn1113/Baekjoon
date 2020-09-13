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
	static ArrayList<Integer>[] vertex = new ArrayList[101];
	static boolean[] isVisit = new boolean[101];
	static int cnt = 0;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		int computer = Integer.parseInt(br.readLine());
		int connectedComputer = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= computer; ++i)
			vertex[i] = new ArrayList<>();
		
		for (int i = 0; i < connectedComputer; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			vertex[v1].add(v2);
			vertex[v2].add(v1);
		}
		br.close();
		
		for (int i = 1; i <= computer; ++i)
			Collections.sort(vertex[i]);
		
		dfs(1);
		//bfs(1);
		
        bw.write(String.valueOf(cnt - 1));
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