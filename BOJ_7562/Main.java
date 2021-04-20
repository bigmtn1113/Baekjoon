import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	private int row;
	private int col;
	
	public Pair(int row, int col) {
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
	public static int[][] directionArray = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	
	public static void bfs(int[][] board, int startRow, int startCol, int finishRow, int finishCol) {
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(startRow, startCol));
		
		while (!queue.isEmpty()) {
			int currRow = queue.peek().getRow();
			int currCol = queue.poll().getCol();
			
			if ((currRow == finishRow) && (currCol == finishCol)) {
				return;
			}
			
			for (int[] direction : directionArray) {
				int nextRow = currRow + direction[0];
				int nextCol = currCol + direction[1];
				
				if ((nextRow < 0) || (nextRow >= board.length)
						|| (nextCol < 0) || (nextCol >= board.length)) {
					continue;
				}
				
				if (board[nextRow][nextCol] == 0) {
					board[nextRow][nextCol] = board[currRow][currCol] + 1;
					queue.offer(new Pair(nextRow, nextCol));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int l = sc.nextInt();
			
			int[][] board = new int[l][l];
			
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			
			int finishRow = sc.nextInt();
			int finishCol = sc.nextInt();
			
			bfs(board, startRow, startCol, finishRow, finishCol);
			
			answer.append(board[finishRow][finishCol]).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
