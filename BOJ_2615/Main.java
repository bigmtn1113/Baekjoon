import java.util.Scanner;

public class Main {
	
	public static boolean check(int[][] boardArray, int i, int j) {
		int cnt = 0;
		
		for (int m = j; m < j + 6; ++m) {	// 오른쪽으로 검사
			if ((m >= 20) || (boardArray[i][m] != boardArray[i][j])) {
				break;
			}
			
			++cnt;
		}
		
		if (cnt == 5) {
			for (int m = j - 1; m > j - 5; --m) {	// 왼쪽으로 검사
				if ((m <= 0) || (boardArray[i][m] != boardArray[i][j])) {
					break;
				}
				
				++cnt;
			}
			
			if (cnt == 5) {
				return true;
			}
		}
		
		cnt = 0;
		
		for (int n = i; n < i + 6; ++n) {	// 아래로 검사
			if ((n >= 20) || (boardArray[n][j] != boardArray[i][j])) {
				break;
			}
			
			++cnt;
		}
		
		if (cnt == 5) {
			for (int n = i - 1; n > i - 5; --n) {	// 위로 검사
				if ((n <= 0) || (boardArray[n][j] != boardArray[i][j])) {
					break;
				}
				
				++cnt;
			}
			
			if (cnt == 5) {
				return true;
			}
		}
		
		cnt = 0;
		
		for (int n = i, m = j; m < j + 6; --n, ++m) {	// 오른쪽 대각선 위로 검사
			if ((n <= 0) || (m >= 20) || (boardArray[n][m] != boardArray[i][j])) {
				break;
			}
			
			++cnt;
		}
		
		if (cnt == 5) {
			for (int n = i + 1, m = j - 1; m > j - 5; ++n, --m) {	// 왼쪽 대각선 아래로 검사
				if ((n >= 20) || (m <= 0) || (boardArray[n][m] != boardArray[i][j])) {
					break;
				}
				
				++cnt;
			}
			
			if (cnt == 5) {
				return true;
			}
		}
		
		cnt = 0;
		
		for (int n = i, m = j; n < i + 6; ++n, ++m) {	// 오른쪽 대각선 아래로 검사
			if ((n >= 20) || (m >= 20) || (boardArray[n][m] != boardArray[i][j])) {
				break;
			}
			
			++cnt;
		}
		
		if (cnt == 5) {
			for (int n = i - 1, m = j - 1; n > i - 5; --n, --m) {	// 왼쪽 대각선 위로 검사
				if ((n <= 0) || (m <= 0) || (boardArray[n][m] != boardArray[i][j])) {
					break;
				}
				
				++cnt;
			}
			
			if (cnt == 5) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] boardArray = new int[20][20];
		
		for (int i = 1; i < 20; ++i) {
			for (int j = 1; j < 20; ++j) {
				boardArray[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for (int i = 1; i < 20; ++i) {
			for (int j = 1; j < 20; ++j) {
				if (boardArray[i][j] == 0) {
					continue;
				}
				
				if (check(boardArray, i, j)) {
					System.out.format("%d\n%d %d", boardArray[i][j], i, j);
					System.exit(0);
				}
			}
		}
		
		System.out.print(0);
	}

}
