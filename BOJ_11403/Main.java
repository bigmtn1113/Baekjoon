import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	
	public static void bfs(int vertex, int[][] result) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			for (int nextVertex : graph[currVertex]) {
				if (!visited[nextVertex]) {
					visited[nextVertex] = true;
					queue.offer(nextVertex);
					
					result[vertex][nextVertex] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		graph = new ArrayList[n];
		
		for (int i = 0; i < n; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (sc.nextInt() == 1) {
					graph[i].add(j);
				}
			}
		}
		
		sc.close();
		
		int[][] result = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			visited = new boolean[n];
			
			bfs(i, result);
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int[] i : result) {
			for (int j : i) {
				answer.append(j).append(" ");
			}
			
			answer.append("\n");
		}
		
		System.out.print(answer);
	}

}
