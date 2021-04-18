import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] dp = new int[n];
			dp[0] = sc.nextInt();
			
			int maxNum = dp[0];
			
			for (int j = 1; j < n; ++j) {
				int num = sc.nextInt();
				
				dp[j] = Math.max(dp[j - 1] + num, num);
				maxNum = Math.max(maxNum, dp[j]);
			}
			
			answer.append(maxNum).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
