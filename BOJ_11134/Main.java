import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			
			System.out.println((n % c == 0) ? n / c : n / c + 1);
			
			--t;
		}
		
		sc.close();
	}
	
}
