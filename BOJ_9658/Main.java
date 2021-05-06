import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] stones = {1, 3, 4};
		int[] dp = new int[1001];
		
		dp[0] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= n; ++i) {
			for (int stone : stones) {
				if (i >= stone) {
					dp[i] = (dp[i - stone] == 0) ? 1 : 0;
					
					if (dp[i] == 1) {
						break;
					}
				}
			}
		}
		
		sc.close();
		
		System.out.print((dp[n] == 1) ? "SK" : "CY");
	}

}
