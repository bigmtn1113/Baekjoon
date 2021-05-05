import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[45];		// 45부터는 값이 10억을 넘어가므로 45까지 제한.
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < 45; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int t = sc.nextInt();
		
		StringBuilder answer =  new StringBuilder();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			Stack<Integer> stack = new Stack<>();
			
			for (int j = 44; j > 0; --j) {
				if (dp[j] <= n) {
					stack.push(dp[j]);
					n -= dp[j];
				}
			}
			
			while (!stack.isEmpty()) {
				answer.append(stack.pop()).append(" ");
			}
			
			answer.append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
