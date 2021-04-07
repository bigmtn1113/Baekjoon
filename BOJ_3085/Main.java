import java.util.Scanner;

public class Main {
	
	public static void swap(char[][] board, int i, int j, int nextX, int nextY) {
		char temp = board[i][j];
		board[i][j] = board[nextX][nextY];
		board[nextX][nextY] = temp;
	}
	
	public static int check(char[][] board, int n, int i, int j) {
		int cnt = 1;
		int maxCnt = 1;
		
		for (int k = 1; k < n; ++k) {
			if (board[i][k - 1] == board[i][k]) {
				++cnt;
			} else {
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		
		maxCnt = Math.max(maxCnt, cnt);
		
		cnt = 1;
		
		for (int k = 1; k < n; ++k) {
			if (board[k - 1][j] == board[k][j]) {
				++cnt;
			} else {
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		
		maxCnt = Math.max(maxCnt, cnt);
		
		return maxCnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		char[][] board = new char[n][n];
		
		for (int i = 0; i < n; ++i) {
			String input = sc.next();
			
			for (int j = 0; j < n; ++j) {
				board[i][j] = input.charAt(j);
			}
		}
		
		sc.close();
		
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < 4; ++k) {
					int nextX = i + directions[k][0];
					int nextY = j + directions[k][1];
					
					if ((nextX < 0) || (nextY < 0) || (nextX > n - 1) || (nextY > n - 1)) {
						continue;
					}
					
					swap(board, i, j, nextX, nextY);
					
					answer = Math.max(answer, check(board, n, i, j));
					
					swap(board, i, j, nextX, nextY);
				}
			}
		}
		
		System.out.print(answer);
	}

}
