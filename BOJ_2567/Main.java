import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[][] paper = new boolean[101][101];
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			
			for (int j = bottom; j < bottom + 10; ++j) {
				for (int k = left; k < left + 10; ++k) {
					paper[j][k] = true;
				}
			}
		}
		
		sc.close();
		
		int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		
		int cnt = 0;
		
		// 색종이 주변(상, 하, 좌, 우) = 색종이 둘레 
		for (int i = 1; i < 100; ++i) {
			for (int j = 1; j < 100; ++j) {
				if (paper[i][j]) {
					for (int k = 0; k < 4; ++k) {
						if (!paper[i + dx[k]][j + dy[k]]) {
							++cnt;
						}
					}
				}
			}
		}
		
		System.out.print(cnt);
	}
	
}
