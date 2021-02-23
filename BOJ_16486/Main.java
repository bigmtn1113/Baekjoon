import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		sc.close();
		
		System.out.format("%.6f", d2 * 2 * 3.141592 + d1 * 2);
	}
	
}
