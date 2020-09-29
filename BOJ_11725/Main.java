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
	static ArrayList<Integer>[] vertex = new ArrayList[100001];
	static boolean[] isVisit = new boolean[100001];
	static int[] parentVertex = new int[100001];
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 트리를 탐색하기 위해 bfs를 이용한다.
		// 부모 노드에서 자식 노드로 탐색을 진행할 때 부모 노드를 기억해두면 된다.
		
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; ++i)
			vertex[i] = new ArrayList<>();
		
		for (int i = 1; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			vertex[v1].add(v2);
			vertex[v2].add(v1);
		}
		br.close();
		
		for (int i = 1; i <= n; ++i)
			Collections.sort(vertex[i]);
		
		bfs(1);
		
		for (int i = 2; i <= n; ++i)
			bw.write(parentVertex[i] + "\n");
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		isVisit[v] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int i : vertex[curr]) {
				if (!isVisit[i]) {
					parentVertex[i] = curr;
					queue.offer(i);
					isVisit[i] = true;
				}
			}
		}
	}
	
}
