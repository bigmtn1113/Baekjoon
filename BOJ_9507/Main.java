import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		BigInteger[] dp = new BigInteger[68];
		
		dp[0] = dp[1] = BigInteger.ONE;
		dp[2] = new BigInteger("2");
		dp[3] = new BigInteger("4");
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			for (int j = 4; j <= n; ++j) {
				dp[j] = dp[j - 1].add(dp[j - 2]).add(dp[j - 3]).add(dp[j - 4]);
			}
			
			answer.append(dp[n]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
