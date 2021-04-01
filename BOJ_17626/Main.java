import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int dp[] = new int[n + 1];
		
		dp[1] = 1;
		
		for (int i = 2; i <= n; ++i) {
			dp[i] = dp[i - 1] + 1;
			
			// 제곱 수들(1^2, 2^2, 3^2, ...)을 빼면서 최솟값 찾기
			for (int j = 2; j * j <= i; ++j) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		
		System.out.print(dp[n]);
	}
	
}
