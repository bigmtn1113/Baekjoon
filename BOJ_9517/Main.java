import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int timeLimit = 210;
		
		for (int i = 0; i < n; ++i) {
			int t = sc.nextInt();
			char z = sc.next().charAt(0);
			
			timeLimit -= t;
			
			if (timeLimit <= 0) {
				break;
			}
			
			if (z != 'T') {
				continue;
			}
			
			k = ((k + 1) > 8) ? k - 7 : k + 1;
		}
		
		sc.close();
		
		System.out.print(k);
	}
	
}
