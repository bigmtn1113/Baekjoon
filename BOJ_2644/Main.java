import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static ArrayList<Integer>[] vertexArray;
	public static int[] visited;
	
	public static void bfs(int startX, int finishY) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(startX);
		visited[startX] = 1;
		
		while (!queue.isEmpty()) {
			int currV = queue.poll();
			
			if (currV == finishY) {
				return;
			}
			
			for (int nextV : vertexArray[currV]) {
				if (visited[nextV] == 0) {
					visited[nextV] = visited[currV] + 1;
					queue.add(nextV);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		vertexArray = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			vertexArray[i] = new ArrayList<>();
		}
		
		int startX = sc.nextInt();
		int finishY = sc.nextInt();
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			
			vertexArray[vertex1].add(vertex2);
			vertexArray[vertex2].add(vertex1);
		}
		
		sc.close();
		
		visited = new int[n + 1];
		
		bfs(startX, finishY);
		
		System.out.print(visited[finishY] - 1);
	}

}
