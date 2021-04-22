import java.util.Scanner;

public class Main {
	public static int oCnt = 0;
	public static int vCnt = 0;
	public static boolean[][] visited;
	
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfs(char[][] yardArray, int row, int col) {
		visited[row][col] = true;
		
		if (yardArray[row][col] == 'o') {
			++oCnt;
		} else if (yardArray[row][col] == 'v') {
			++vCnt;
		}
		
		for (int[] direction : directionArray) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			
			if ((nextRow < 0) || (nextRow >= yardArray.length)
					|| (nextCol < 0) || (nextCol >= yardArray[0].length)) {
				continue;
			}
			
			if ((yardArray[nextRow][nextCol] != '#') && !visited[nextRow][nextCol]) {
				dfs(yardArray, nextRow, nextCol);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] yardArray = new char[r][c];
		
		for (int i = 0; i < r; ++i) {
			String temp = sc.next();
			
			for (int j = 0; j < c; ++j) {
				yardArray[i][j] = temp.charAt(j);
			}
		}
		
		sc.close();
		
		visited = new boolean[r][c];
		
		int answerOCnt = 0;
		int answerVCnt = 0;
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if ((yardArray[i][j] != '#') && (!visited[i][j])) {
					oCnt = 0;
					vCnt = 0;
					
					dfs(yardArray, i, j);
					
					if (oCnt > vCnt) {
						vCnt = 0;
					} else {
						oCnt = 0;
					}
					
					answerOCnt += oCnt;
					answerVCnt += vCnt;
				}
			}
		}
		
		System.out.print(answerOCnt + " " + answerVCnt);
	}

}
