import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		double[] array = new double[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextDouble();
		}
		
		sc.close();
		
		double[] dp = new double[n];
		
		dp[0] = array[0];
		
		double answer = 0;
		
		for (int i = 1; i < n; ++i) {
			dp[i] = Math.max(array[i], dp[i - 1] * array[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.format("%.3f", answer);
	}

}
