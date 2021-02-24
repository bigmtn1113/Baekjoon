import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		if (m >= k) {
			cnt = k + (n - m);
		} else {
			if ((n - m) <= (n - k)) {
				cnt = m + (n - m);
			} else {
				cnt = m + (n - k);
			}
		}
		
		System.out.print(cnt);
	}
	
}
