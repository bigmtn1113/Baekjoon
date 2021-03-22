import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == -1) {
				break;
			}
			
			boolean[] divisors = new boolean[n + 1];
			int sum = -n;
			
			for (int i = 1; i * i <= n; ++i) {
				if (n % i == 0) {
					divisors[i] = true;
					divisors[n / i] = true;
					
					sum += (n / i) + i;
				}
			}
			
			if (sum == n) {
				int lastDivisor = 0;
				
				for (int i = n - 1; i >= 0; --i) {
					if (divisors[i]) {
						lastDivisor = i;
						break;
					}
				}
				
				System.out.print(n + " = ");
				
				for (int i = 1; i < n; ++i) {
					if (i == lastDivisor) {
						System.out.print(i);
						break;
					}
					
					if (n % i == 0) {
						System.out.print(i + " + ");
					}
				}
				
				System.out.println();
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
		
		sc.close();
	}
	
}
