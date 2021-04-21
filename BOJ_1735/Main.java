import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		
		sc.close();
		
		int tempB1 = b1;
		int tempB2 = b2;
		
		while (tempB2 > 0) {
			int temp = tempB1;
			tempB1 = tempB2;
			tempB2 = temp % tempB2;
		}
		
		int denominator = b1 * b2 / tempB1;
		int numerator = (a1 * (denominator / b1)) + (a2 * (denominator / b2));
		
		int tempDenominator = denominator;
		int tempNumerator = numerator;
		
		while (tempNumerator > 0) {
			int temp = tempDenominator;
			tempDenominator = tempNumerator;
			tempNumerator = temp % tempNumerator;
		}
		
		System.out.format("%d %d", numerator / tempDenominator, denominator / tempDenominator);
	}

}
