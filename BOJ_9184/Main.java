import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][][] dp = new int[21][21][21];
		
		for (int i = 0; i < 21; ++i) {
			for (int j = 0; j < 21; ++j) {
				for (int k = 0; k < 21; ++k) {
					if ((i <= 0) || (j <= 0) || (k <= 0)) {
						dp[i][j][k] = 1;
					} else if ((i < j) && (j < k)) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					} else {
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if ((a == -1) && (b == -1) && (c == -1)) {
				break;
			}
			
			answer.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			
			if ((a <= 0) || (b <= 0) || (c <= 0)) {
				answer.append("1");
			} else if ((a > 20) || (b > 20) || (c > 20)) {
				answer.append(dp[20][20][20]);
			} else {
				answer.append(dp[a][b][c]);
			}
			
			answer.append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
