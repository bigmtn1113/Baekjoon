import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int s = sc.nextInt();
			int n = sc.nextInt();
			
			int result = s;
			
			for (int i = 0; i < n; ++i) {
				int q = sc.nextInt();
				int p = sc.nextInt();
				
				result += q * p;
			}
			
			System.out.println(result);
			
			--t;
		}
		
		sc.close();
	}
	
}
