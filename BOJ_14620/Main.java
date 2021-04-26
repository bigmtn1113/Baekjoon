import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static int answer = 3000;
	
	public static boolean canPlant(int i, int j) {
		if (visited[i][j]) {
			return false;
		}
		
		for (int[] direction : directionArray) {
			if (visited[i + direction[0]][j + direction[1]]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void recursionFunc(int[][] flowerBed, int costSum, int cnt) {
		if (cnt == 3) {
			answer = Math.min(answer, costSum);
			return;
		}
		
		for (int i = 1; i < flowerBed.length - 1; ++i) {
			for (int j = 1; j < flowerBed.length - 1; ++j) {
				if (!canPlant(i, j)) {
					continue;
				}
				
				int cost = flowerBed[i][j];
				visited[i][j] = true;
				
				for (int[] direction : directionArray) {
					cost += flowerBed[i + direction[0]][j + direction[1]];
					visited[i + direction[0]][j + direction[1]] = true;
				}
				
				recursionFunc(flowerBed, costSum + cost, cnt + 1);
				
				visited[i][j] = false;
				
				for (int[] direction : directionArray) {
					visited[i + direction[0]][j + direction[1]] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] flowerBed = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				flowerBed[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		visited = new boolean[n][n];
		
		recursionFunc(flowerBed, 0, 0);
		
		System.out.print(answer);
	}

}
