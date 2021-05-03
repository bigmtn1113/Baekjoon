import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coinArray = new int[100];
		int[] dp = new int[100001];
		
		for (int i = 0; i < n; ++i) {
			coinArray[i] = sc.nextInt();
			dp[coinArray[i]] = 1;
		}
		
		for (int i = 1; i <= k; ++i) {
			if (dp[i] == 0) {
				dp[i] = 100000;
			}
		}
		
		sc.close();
		
		for (int i = 1; i <= k; ++i) {
			for (int coin : coinArray) {
				if (i - coin > 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		
		System.out.print((dp[k] < 100000) ? dp[k] : -1);
	}

}
