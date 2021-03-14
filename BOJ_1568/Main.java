import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = 1; ; ++i) {
			if (n < i) {
				i = 0;
				continue;
			}
			
			n -= i;
			++cnt;
			
			if (n == 0) {
				break;
			}
		}
		
		System.out.print(cnt);
	}
	
}
