import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	
	public static void bfs(ArrayList<Integer>[] graphListArray, int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[vertex] = true;
		queue.add(vertex);
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			for (int nextVertex : graphListArray[currVertex]) {
				if (!visited[nextVertex]) {
					visited[nextVertex] = true;
					queue.add(nextVertex);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer>[] graphListArray = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			graphListArray[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; ++i) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			graphListArray[vertex1].add(vertex2);
			graphListArray[vertex2].add(vertex1);
		}
		
		sc.close();
		
		visited = new boolean[n + 1];
		
		int answer = 0;
		
		for (int i = 1; i <= n; ++i) {
			if (!visited[i]) {
				bfs(graphListArray, i);
				
				++answer;
			}
		}
		
		System.out.print(answer);
	}

}
