import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int[][] grid = new int[m][n];
			
			for (int j = 0; j < m; ++j) {
				for (int k = 0; k < n; ++k) {
					grid[j][k] = sc.nextInt();
				}
			}
			
			boolean canMove = true;
			int moveCnt = 0;
			
			while (canMove) {
				canMove = false;
				
				for (int j = 1; j < m; ++j) {
					for (int k = 0; k < n; ++k) {
						if ((grid[j][k] == 0) && (grid[j - 1][k] == 1)) {
							grid[j][k] = 1;
							grid[j - 1][k] = 0;
							
							++moveCnt;
							canMove = true;
						}
					}
				}
			}
			
			System.out.println(moveCnt);
		}
		
		sc.close();
	}
	
}
