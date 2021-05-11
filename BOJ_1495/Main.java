import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		int[] v = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			v[i] = sc.nextInt();
		}
		
		sc.close();
		
		boolean[][] dp = new boolean[n + 1][m + 1];		// dp[i][j]: i번째 노래를 j의 볼륨으로 연주할 수 있는가
		
		dp[0][s] = true;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				if (!dp[i - 1][j]) {
					continue;
				}
				
				if (j - v[i] >= 0) {
					dp[i][j - v[i]] = true;
				}
				
				if (j + v[i] <= m) {
					dp[i][j + v[i]] = true;
				}
			}
		}
		
		int answer = -1;
		
		for (int i = m; i >= 0; --i) {	
			if (dp[n][i]) {
				answer = i;
				break;
			}
		}
		
		System.out.print(answer);
	}

}
