import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] vipSeats = new int[m];
		
		for (int i = 0; i < m; ++i) {
			vipSeats[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int answer = 1;
		int standardSeatBeginIndex = 1;
		
		for (int vipSeat : vipSeats) {
			answer *= dp[vipSeat - standardSeatBeginIndex];
			standardSeatBeginIndex = vipSeat + 1;
		}
		
		answer *= dp[n + 1 - standardSeatBeginIndex];
		
		System.out.print(answer);
	}

}
