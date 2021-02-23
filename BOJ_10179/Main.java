import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			double price = sc.nextDouble();
			
			System.out.format("$%.2f\n", price * 0.8);
		}
		
		sc.close();
	}
	
}
