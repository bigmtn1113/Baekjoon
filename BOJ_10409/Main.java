import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			int input = sc.nextInt();
			
			t -= input;
			
			if (t < 0) {
				break;
			}
			
			++cnt;
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
