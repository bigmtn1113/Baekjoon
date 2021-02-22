import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger appleCnt = sc.nextBigInteger();
		BigInteger difference = sc.nextBigInteger();
		
		sc.close();
		
		System.out.println(appleCnt.add(difference).divide(new BigInteger("2")));
		System.out.print(appleCnt.subtract(difference).divide(new BigInteger("2")));
	}
	
}
