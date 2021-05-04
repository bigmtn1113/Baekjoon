import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BombLocation {
	private int row;
	private int col;
	
	public BombLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}

public class Main {
	
	// 폭탄 위치 기억하기
	public static void offerBombLocationToQueue(Queue<BombLocation> queue, char[][] array, int r, int c) {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (array[i][j] == '.') {
					continue;
				}
				
				queue.offer(new BombLocation(i, j));
			}
		}
	}
	
	// 격자판 전체에 폭탄 설치하기
	public static void fillBoardWithO(char[][] array) {
		for (char[] row : array) {
			Arrays.fill(row, 'O');
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		char[][] board = new char[r][c];
		
		for (int i = 0; i < r; ++i) {
			board[i] = sc.next().toCharArray();
		}
		
		sc.close();
		
		char[][] bombBoard = new char[r][c];
		fillBoardWithO(bombBoard);
		
		Queue<BombLocation> queue = new LinkedList<>();
		offerBombLocationToQueue(queue, board, r, c);
		
		int[][] directionArray = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
		
		for (int i = 2; i <= n; ++i) {
			if (i % 2 == 0) {
				fillBoardWithO(board);
				continue;
			}
			
			while (!queue.isEmpty()) {
				int currRow = queue.peek().getRow();
				int currCol = queue.poll().getCol();
				
				board[currRow][currCol] = '.';
				
				for (int[] direction : directionArray) {
					int nextRow = currRow + direction[0];
					int nextCol = currCol + direction[1];
					
					if (nextRow < 0 || nextCol < 0 || nextRow == r || nextCol == c) {
						continue;
					}
					
					board[nextRow][nextCol] = '.';
				}
			}
			
			offerBombLocationToQueue(queue, board, r, c);
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				answer.append(board[i][j]);
			}
			
			answer.append("\n");
		}
		
		System.out.print(answer);
	}

}
