import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] inputArray = new int[n];
		
		int sum = 0;
		
		for (int i = 0; i < n; ++i) {
			inputArray[i] = sc.nextInt();
			
			sum += inputArray[i];
		}
		
		sc.close();
		
		long answer = 0;
		
		for (int i = 0; i < n - 1; ++i) {
			sum -= inputArray[i];
			answer += (long) inputArray[i] * sum;
		}
		
		System.out.print(answer);
	}

}
