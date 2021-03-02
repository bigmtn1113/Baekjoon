import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		char operator = sc.next().charAt(0);
		BigInteger b = sc.nextBigInteger();
		
		sc.close();
		
		switch (operator) {
		case '*':
			System.out.print(a.multiply(b));
			break;

		default:
			System.out.print(a.add(b));
			break;
		}
	}
	
}
