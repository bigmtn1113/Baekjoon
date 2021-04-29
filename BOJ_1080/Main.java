import java.util.Scanner;

public class Main {
	
	public static boolean isAllSame(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a[0].length; ++j) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			char[] tempA = sc.next().toCharArray();
			
			for (int j = 0; j < m; ++j) {
				a[i][j] = tempA[j] - '0';
			}
		}
		
		for (int i = 0; i < n; ++i) {
			char[] tempB = sc.next().toCharArray();
			
			for (int j = 0; j < m; ++j) {
				b[i][j] = tempB[j] - '0';
			}
		}
		
		sc.close();
		
		if ((n < 3) || (m < 3)) {
			System.out.print((isAllSame(a, b)) ? 0 : -1);
			System.exit(0);
		}
		
		int answer = 0;
		
		for (int i = 0; i < n - 2; ++i) {
			for (int j = 0; j < m - 2; ++j) {
				if (a[i][j] != b[i][j]) {
					for (int k = 0; k < 3; ++k) {
						for (int l = 0; l < 3; ++l) {
							a[i + k][j + l] ^= 1;
						}
					}
					
					++answer;
				}
			}
		}
		
		System.out.print((isAllSame(a, b)) ? answer : -1);
	}

}
