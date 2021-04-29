import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[] graph;
	public static int distanceArray[];
	
	public static void bfs(int vertex, int k, ArrayList<Integer> result) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			
			for (int nextVertex : graph[currVertex]) {
				if ((distanceArray[nextVertex] == 0) && (nextVertex != vertex)) {
					distanceArray[nextVertex] = distanceArray[currVertex] + 1;
					queue.offer(nextVertex);
					
					if (distanceArray[nextVertex] == k) {
						result.add(nextVertex);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		graph = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; ++i) {
			graph[sc.nextInt()].add(sc.nextInt());
		}
		
		sc.close();
		
		distanceArray = new int[n + 1];
		ArrayList<Integer> result = new ArrayList<>();
		
		bfs(x, k, result);
		
		Collections.sort(result);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i : result) {
			answer.append(i).append("\n");
		}
		
		System.out.print((answer.length() > 0) ? answer : -1);
	}

}
