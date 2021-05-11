import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] distance;
	
	public static int bfs(ArrayList<Integer>[] graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		int answer = 0;
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			if (currVertex == 2) {
				continue;
			}
			
			for (int nextVertex : graph[currVertex]) {
				if ((nextVertex != 1) && (distance[nextVertex] == 0)) {
					distance[nextVertex] = distance[currVertex] + 1;
					
					if (distance[nextVertex] < 3) {
						++answer;
						queue.offer(nextVertex);
					}
				}
			}
		}
		
		return answer;
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
		
		distance = new int[n + 1];
		
		System.out.print(bfs(graph));
	}

}
