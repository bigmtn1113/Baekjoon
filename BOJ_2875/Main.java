import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = 0; i <= k; ++i) {
			if (((n - i) / 2 > 0) && ((m - (k - i)) > 0)) {
				cnt = Math.max(Math.min((n - i) / 2, m - (k - i)), cnt);
			}
		}
		
		System.out.print(cnt);
	}
	
}
