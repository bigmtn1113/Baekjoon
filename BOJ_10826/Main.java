import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		BigInteger[] dp = new BigInteger[n + 2];
		
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		
		for (int i = 2; i <= n; ++i) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		
		System.out.print(dp[n]);
	}

}
