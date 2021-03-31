import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int k = sc.nextInt();
		
		for (int i = 1; i <= k; ++i) {
			int n = sc.nextInt();
			
			int[] scores = new int[n];
			
			for (int j = 0; j < n; ++j) {
				scores[j] = sc.nextInt();
			}
			
			Arrays.sort(scores);
			
			int maxGap = 0;
			
			for (int j = 1; j < n; ++j) {
				maxGap = Math.max(maxGap, scores[j] - scores[j - 1]);
			}
			
			answer.append("Class " + i + "\n");
			answer.append("Max " + scores[n - 1] + ", Min " + scores[0] + ", Largest gap " + maxGap + "\n");
		}
		
		sc.close();

		System.out.print(answer);
	}
	
}
