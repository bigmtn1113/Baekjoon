import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int[] dp = new int[31];
		
		dp[0] = 1;		// 타일을 사용하지 않는 경우
		dp[2] = 3;
		
		for (int i = 4; i <= n; i += 2) {
			dp[i] = 3 * dp[i - 2];		// => dp[2] * dp[i - 2]
			
			for (int j = i - 4; j > 0; j -= 2) {
				dp[i] += 2 * dp[j];		// => 특수 케이스 * dp[i - 2]
			}
			
			dp[i] += 2;		// 특수 케이스 추가
		}
		
		System.out.print(dp[n]);
	}

}
