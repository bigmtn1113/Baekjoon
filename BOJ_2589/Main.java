import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	private int r;
	private int c;
	
	public Location(int r, int c) {
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
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int[][] distance;
	
	public static int bfs(char[][] map, int i, int j) {
		int height = map.length;
		int width = map[0].length;
		
		Queue<Location> queue = new LinkedList<>();
		queue.offer(new Location(i, j));
		
		int maxDistance = 0;
		
		while (!queue.isEmpty()) {
			int currI = queue.peek().getR();
			int currJ = queue.poll().getC();
			
			for (int[] direction : directions) {
				int nextI = currI + direction[0];
				int nextJ = currJ + direction[1];
				
				if ((nextI < 0) || (nextJ < 0) || (nextI == height) || (nextJ == width)) {
					continue;
				}
				
				if ((nextI == i) && (nextJ == j)) {
					continue;
				}
				
				if ((map[nextI][nextJ] == 'L') && (distance[nextI][nextJ] == 0)) {
					distance[nextI][nextJ] = distance[currI][currJ] + 1;
					maxDistance = Math.max(maxDistance, distance[nextI][nextJ]);
					
					queue.offer(new Location(nextI, nextJ));
				}
			}
		}
		
		return maxDistance;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int width = sc.nextInt();
		
		char[][] map = new char[height][width];
		
		for (int i = 0; i < height; ++i) {
			map[i] = sc.next().toCharArray();
		}
		
		sc.close();
		
		distance = new int[height][width];
		
		int answer = 0;
		
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if (map[i][j] == 'L') {
					for (int[] row : distance) {
						Arrays.fill(row, 0);
					}
					
					answer = Math.max(answer, bfs(map, i, j));
				}
			}
		}
		
		System.out.print(answer);
	}

}
