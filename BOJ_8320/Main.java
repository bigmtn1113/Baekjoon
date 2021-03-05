import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = n;
		
		for (int i = 2; i <= n; ++i) {
			for (int j = i; i * j <= n; ++j) {
				++cnt;
			}
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
