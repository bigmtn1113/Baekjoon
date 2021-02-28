import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int cnt = 1;
		
		while (true) {
			if (n == 1) {
				System.out.print(cnt);
				
				break;
			}
			
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			
			++cnt;
		}
	}
	
}
