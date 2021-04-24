import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[1000001];
		
		dp[0] = 0;
		dp[1] = 1;
		
		if (n >= 0) {
			for (int i = 2; i <= n; ++i) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
			}
		} else {
			n = Math.abs(n);
			
			for (int i = 2; i <= n; ++i) {
				if (dp[i - 2] - dp[i - 1] > 0) {
					dp[i] = (dp[i - 2] - dp[i - 1]) % 1000000000;
				} else {
					dp[i] = -(Math.abs(dp[i - 2] - dp[i - 1]) % 1000000000);
				}
			}
		}
		
		if (dp[n] > 0) {
			System.out.println(1);
		} else if (dp[n] == 0) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}
		
		System.out.print(Math.abs(dp[n]));
	}

}
