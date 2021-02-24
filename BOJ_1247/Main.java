import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; ++i) {
			int n = sc.nextInt();
			
			BigInteger sum = new BigInteger("0");
			
			while (n > 0) {
				sum = sum.add(new BigInteger(sc.next()));
				
				--n;
			}
			
			char result = ' ';
			
			if (sum.compareTo(new BigInteger("0")) == 0) {
				result = '0';
			} else if (sum.compareTo(new BigInteger("0")) > 0) {
				result = '+';
			} else {
				result = '-';
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}
	
}
