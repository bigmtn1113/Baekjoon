import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[][] rect = new int[101][101];
		
		int cnt = 0;
		
		for (int input = 0; input < 4; ++input) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int i = x1; i < x2; ++i) {
				for (int j = y1; j < y2; ++j) {
					if (rect[i][j] == 0) {
						rect[i][j] = 1;
						++cnt;
					}
				}
			}
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
