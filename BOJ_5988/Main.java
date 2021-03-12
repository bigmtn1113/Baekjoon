import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			System.out.println((sc.nextBigInteger().mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) ? "even" : "odd");
		}
		
		sc.close();
	}
	
}
