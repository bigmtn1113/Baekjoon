import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		boolean[] primeNumbers = new boolean[1000000];
		
		Arrays.fill(primeNumbers, true);
		
		for (int i = 2; i * i < 1000000; ++i) {
			if (primeNumbers[i]) {
				for (int j = i * i; j < 1000000; j += i) {
					primeNumbers[j] = false;
				}
			}
		}
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == 0) {
				break;
			}
			
			boolean isPossible = false;
			
			for (int i = 2; i < n; ++i) {
				if (primeNumbers[i] && primeNumbers[n - i]) {
					answer.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
					isPossible = true;
					
					break;
				}
			}
			
			if (!isPossible) {
				answer.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		
		System.out.print(answer);
	}

}
