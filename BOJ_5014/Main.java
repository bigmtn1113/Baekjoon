import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int f = sc.nextInt();
		int s = sc.nextInt();
		int g = sc.nextInt();
		int u = sc.nextInt();
		int d = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[1000001];
		
		Arrays.fill(dp, 1234567890);
		
		dp[s] = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			if ((curr + u <= f) && (dp[curr] + 1 < dp[curr + u])) {
				dp[curr + u] = dp[curr] + 1;
				queue.offer(curr + u);
			}
			
			if ((curr - d > 0) && (dp[curr] + 1 < dp[curr - d])) {
				dp[curr - d] = dp[curr] + 1;
				queue.offer(curr - d);
			}
		}
		
		System.out.print((dp[g] != 1234567890) ? dp[g] : "use the stairs");
	}

}
