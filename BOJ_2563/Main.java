import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] drawingPaper = new int[101][101];

		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = y; j < y + 10; ++j) {
				for (int k = x; k < x + 10; ++k) {
					++drawingPaper[j][k];
					
					if (drawingPaper[j][k] == 1) {
						++cnt;
					}
				}
			}
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
