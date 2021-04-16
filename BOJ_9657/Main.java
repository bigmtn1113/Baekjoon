import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 1;
		
		for (int i = 5; i <= n; ++i) {
			dp[i] = 1 - Math.min(Math.min(dp[i - 1], dp[i - 3]), dp[i - 4]);
		}
		
		System.out.print((dp[n] == 1) ? "SK" : "CY");
	}

}
