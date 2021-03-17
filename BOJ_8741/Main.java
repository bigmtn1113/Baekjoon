import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		sc.close();
		
		BigInteger bi = BigInteger.valueOf(2).pow(k);
		
		System.out.print(bi.multiply(bi.divide(BigInteger.valueOf(2)).subtract(BigInteger.ONE)).add(bi.divide(BigInteger.valueOf(2))).toString(2));
	}
	
}
