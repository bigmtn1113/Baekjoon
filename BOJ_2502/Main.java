import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[k + 1];
		
		int a = 0;
		int b = 0;
		
		label: for (int i = 1; ; ++i) {
			dp[1] = i;
			
			for (int j = i; ; ++j) {
				dp[2] = j;
				
				for (int day = 3; day <= d; ++day) {
					dp[day] = dp[day - 1] + dp[day - 2];
				}
				
				if (dp[d] > k) {
					break;
				}
				
				if (dp[d] == k) {
					a = i;
					b = j;
					break label;
				}
			}
		}
		
		sc.close();
		
		System.out.format("%d\n%d", a, b);
	}

}
