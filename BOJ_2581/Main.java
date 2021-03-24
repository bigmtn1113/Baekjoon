import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		sc.close();
		
		if (m == 1) {
			++m;
		}
		
		int sum = 0;
		int minPrimeNum = 10000;
		
		for (int i = m; i <= n; ++i) {
			boolean isPrimeNum = true;
			
			for (int j = 2; j * j <= i; ++j) {
				if (i % j == 0) {
					isPrimeNum = false;
					break;
				}
			}
			
			if (isPrimeNum) {
				sum += i;
				minPrimeNum = Math.min(minPrimeNum, i);
			}
		}
		
		System.out.print((sum > 0) ? sum + "\n" + minPrimeNum : -1);
	}
	
}
