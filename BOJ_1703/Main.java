import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int a = sc.nextInt();
			
			if (a == 0) {
				break;
			}
			
			BigInteger leafCnt = BigInteger.ONE;
			
			for (int i = 0; i < a; ++i) {
				int splittingFactor = sc.nextInt();
				int pruningCnt = sc.nextInt();
				
				leafCnt = leafCnt.multiply(BigInteger.valueOf(splittingFactor)).subtract(BigInteger.valueOf(pruningCnt));
			}
			
			System.out.println(leafCnt);
		}
		
		sc.close();
	}
	
}
