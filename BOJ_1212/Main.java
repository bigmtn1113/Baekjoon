import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		BigInteger input = new BigInteger(sc.next(), 8);
		
		sc.close();
		
		System.out.print(input.toString(2));
	}
	
}
