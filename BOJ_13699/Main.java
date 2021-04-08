import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		long[] dp = new long[36];
		
		dp[0] = 1;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 0, k = i - 1; j < i; ++j, --k) {
				dp[i] += dp[j] * dp[k];
			}
		}
		
		System.out.print(dp[n]);
	}

}
