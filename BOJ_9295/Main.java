import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 1; i <= t; ++i) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			System.out.println("Case " + i + ": " + (num1 + num2));
		}
		
		sc.close();
	}
	
}
