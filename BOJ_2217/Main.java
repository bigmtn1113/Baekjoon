import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] ropes = new int[n];
		
		for (int i = 0; i < n; ++i) {
			ropes[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(ropes);
		
		int answer = 0;
		
		for (int i = 1; i <= n; ++i) {
			answer = Math.max(answer, ropes[n - i] * i);
		}
		
		System.out.print(answer);
	}
	
}
