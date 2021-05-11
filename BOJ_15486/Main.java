// 14501번 퇴사 문제와 같으나, 범위가 훨씬 커서 브루트포스 알고리즘으로 문제를 해결할 수 없다.

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] t = new int[n + 2];
		int[] p = new int[n + 2];
		
		for (int i = 1; i <= n; ++i) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n + 2];
		
		int currMaxValue = 0;
		
		for (int i = 1; i <= n + 1; ++i) {
			currMaxValue = Math.max(currMaxValue, dp[i]);
			
			if (i + t[i] <= n + 1) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], currMaxValue + p[i]);
			}
		}
		
		System.out.print(dp[n + 1]);
	}

}
