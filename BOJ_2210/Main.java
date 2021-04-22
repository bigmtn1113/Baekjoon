import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static HashSet<String> set = new HashSet<>();
	
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(int[][] boardArray, String s, int row, int col) {
		if (s.length() == 6) {
			set.add(s);
			return;
		}
		
		for (int[] direction : directionArray) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			
			if ((nextRow < 0) || (nextRow >= 5) || (nextCol < 0) || (nextCol >= 5)) {
				continue;
			}
			
			dfs(boardArray, s + boardArray[nextRow][nextCol], nextRow, nextCol);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] boardArray = new int[5][5];
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				boardArray[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				dfs(boardArray, boardArray[i][j] + "", i, j);
			}
		}
		
		System.out.print(set.size());
	}

}
