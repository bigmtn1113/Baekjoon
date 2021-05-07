import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] people = new int[n];
		
		for (int i = 0; i < n; ++i) {
			people[i] = sc.nextInt();
		}
		
		sc.close();
		
		double answer = Double.MAX_VALUE;
		
		for (int i = 0; i <= n - k; ++i) {
			int tempK = k;
			
			for (int j = tempK; j <= n - i; ++j) {
				double avg = 0;
				double variance = 0;
				
				for (int t = i; t < i + j; ++t) {
					avg += people[t];
				}
				
				avg /= j;
				
				for (int t = i; t < i + j; ++t) {
					variance += (people[t] - avg) * (people[t] - avg);
				}
				
				variance /= j;
				
				answer = Math.min(answer, Math.sqrt(variance));
			}
		}
		
		System.out.format("%.6f", answer);
	}

}
