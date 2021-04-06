import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] t = new int[n + 1];
		int[] p = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n + 1];
		
		int answer = dp[1] = p[1];
		
		if (t[1] > n) {
			answer = 0;
		}
		
		for (int i = 2; i <= n; ++i) {
			// N + 1일째에는 회사에 없으므로 패스
			if (i + t[i] > n + 1) {
				continue;
			}
			
			dp[i] = p[i];
			
			for (int j = 1; j < n; ++j) {
				if (j == i) {
					break;
				}
				
				if (t[i - j] <= j) {
					dp[i] = Math.max(dp[i], p[i] + dp[i - j]);
				}
			}
			
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(answer);
	}
	
}
