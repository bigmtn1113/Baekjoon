import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int[][] area = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				area[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		boolean[][] visited = new boolean[n][m];
		
		visited[r][c] = true;
		
		// 북, 동, 남, 서
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		int answer = 1;
		
		while (true) {
			boolean canClean = false;
			
			for (int rotation = 0; rotation < 4; ++rotation) {
				// 왼쪽으로 회전
				d = (d > 0) ? d - 1 : 3;
				
				int nextR = r + directions[d][0];
				int nextC = c + directions[d][1];
				
				if ((nextR < 0) || (nextC < 0) || (nextR == n) || (nextC == m)) {
					continue;
				}
				
				// 왼쪽 방향에 아직 청소하지 않은 공간이 있을 경우 청소
				if ((area[nextR][nextC] == 0) && !visited[nextR][nextC]) {
					r = nextR;
					c = nextC;
					
					visited[nextR][nextC] = true;
					canClean = true;
					
					++answer;
					break;
				}
			}
			
			// 네 방향 모두 청소할 수 없을 경우
			if (!canClean) {
				int nextR = (d > 1) ? r + directions[d - 2][0] : r + directions[d + 2][0];
				int nextC = (d > 1) ? c + directions [d - 2][1] : c + directions [d + 2][1];
				
				// area 범위를 벗어나거나 벽 때문에 후진할 수 없으면 반복문 종료
				if ((nextR < 0) || (nextC < 0) || (nextR == n) || (nextC == m)
						|| (area[nextR][nextC] == 1)) {
					break;
				}
				
				// 후진 가능하면 방향 그대로 유지한 채로 후진
				r = nextR;
				c = nextC;
			}
		}
		
		System.out.print(answer);
	}

}
