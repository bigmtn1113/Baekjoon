import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[n + 1];
		
		for (int i = 1; i * i <= n; ++i) {
			dp[i * i] = 1;
		}
		
		for (int i = 2; i <= n; ++i) {
			if (dp[i] > 0) {
				continue;
			}
			
			dp[i] = i;
			
			for (int j = 1; j <= i / 2; ++j) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
		}
		
		System.out.print(dp[n]);
	}

}
