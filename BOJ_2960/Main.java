import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		boolean[] array = new boolean[n + 1];
		
		int cnt = 0;
		
		for (int i = 2; i <= n; ++i) {
			if (array[i]) {
				continue;
			}
			
			for (int j = i; j <= n; j += i) {
				if (array[j]) {
					continue;
				}
				
				array[j] = true;
				++cnt;
				
				if (cnt == k) {
					System.out.print(j);
					System.exit(0);
				}
			}
		}
	}
	
}
