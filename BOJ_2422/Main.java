import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[][] combinations = new boolean[n + 1][n + 1]; 
		
		for (int i = 0; i < m; ++i) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			combinations[num1][num2] = combinations[num2][num1] = true;
		}
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = i + 1; j <= n; ++j) {
				if (combinations[i][j]) {
					continue;
				}
				
				for (int k = j + 1; k <= n; ++k) {
					if (combinations[i][k] || combinations[j][k]) {
						continue;
					}
					
					++cnt;
				}
			}
		}
		
		System.out.print(cnt);
	}
	
}
