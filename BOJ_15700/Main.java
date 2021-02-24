import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long m = sc.nextLong();
		
		sc.close();
		
		System.out.print((m % 2 == 0) ? n * (m / 2) : n * (m / 2) + n / 2);
	}
	
}
