import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			
			for (int i = 2; i <= n; ++i) {
				if (dp[i] == null) {
					dp[i] = new BigInteger("0");
				}
				
				if (dp[i].compareTo(BigInteger.ZERO) == 0) {
					dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
				}
			}
			
			answer.append(dp[n]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
