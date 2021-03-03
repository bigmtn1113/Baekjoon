import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int sum = 0;
		
		for (int i = 1; i * i <= n; ++i) {
			if (n % i == 0) {
				sum += i + n / i;
				
				if (i * i == n) {
					sum -= i;
				}
			}
		}
		
		System.out.print(sum * 5 - 24);
	}
	
}
