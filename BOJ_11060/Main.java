import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n];
		
		dp[0] = 0;
		
		for (int i = 1; i < n; ++i) {
			dp[i] = 1000;
			
			for (int j = i - 1; j >= 0; --j) {
				if (array[j] >= i - j) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		
		System.out.print((dp[n - 1] < 1000) ? dp[n - 1] : -1);
	}

}
