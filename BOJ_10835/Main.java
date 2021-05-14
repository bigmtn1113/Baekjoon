import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] a = new int[2000];
	public static int[] b = new int[2000];
	public static int[][] dp = new int[2000][2000];
	
	public static int recursionFunc(int aIdx, int bIdx) {
		if ((aIdx == n) || (bIdx == n)) {
			return 0;
		}
		
		if (dp[aIdx][bIdx] != -1) {
			return dp[aIdx][bIdx];
		}
		
		if (a[aIdx] > b[bIdx]) {
			dp[aIdx][bIdx] = Math.max(dp[aIdx][bIdx], recursionFunc(aIdx, bIdx + 1) + b[bIdx]);
		} else {
			dp[aIdx][bIdx] = Math.max(recursionFunc(aIdx + 1, bIdx), recursionFunc(aIdx + 1, bIdx + 1));
		}
		
		return dp[aIdx][bIdx];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; ++i) {
			b[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int[] row : dp) {
			Arrays.fill(row, 0, n, -1);
		}
		
		System.out.print(recursionFunc(0, 0));
	}

}
