import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		
		sc.close();
		
		BigInteger quotient = a.divide(b);
		BigInteger remainder;
		
		if ((a.compareTo(new BigInteger("0")) < 0) && (b.compareTo(new BigInteger("0")) < 0)) {
			quotient = quotient.add(new BigInteger("1"));
			remainder = a.mod(b.multiply(new BigInteger("-1")));
		} else if (a.compareTo(new BigInteger("0")) < 0) {
			quotient = quotient.subtract(new BigInteger("1"));
			remainder = a.mod(b);
		} else {
			remainder = a.remainder(b);
		} 
		
		System.out.print(quotient + "\n" + remainder);
	}
	
}
