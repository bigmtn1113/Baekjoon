import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class DeathKnightLocation {
	private int r;
	private int c;
	
	public DeathKnightLocation(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
}

public class Main {
	public static int[][] distance;
	
	public static int bfs(int n, int r1, int c1, int r2, int c2) {
		Queue<DeathKnightLocation> queue = new LinkedList<>();
		queue.offer(new DeathKnightLocation(r1, c1));
		
		int[][] directionArray = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
		
		while (!queue.isEmpty()) {
			int currR = queue.peek().getR();
			int currC = queue.poll().getC();
			
			if ((currR == r2) && (currC == c2)) {
				return distance[r2][c2];
			}
			
			for (int[] direction : directionArray) {
				int nextR = currR + direction[0];
				int nextC = currC + direction[1];
				
				if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) {
					continue;
				}
				
				if ((nextR == r1) && (nextC == c1)) {
					continue;
				}
				
				if (distance[nextR][nextC] == 0) {
					distance[nextR][nextC] = distance[currR][currC] + 1;
					queue.offer(new DeathKnightLocation(nextR, nextC));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		sc.close();
		
		distance = new int[n][n];
		
		int answer = bfs(n, r1, c1, r2, c2);
		
		System.out.print((answer != -1) ? answer : -1);
	}

}
