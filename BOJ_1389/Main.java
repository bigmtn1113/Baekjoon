import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] visited;
	
	public static int bfs(ArrayList<Integer>[] graph, int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		
		int sum = 0;
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			for (int nextVertex : graph[currVertex]) {
				if ((nextVertex != vertex) && (visited[nextVertex] == 0)) {
					sum += visited[nextVertex] = visited[currVertex] + 1;
					queue.offer(nextVertex);
				}
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; ++i) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			graph[vertex1].add(vertex2);
			graph[vertex2].add(vertex1);
		}
		
		sc.close();
		
		int minStep = 5000;
		int answer = 0;
		
		for (int i = 1; i <= n; ++i) {
			visited = new int[n + 1];
			
			int result = bfs(graph, i);
			
			if (minStep > result) {
				minStep = result;
				answer = i;
			}
		}
		
		System.out.print(answer);
	}

}
