import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int k1 = sc.nextInt();
		int n2 = sc.nextInt();
		int k2 = sc.nextInt();
		
		sc.close();
		
		System.out.print(n1 * k1 + n2 * k2);
	}
	
}
