import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger binaryNum = sc.nextBigInteger(2);
		
		sc.close();

		System.out.print(binaryNum.toString(8));
	}
	
}
