import java.util.Scanner;

public class Main {
	
	public static boolean check(boolean[][] bingoBoard) {
		int bingo = 0;
		
		for (int i = 0; i < 5; ++i) {
			int cnt = 0;
			
			for (int j = 0; j < 5; ++j) {
				if (bingoBoard[i][j]) {
					++cnt;
				}
			}
			
			if (cnt == 5) {
				++bingo;
			}
		}
		
		for (int i = 0; i < 5; ++i) {
			int cnt = 0;
			
			for (int j = 0; j < 5; ++j) {
				if (bingoBoard[j][i]) {
					++cnt;
				}
			}
			
			if (cnt == 5) {
				++bingo;
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 5; ++i) {
			if (bingoBoard[i][i]) {
				++cnt;
			}
		}
		
		if (cnt == 5) {
			++bingo;
		}
		
		cnt = 0;
		
		for (int i = 0; i < 5; ++i) {
			if (bingoBoard[i][4 - i]) {
				++cnt;
			}
		}
		
		if (cnt == 5) {
			++bingo;
		}
		
		return (bingo >= 3) ? true : false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[5][5];
		int[][] input = new int[5][5];
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				input[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		boolean[][] bingoBoard = new boolean[5][5];
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				label: for (int k = 0; k < 5; ++k) {
					for (int l = 0; l < 5; ++l) {
						if (board[k][l] == input[i][j]) {
							bingoBoard[k][l] = true;
							break label;
						}
					}
				}
				
				if (check(bingoBoard)) {
					System.out.print(i * 5 + j + 1);
					System.exit(0);
				}
			}
		}
	}
	
}
