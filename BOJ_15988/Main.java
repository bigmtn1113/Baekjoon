import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		int[] dp = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 4; j <= n; ++j) {
				dp[j] = (int) (((long) dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009);
			}
			
			answer.append(dp[n]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
