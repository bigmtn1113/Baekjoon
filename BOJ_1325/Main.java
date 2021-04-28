import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static int[] pcCntArray;
	public static int maxPcCnt = 0;
	
	public static void dfs(int vertex) {
		visited[vertex] = true;
		
		for (int nextVertex : graph[vertex]) {
			if (!visited[nextVertex]) {
				++pcCntArray[nextVertex];
				maxPcCnt = Math.max(maxPcCnt, pcCntArray[nextVertex]);
				
				dfs(nextVertex);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			
			graph[vertex1].add(vertex2);
		}
		
		br.close();
		
		pcCntArray = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			visited = new boolean[n + 1];
			dfs(i);
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 1; i <= n; ++i) {
			if (pcCntArray[i] == maxPcCnt) {
				answer.append(i).append(" ");
			}
		}
		
		System.out.print(answer);
	}

}
