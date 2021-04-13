import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] sum = new int[n + 1];
		
		sum[1] = sc.nextInt();
		
		for (int k = 2; k <= n; ++k) {
			sum[k] = sum[k - 1] + sc.nextInt();
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int k = 0; k < m; ++k) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			answer.append(sum[j] - sum[i - 1]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
