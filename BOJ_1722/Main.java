import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		
		long[] factorialArray = new long[n + 1];
		
		Arrays.fill(factorialArray, 1);
		
		// factorialArray: 1, 1, 2, 6, 24, 120, ...
		for (int i = 2; i <= n; ++i) {
			for (int j = 2; j <= i; ++j) {
				factorialArray[i] *= j;
			}
		}
		
		if (num == 1) {
			long k = sc.nextLong();
			boolean[] check = new boolean[n + 1];
			
			int factorialArrayIdx = n - 1;
			
			for (int i = 1; i <= n; ++i, --factorialArrayIdx) {
				for (int j = 1; j <= n; ++j) {
					if (check[j]) {
						continue;
					}
					
					if (k > factorialArray[factorialArrayIdx]) {
						k -= factorialArray[factorialArrayIdx];
					} else {
						check[j] = true;
						answer.append(j).append(" ");
						break;
					}
				}
			}
		} else {
			int[] sequenceArray = new int[n + 1];
			boolean[] check = new boolean[n + 1];
			
			long result = 1;
			int factorialArrayIdx = n - 1;
			
			for (int i = 1; i <= n; ++i) {
				sequenceArray[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= n; ++i, --factorialArrayIdx) {
				for (int j = 1; j < sequenceArray[i]; ++j) {
					if (!check[j]) {
						result += factorialArray[factorialArrayIdx];
					}
				}
				
				check[sequenceArray[i]] = true;
			}
			
			answer.append(result);
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
