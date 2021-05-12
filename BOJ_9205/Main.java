import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	private int r;
	private int c;
	
	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
}

public class Main {
	
	public static boolean bfs(ArrayList<Integer>[] graph, Location[] locationArray) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int currGraphIndex = queue.poll();
			
			if (currGraphIndex == graph.length - 1) {
				return true;
			}
			
			for (int nextGraphIndex : graph[currGraphIndex]) {
				if (!visited[nextGraphIndex]) {
					visited[nextGraphIndex] = true;
					queue.offer(nextGraphIndex);
				}
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
			
			Location[] locationArray = new Location[n + 2];
			
			for (int j = 0; j < n + 2; ++j) {
				locationArray[j] = new Location(sc.nextInt(), sc.nextInt());
			}
			
			ArrayList<Integer>[] graph = new ArrayList[n + 2];
			
			for (int j = 0; j < n + 2; ++j) {
				graph[j] = new ArrayList<>();
			}
			
			for (int j = 0; j < n + 1; ++j) {
				for (int k = j + 1; k < n + 2; ++k) {
					int manhattanDistance = Math.abs(locationArray[j].getR() - locationArray[k].getR())
							+ Math.abs(locationArray[j].getC() - locationArray[k].getC());
					
					if (manhattanDistance <= 1000) {
						graph[j].add(k);
						graph[k].add(j);
					}
				}
			}
			
			answer.append((bfs(graph, locationArray)) ? "happy" : "sad").append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
