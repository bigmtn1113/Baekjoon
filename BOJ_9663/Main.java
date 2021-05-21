import java.util.Scanner;

public class Main {
	public static int answer = 0;
	
	public static boolean checkBoard(int[] board, int row, int col) {
		// 여태까지 두었던 퀸의 위치를 보며 현재 둘 수 있는지 check 한다.
		// 해당 열이나 대각선에 퀸이 있으면 퀸을 둘 수 없다.
		
		for (int i = 0; i < row; ++i) {
			if ((board[i] == col) || (Math.abs(row - i) == Math.abs(col - board[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void nQueen(int[] board, int row) {
		// 퀸은 한 행에 최대 하나밖에 둘 수 없다.
		// 그래서 현재 행에 퀸을 둘 수 있는지 check하고 둘 수 있으면 두고 다음 행으로 넘어간다.
		// 행이 n과 같다는 건 n개의 퀸을 뒀단 소리이므로 answer 값을 증가시킨다.
		
		int n = board.length;
		
		if (row == n) {
			++answer;
			return;
		}
		
		for (int col = 0; col < n; ++col) {
			if ((row == 0) || checkBoard(board, row, col)) {
				board[row] = col;
				nQueen(board, row + 1);
				board[row] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] board = new int[n];
		
		nQueen(board, 0);
		
		sc.close();
		
		System.out.print(answer);
	}

}
