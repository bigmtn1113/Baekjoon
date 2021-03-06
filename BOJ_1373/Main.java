import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print(new BigInteger(sc.next(), 2).toString(8));
		
		sc.close();
	}
	
}
