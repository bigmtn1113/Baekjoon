import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] aArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			aArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] dp = new int[n];
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			dp[i] = aArray[i];
			
			for (int j = 0; j < i; ++j) {
				if ((aArray[j] < aArray[i]) && (dp[j] + aArray[i] > dp[i])) {
					dp[i] = dp[j] + aArray[i];
				}
			}
			
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(answer);
	}

}
