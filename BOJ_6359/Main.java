import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			boolean[] prison = new boolean[n + 1];
			
			for (int j = 1; j <= n; ++j) {
				if (j % 2 == 0) {
					prison[j] = false;
				} else {
					prison[j] = true;
				}
			}
			
			for (int j = 3; j <= n; ++j) {
				for (int k = 1; k <= n; ++k) {
					if (k % j == 0) {
						if (prison[k]) {
							prison[k] = false;
						} else {
							prison[k] = true;
						}
					}
				}
			}
			
			int cnt = 0;
			
			for (boolean isOpened : prison) {
				if (isOpened) {
					++cnt;
				}
			}
			
			System.out.println(cnt);
		}
		
		sc.close();
	}
	
}
