import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for (int i = 0; i < k; ++i) {
			int p = sc.nextInt();
			int m = sc.nextInt();
			
			boolean[] seats = new boolean[m];
			
			for (int j = 0; j < p; ++j) {
				seats[sc.nextInt() - 1] = true;
			}
			
			int cnt = 0;
			
			for (boolean seat : seats) {
				if (seat) {
					++cnt;
				}
			}
			
			System.out.println(p - cnt);
		}
		
		sc.close();
	}
	
}
