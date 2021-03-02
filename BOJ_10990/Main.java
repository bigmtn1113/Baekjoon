import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		for (int i = 1; i <= n; ++i) {
			for (int j = n - i; j > 0; --j) {
				System.out.print(" ");
			}
			
			System.out.print("*");
			
			for (int j = 0; j < 2 * (i - 1) - 1; ++j) {
				System.out.print(" ");
			}
			
			if (i > 1) {
				System.out.println("*");
			} else {
				System.out.println();
			}
		}
	}
	
}
