import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coinArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			coinArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[k + 1];
		
		dp[0] = 1;
		
		for (int i = 0; i < n; ++i) {
			for (int j = coinArray[i]; j <= k; ++j) {
				dp[j] += dp[j - coinArray[i]];
			}
		}
		
		System.out.print(dp[k]);
	}

}
