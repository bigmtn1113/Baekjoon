import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	private int vertex;
	private int distance;
	
	public Pair(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
	
	public int first() { return vertex; }
	public int second() { return distance; }
}

public class Main {
	static ArrayList<Pair>[] vertex = new ArrayList[100001];
	static boolean[] isVisit = new boolean[100001];
	static int n;
	static int farV, farD;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 트리를 탐색하기 위해 dfs나 bfs를 이용한다.
		// 시작 노드에서 다른 노드들을 방문할 때마다 거리를 더해가며 시작 노드와 다른 노드들까지의 거리를 계산한다.
		// 시작 노드에서 가장 먼 노드를 찾고 찾은 노드를 시작 노드로 설정한 뒤 다시 탐색하며 거리를 계산한다.
		
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; ++i)
			vertex[i] = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			
			while (st.hasMoreTokens()) {
				int adjacentV = Integer.parseInt(st.nextToken());
				if (adjacentV == -1) continue;
				
				vertex[v].add(new Pair(adjacentV, Integer.parseInt(st.nextToken())));
			}
		}
		br.close();
		
		for (int i = 1; i <= n; ++i) {
			Collections.sort(vertex[i], new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					return o1.first() - o2.first();
				}
			});
		}
		
		dfs(1, 0);	// 시작 노드를 지정하고 탐색
		//bfs(1, 0);
		Arrays.fill(isVisit, false);
		
		dfs(farV, 0);	// 시작 노드로부터 가장 먼 노드를 다시 시작 노드로 지정하고 탐색
		//bfs(farV, 0);
				
		bw.write(String.valueOf(farD));
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v, int d) {
		if (isVisit[v]) return;
		
		if (farD < d) {
			farV = v;
			farD = d;
		}
		
		isVisit[v] = true;
		for (Pair next : vertex[v])
			if (!isVisit[next.first()])
				dfs(next.first(), d + next.second());
	}
	
	static void bfs(int v, int d) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(v, d));
		isVisit[v] = true;
		
		Pair curr;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			int currV = curr.first();
			int currD = curr.second();
			
			if (farD < currD) {
				farV = currV;
				farD = currD;
			}
			
			for (Pair next : vertex[currV]) {
				int nextV = next.first();
				int nextD = next.second();
				
				if (isVisit[nextV]) continue;
				
				queue.offer(new Pair(nextV, currD + nextD));
				isVisit[nextV] = true;
			}
		}
	}
}
