import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger num1 = new BigInteger(sc.next(), 2);
		BigInteger num2 = new BigInteger(sc.next(), 2);
		
		sc.close();
		
		System.out.print(num1.add(num2).toString(2));
	}
	
}
