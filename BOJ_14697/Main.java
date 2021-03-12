import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		sc.close();
		
		for (int i = 0; i < n / a + 1; ++i) {
			int sum = i * a;
			
			for (int j = 0; j < n / b + 1; ++j) {
				sum += j * b;
				
				for (int k = 0; k < n / c + 1; ++k) {
					sum += k * c;
					
					if (sum == n) {
						System.out.print(1);
						System.exit(0);
					}
					
					if (sum > n) {
						sum -= k * c;
						break;
					}
					
					sum -= k * c;
				}
				
				if (sum > n) {
					sum -= j * b;
					break;
				}
				
				sum -= j * b;
			}
		}
		
		System.out.print(0);
	}
	
}
