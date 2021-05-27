import java.util.ArrayList;
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
	public static boolean[][] isFlood;
	public static int[][] distance;
	
	public static int bfs(char[][] map, ArrayList<Location> water, Location hedgehog) {
		Queue<Location> queue = new LinkedList<>();
		
		for (Location currWaterLocation : water) {
			isFlood[currWaterLocation.getR()][currWaterLocation.getC()] = true;
			queue.offer(currWaterLocation);
		}
		
		queue.offer(hedgehog);
		
		int waterStep = water.size();
		int hedgehogStep = 1;
		
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		// 매 분마다 고슴도치가 이동할 수 있지만 물도 확장된다. 즉 동시에 두 개가 실행되어야 한다.
		while (!queue.isEmpty()) {
			while (waterStep-- > 0) {
				int currWaterR = queue.peek().getR();
				int currWaterC = queue.poll().getC();
				
				for (int[] direction : directions) {
					int nextWaterR = currWaterR + direction[0];
					int nextWaterC = currWaterC + direction[1];
					
					if ((nextWaterR < 0) || (nextWaterC < 0)
							|| (nextWaterR == map.length) || (nextWaterC == map[0].length)) {
						continue;
					}
					
					if (isFlood[nextWaterR][nextWaterC]
							|| (map[nextWaterR][nextWaterC] == 'X')
							|| (map[nextWaterR][nextWaterC] == 'D')) {
						continue;
					}
					
					isFlood[nextWaterR][nextWaterC] = true;
					queue.offer(new Location(nextWaterR, nextWaterC));
				}
			}
			
			waterStep = queue.size() - hedgehogStep;
			
			while (hedgehogStep-- > 0) {
				int currHedgehogR = queue.peek().getR();
				int currHedgehogC = queue.poll().getC();
				
				for (int[] direction : directions) {
					int nextHedgehogR = currHedgehogR + direction[0];
					int nextHedgehogC = currHedgehogC + direction[1];
					
					if ((nextHedgehogR < 0) || (nextHedgehogC < 0)
							|| (nextHedgehogR == map.length) || (nextHedgehogC == map[0].length)) {
						continue;
					}
					
					if (map[nextHedgehogR][nextHedgehogC] == 'D') {
						return distance[currHedgehogR][currHedgehogC] + 1;
					}
					
					if (isFlood[nextHedgehogR][nextHedgehogC] || (distance[nextHedgehogR][nextHedgehogC] > 0)) {
						continue;
					}
					
					if (map[nextHedgehogR][nextHedgehogC] == '.') {
						distance[nextHedgehogR][nextHedgehogC] = distance[currHedgehogR][currHedgehogC] + 1;
						queue.offer(new Location(nextHedgehogR, nextHedgehogC));
					}
				}
			}
			
			hedgehogStep = queue.size() - waterStep;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] map = new char[r][c];
		
		ArrayList<Location> water = new ArrayList<>();
		Location hedgehog = null;
		
		for (int i = 0; i < r; ++i) {
			map[i] = sc.next().toCharArray();
			
			for (int j = 0; j < c; ++j) {
				if (map[i][j] == '*') {
					water.add(new Location(i, j));
				} else if (map[i][j] == 'S') {
					hedgehog = new Location(i, j);
				}
			}
		}
		
		sc.close();
		
		isFlood = new boolean[r][c];
		distance = new int[r][c];
		
		int answer = bfs(map, water, hedgehog);
		
		System.out.print((answer != -1) ? answer : "KAKTUS");
	}

}
