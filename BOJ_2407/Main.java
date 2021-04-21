import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		
		if (m > n - m) {
			m = n - m;
		}
		
		BigInteger answer = BigInteger.ONE;
		int dividend = 1;
		
		while (m-- > 0) {
			answer = answer.multiply(BigInteger.valueOf(n--));
			answer = answer.divide(BigInteger.valueOf(dividend++));
		}
		
		System.out.print(answer);
	}

}
