import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		for (int i = 0; i < n - 1; ++i) {
			System.out.print(" ");
		}
		
		System.out.println("*");
		
		for (int i = 2; i < n; ++i) {
			for (int j = n; j > i; --j) {
				System.out.print(" ");
			}
			
			System.out.print("*");
			
			for (int j = 0; j < 2 * (i - 1) - 1; ++j) {
				System.out.print(" ");
			}
			
			System.out.println("*");
		}
		
		if (n > 1) {
			for (int i = 0; i < 2 * n - 1; ++i) {
				System.out.print("*");
			}
		}
	}
	
}
