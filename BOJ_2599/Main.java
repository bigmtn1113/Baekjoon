import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		int answer = -10000000;
		
		for (int i = 0; i <= n - k; ++i) {
			int sum = 0;
			
			for (int j = i; j < i + k; ++j) {
				sum += array[j];
			}
			
			answer = Math.max(answer, sum);
		}
		
		System.out.print(answer);
	}

}
