import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			if (sc.nextInt() == 0) {
				++cnt;
			}
		}
		
		sc.close();
		
		System.out.print((cnt > n - cnt) ? "Junhee is not cute!" : "Junhee is cute!");
	}
	
}
