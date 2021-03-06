import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] chessBoard = new String[8];
		
		for (int i = 0; i < 8; ++i) {
			chessBoard[i] = sc.next();
		}
		
		sc.close();
		
		int cnt = 0;
		
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (((i % 2 == 0) && (j % 2 == 0))
						|| ((i % 2 == 1) && (j % 2 == 1))) {
					if (chessBoard[i].charAt(j) == 'F') {
						++cnt;
					}
				}
			}
		}
		
		System.out.print(cnt);
	}
	
}
