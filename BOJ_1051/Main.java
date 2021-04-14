import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		char[][] input = new char[n][m];
		
		for (int i = 0; i < n; ++i) {
			String s = sc.next();
			
			for (int j = 0; j < m; ++j) {
				input[i][j] = s.charAt(j);
			}
		}
		
		sc.close();
		
		int sideOfSquare = Math.min(n, m);
		
		for (int i = sideOfSquare; i > 1; --i) {
			for (int j = 0; j <= n - i; ++j) {
				for (int k = 0; k <= m - i; ++k) {
					if ((input[j][k] == input[j][k + i - 1]) && (input[j][k] == input[j + i - 1][k])
							&& (input[j][k] == input[j + i - 1][k + i - 1])) {
						System.out.print(i * i);
						System.exit(0);
					}
				}
			}
		}
		
		System.out.print(1);
	}

}
