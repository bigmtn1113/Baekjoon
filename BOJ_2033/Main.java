import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		
		sc.close();
		
		if (n < 11) {
			System.out.format("%.0f", n);
			System.exit(0);
		}
		
		int digit = 2;
		
		while (true) {
			if ((int) Math.log10(n) + 1 >= digit) {
				n = Math.round(n / Math.pow(10, digit - 1)) * Math.pow(10, digit - 1);
				++digit;
			} else {
				break;
			}
		}
		
		System.out.format("%.0f", n);
	}
	
}
