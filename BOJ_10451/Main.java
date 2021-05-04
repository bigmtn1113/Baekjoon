import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	
	public static boolean bfs(ArrayList<Integer>[] graph, int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		
		visited[vertex] = true;
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			for (int nextVertex : graph[currVertex]) {
				if (nextVertex == vertex) {
					return true;
				}
				
				visited[nextVertex] = true;
				queue.offer(nextVertex);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			ArrayList<Integer>[] graph = new ArrayList[n + 1];
			
			for (int j = 1; j <= n; ++j) {
				graph[j] = new ArrayList<>();
			}
			
			for (int j = 1; j <= n; ++j) {
				graph[j].add(sc.nextInt());
			}
			
			visited = new boolean[n + 1];
			
			int cnt = 0;
			
			for (int j = 1; j <= n; ++j) {
				if (visited[j]) {
					continue;
				}
				
				if (bfs(graph, j)) {
					++cnt;
				}
			}
			
			answer.append(cnt).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
