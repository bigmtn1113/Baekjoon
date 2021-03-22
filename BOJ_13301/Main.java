import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		if (n < 3) {
			System.out.print((n == 1) ? 4 : 6);
			System.exit(0);
		}
		
		long[] dp = new long[n + 1];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= n; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.print(dp[n] * 2 + (dp[n] + dp[n - 1]) * 2);
	}
	
}
