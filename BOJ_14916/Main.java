import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = n / 5; i >= 0; --i) {
			if ((n - (i * 5)) % 2 != 0) {
				continue;
			}
			
			cnt += i + ((n - (i * 5)) / 2);
			break;
		}
		
		System.out.print((cnt > 0) ? cnt : -1);
	}
	
}
