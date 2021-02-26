import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int c = sc.nextInt();
			
			int[] coinTypes = {25, 10, 5, 1};
			
			for (int coinType : coinTypes) {
				System.out.print(c / coinType + " ");
				
				c %= coinType;
			}
			
			System.out.println();
			
			--t;
		}
		
		sc.close();
	}
	
}
