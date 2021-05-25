import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] paper = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int[][][] kindOfTetromino = {
				{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
				{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
				
				{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
				
				{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
				{{0, 0}, {0, 1}, {0, 2}, {1, 0}},
				{{0, 0}, {0, 1}, {1, 1}, {2, 1}},
				{{0, 2}, {1, 0}, {1, 1}, {1, 2}},
				{{0, 1}, {1, 1}, {2, 1}, {2, 0}},
				{{0, 0}, {1, 0}, {1, 1}, {1, 2}},
				{{0, 0}, {0, 1}, {1, 0}, {2, 0}},
				{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
				
				{{0, 0}, {1, 0}, {1, 1}, {2, 1}},
				{{0, 1}, {0, 2}, {1, 0}, {1, 1}},
				{{0, 1}, {1, 0}, {1, 1}, {2, 0}},
				{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
				
				{{0, 0}, {0, 1}, {0, 2}, {1, 1}},
				{{0, 1}, {1, 0}, {1, 1}, {2, 1}},
				{{0, 1}, {1, 0}, {1, 1}, {1, 2}},
				{{0, 0}, {1, 0}, {1, 1}, {2, 0}}};
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				for (int[][] tetromino : kindOfTetromino) {
					int sum = 0;
					boolean canSum = true;
					
					for (int[] location : tetromino) {
						int nextI = i + location[0];
						int nextJ = j + location[1];
						
						if ((nextI < 0) || (nextJ < 0) || (nextI >= n) || (nextJ >= m)) {
							canSum = false;
							break;
						}
						
						sum += paper[nextI][nextJ];
					}
					
					if (canSum) {
						answer = Math.max(answer, sum);
					}
				}
			}
		}
		
		System.out.print(answer);
	}

}
