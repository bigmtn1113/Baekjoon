import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int minPackagePrice = 1000;
		int minUnitPrice = 1000;
		
		for (int i = 0; i < m; ++i) {
			minPackagePrice = Math.min(minPackagePrice, sc.nextInt());
			minUnitPrice = Math.min(minUnitPrice, sc.nextInt());
		}
		
		sc.close();
		
		int answer = 0;
		
		if ((double) minPackagePrice / 6 < minUnitPrice) {
			answer = n / 6 * minPackagePrice;
			
			answer += Math.min(minPackagePrice, n % 6 * minUnitPrice);
		} else {
			answer = minUnitPrice * n;
		}
		
		System.out.print(answer);
	}

}
