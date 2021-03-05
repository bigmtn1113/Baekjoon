import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			double sum = 0;
			
			sum += 350.34 * sc.nextDouble()
					+ 230.9 * sc.nextDouble()
					+ 190.55 * sc.nextDouble()
					+ 125.3 * sc.nextDouble()
					+ 180.9 * sc.nextDouble();
			
			System.out.format("$%.2f\n", sum);
		}
		
		sc.close();
	}
	
}
