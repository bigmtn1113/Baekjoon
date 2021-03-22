import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] coloredPapers = new int[101][101];
		int maxX2 = 0;
		int maxY2 = 0;
		
		for (int i = 1; i <= n; ++i) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = x1 + sc.nextInt();
			int y2 = y1 + sc.nextInt();
			
			for (int j = x1; j < x2; ++j) {
				for (int k = y1; k < y2; ++k) {
					coloredPapers[j][k] = i;
				}
			}
			
			maxX2 = Math.max(maxX2, x2);
			maxY2 = Math.max(maxY2, y2);
		}
		
		sc.close();
		
		int[] answer = new int[n + 1];
		
		for (int i = 0; i < maxX2; ++i) {
			for (int j = 0; j < maxY2; ++j) {
				++answer[coloredPapers[i][j]];
			}
		}
		
		for (int i = 1; i <= n; ++i) {
			System.out.println(answer[i]);
		}
	}
	
}
