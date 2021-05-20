import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] distanceArray;
	
	public static int bfs(ArrayList<Integer>[] graph, int i, int cnt) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			if (distanceArray[curr] == 2) {
				continue;
			}
			
			for (int next : graph[curr]) {
				if ((distanceArray[next] == 0) && (next != i)) {
					distanceArray[next] = distanceArray[curr] + 1;
					
					if ((distanceArray[next] == 1) || (distanceArray[next] == 2)) {
						++cnt;
						queue.offer(next);
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer>[] graph = new ArrayList[n];
		
		for (int i = 0; i < n; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; ++i) {
			char[] input = sc.next().toCharArray();
			
			for (int j = 0; j < n; ++j) {
				if (input[j] == 'Y') {
					graph[i].add(j);
				}
			}
		}
		
		sc.close();
		
		distanceArray = new int[n];
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			answer = Math.max(answer, bfs(graph, i, 0));
			
			Arrays.fill(distanceArray, 0);
		}
		
		System.out.print(answer);
	}

}
