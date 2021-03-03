import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int i = 1;
		
		while (true) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			
			if ((a == 0) && (b == 0) && (c == 0)) {
				break;
			}
			
			System.out.println("Triangle #" + i);
			
			if (a == -1) {
				if (b < c) {
					System.out.format("a = %.3f\n", Math.sqrt(c * c - b * b));
				} else {
					System.out.println("Impossible.");
				}
			} else if (b == -1) {
				if (a < c) {
					System.out.format("b = %.3f\n", Math.sqrt(c * c - a * a));
				} else {
					System.out.println("Impossible.");
				}
			} else {
				System.out.format("c = %.3f\n", Math.sqrt(a * a + b * b));
			}
			
			System.out.println();
			++i;
		}
		
		sc.close();
	}
	
}
