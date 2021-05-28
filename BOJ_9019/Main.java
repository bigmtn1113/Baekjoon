import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static String[] command = new String[10000];
	public static boolean[] visited = new boolean[10000];
	
	public static String bfs(int a, int b) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(a);
		
		Arrays.fill(command, "");
		Arrays.fill(visited, false);
		
		visited[a] = true;
		
		int[] nextA = new int[4];
		char[] nextCommand = {'D', 'S', 'L', 'R'};
		
		while (!queue.isEmpty()) {
			int currA = queue.poll();
			
			nextA[0] = currA * 2 % 10000;
			nextA[1] = (currA != 0) ? currA - 1 : 9999;
			nextA[2] = currA % 1000 * 10 + currA / 1000;
			nextA[3] = currA % 10 * 1000 + currA / 10;
			
			for (int i = 0; i < 4; ++i) {
				if (nextA[i] == b) {
					return command[currA] + nextCommand[i];
				}
				
				if (!visited[nextA[i]]) {
					visited[nextA[i]] = true;
					command[nextA[i]] = command[currA] + nextCommand[i];
					
					queue.offer(nextA[i]);
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			answer.append(bfs(a, b)).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
