import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger p = sc.nextBigInteger();
		int k = sc.nextInt();
		
		sc.close();
		
		String result = "GOOD";
		
		for (int i = 2; i < k; ++i) {
			if (p.mod(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0) {
				result = "BAD " + i;
				break;
			}
		}
		
		System.out.print(result);
	}
	
}
