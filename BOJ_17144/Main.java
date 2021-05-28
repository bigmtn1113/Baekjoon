import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ParticulateMatter {
	private int r;
	private int c;
	private int amount;
	
	public ParticulateMatter(int r, int c, int amount) {
		this.r = r;
		this.c = c;
		this.amount = amount;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public int getAmount() {
		return amount;
	}
}

public class Main {
	
	public static void circulatePM(int[][] room, int[] airCleaner) {
		int r = room.length;
		int c = room[0].length;
		
		// 공기청정기 윗 부분. 반시계 방향
		for (int i = airCleaner[0] - 1; i > 0; --i) {
			room[i][0] = room[i - 1][0];
		}
		
		for (int j = 0; j < c - 1; ++j) {
			room[0][j] = room[0][j + 1];
		}
		
		for (int i = 0; i < airCleaner[0]; ++i) {
			room[i][c - 1] = room[i + 1][c - 1];
		}
		
		for (int j = c - 1; j > 1; --j) {
			room[airCleaner[0]][j] = room[airCleaner[0]][j - 1];
		}
		
		room[airCleaner[0]][1] = 0;
		
		// 공기청정기 아랫 부분. 시계 방향
		for (int i = airCleaner[1] + 1; i < r - 1; ++i) {
			room[i][0] = room[i + 1][0];
		}
		
		for (int j = 0; j < c - 1; ++j) {
			room[r - 1][j] = room[r - 1][j + 1];
		}
		
		for (int i = r - 1; i > airCleaner[1]; --i) {
			room[i][c - 1] = room[i - 1][c - 1];
		}
		
		for (int j = c - 1; j > 1; --j) {
			room[airCleaner[1]][j] = room[airCleaner[1]][j - 1];
		}
		
		room[airCleaner[1]][1] = 0;
	}
	
	public static void bfs(int[][] room) {
		int r = room.length;
		int c = room[0].length;
		
		Queue<ParticulateMatter> queue = new LinkedList<>();
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (room[i][j] > 0) {
					queue.offer(new ParticulateMatter(i, j, room[i][j]));
				}
			}
		}
		
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		while (!queue.isEmpty()) {
			int currPMR = queue.peek().getR();
			int currPMC = queue.peek().getC();
			int currPMAmount = queue.poll().getAmount();
			
			int nextPMAmount = currPMAmount / 5;
			
			for (int[] direction : directions) {
				int nextPMR = currPMR + direction[0];
				int nextPMC = currPMC + direction[1];
				
				if ((nextPMR < 0) || (nextPMC < 0) || (nextPMR == r) || (nextPMC == c)) {
					continue;
				}
				
				if (room[nextPMR][nextPMC] != -1) {
					room[nextPMR][nextPMC] += nextPMAmount;
					room[currPMR][currPMC] -= nextPMAmount;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		
		int[][] room = new int[r][c];
		int[] airCleaner = new int[2];
		
		int airCleanerIdx = 0;
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				room[i][j] = sc.nextInt();
				
				if (room[i][j] == -1) {
					airCleaner[airCleanerIdx++] = i;
				}
			}
		}
		
		sc.close();
		
		for (int i = 0; i < t; ++i) {
			bfs(room);
			circulatePM(room, airCleaner);
		}
		
		int answer = 0;
		
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (room[i][j] > 0) {
					answer += room[i][j];
				}
			}
		}
		
		System.out.print(answer);
	}

}
