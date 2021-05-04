import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[][] dp = new int[n + 1][3];
		
		dp[1][0] = 1;	// 1번째 줄에 사자가 없는 경우
		dp[1][1] = 1;	// 1번째 줄 왼쪽에 사자가 있는 경우
		dp[1][2] = 1;	// 1번째 줄 오른쪽에 사자가 있는 경우
		
		for (int i = 2; i <= n; ++i) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
		
		System.out.print((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
	}

}
