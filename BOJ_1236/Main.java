import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		char[][] castle = new char[n][m];
		
		for (int i = 0; i < n; ++i) {
			String input = sc.next();
			
			for (int j = 0; j < m; ++j) {
				castle[i][j] = input.charAt(j);
			}
		}
		
		sc.close();
		
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (castle[i][j] == 'X') {
					++row;
					break;
				}
			}
		}
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (castle[j][i] == 'X') {
					++col;
					break;
				}
			}
		}
		
		System.out.print(Math.max(n - row, m - col));
	}
	
}
