import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] p = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			p[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n + 1];
		
		dp[1] = p[1];
		
		for (int i = 2; i <= n; ++i) {
			dp[i] = p[i];
			
			for (int j = 1; (j <= i) && (j <= n); ++j) {
				dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
			}
		}
		
		System.out.print(dp[n]);
	}

}
