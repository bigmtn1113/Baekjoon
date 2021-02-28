import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long remainder = 1;
		
		for (int i = 0; i < n; ++i) {
			int a = sc.nextInt();
			
			remainder *= a % m;
			remainder %= m;
		}
		
		sc.close();
		
		System.out.print(remainder);
	}
	
}
