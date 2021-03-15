import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		sc.close();
		
		System.out.println((a != b) ? Math.abs(b - a) - 1 : 0);
		
		if (a < b) {
			for (long i = a + 1; i < b; ++i) {
				System.out.print(i + " ");
			}
		} else {
			for (long i = b + 1; i < a; ++i) {
				System.out.print(i + " ");
			}
		}
	}
	
}
