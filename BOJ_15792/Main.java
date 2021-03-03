import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		System.out.print(BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 1000, BigDecimal.ROUND_HALF_UP));
	}
	
}
