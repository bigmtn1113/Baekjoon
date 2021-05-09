import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		sc.close();
		
		System.out.print((n % 2 == 1) ? "SK" : "CY");
	}

}
