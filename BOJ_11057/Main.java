import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[][] dp = new int[n + 1][10];
		
		for (int i = 0; i < 10; ++i) {
			dp[1][i] = 1;
		}
		
		int sum = 10;
		
		for (int i = 2; i <= n; ++i) {
			int temp = sum;
			sum = 0;
			
			for (int j = 0; j < 10; ++j) {
				dp[i][j] = temp % 10007;
				temp -= dp[i - 1][j];
				
				sum += dp[i][j];
			}
		}
		
		System.out.print(sum % 10007);
	}

}
