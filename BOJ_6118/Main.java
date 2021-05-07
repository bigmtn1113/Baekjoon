import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] distance;
	public static int maxDistance = 0;
	
	public static void bfs(ArrayList<Integer>[] graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		while (!queue.isEmpty()) {
			int currBarn = queue.poll();
			
			for (int nextBarn : graph[currBarn]) {
				if (nextBarn == 1) {
					continue;
				}
				
				if (distance[nextBarn] == 0) {
					distance[nextBarn] = distance[currBarn] + 1;
					queue.offer(nextBarn);
					
					maxDistance = Math.max(maxDistance, distance[nextBarn]);
				}
			}
		}
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
			int ai = sc.nextInt();
			int bi = sc.nextInt();
			
			graph[ai].add(bi);
			graph[bi].add(ai);
		}
		
		sc.close();
		
		distance = new int[n + 1];
		
		bfs(graph);
		
		int minBarn = n;
		int cnt = 0;
		
		for (int i = 1; i <= n; ++i) {
			if (distance[i] == maxDistance) {
				minBarn = Math.min(minBarn, i);
				++cnt;
			}
		}
		
		System.out.format("%d %d %d", minBarn, maxDistance, cnt);
	}

}
