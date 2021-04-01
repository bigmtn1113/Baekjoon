import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Integer[] seedlings = new Integer[n];
		
		for (int i = 0; i < n; ++i) {
			seedlings[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(seedlings, Collections.reverseOrder());
		
		int cnt = n;
		int maxSeedling = 0;
		
		for (int i = 0; i < n; ++i) {
			seedlings[i] -= n - i;
			maxSeedling = Math.max(maxSeedling, seedlings[i]);
		}
		
		System.out.print(cnt + maxSeedling + 2);
	}
	
}
