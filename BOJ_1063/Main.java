import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String king = sc.next();
		String stone = sc.next();
		int n = sc.nextInt();
		
		int[] kingLocation = {king.charAt(1) - '0', king.charAt(0) - 'A' + 1};
		int[] stoneLocation = {stone.charAt(1) - '0', stone.charAt(0) - 'A' + 1};
		
		int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},
				{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
		
		for (int i = 0; i < n; ++i) {
			int[] nextKingLocation = {0, 0};
			int[] nextStoneLocation = {0, 0};
			
			int directionIndex = 0;
			
			switch (sc.next()) {
			case "R":
				directionIndex = 0;
				break;
				
			case "L":
				directionIndex = 1;
				break;
				
			case "B":
				directionIndex = 2;
				break;

			case "T":
				directionIndex = 3;
				break;
			
			case "RT":
				directionIndex = 4;
				break;
				
			case "LT":
				directionIndex = 5;
				break;
				
			case "RB":
				directionIndex = 6;
				break;
				
			default:
				directionIndex = 7;
				break;
			}
			
			nextKingLocation[0] = kingLocation[0] + direction[directionIndex][0];
			nextKingLocation[1] = kingLocation[1] + direction[directionIndex][1];
			
			if ((nextKingLocation[0] < 1) || (nextKingLocation[1] < 1)
					|| (nextKingLocation[0] > 8) || (nextKingLocation[1] > 8)) {
				continue;
			}
			
			if ((nextKingLocation[0] == stoneLocation[0]) && (nextKingLocation[1] == stoneLocation[1])) {
				nextStoneLocation[0] = nextKingLocation[0] + direction[directionIndex][0];
				nextStoneLocation[1] = nextKingLocation[1] + direction[directionIndex][1];
				
				if ((nextStoneLocation[0] < 1) || (nextStoneLocation[1] < 1)
						|| (nextStoneLocation[0] > 8) || (nextStoneLocation[1] > 8)) {
					continue;
				}
				
				stoneLocation[0] = nextStoneLocation[0];
				stoneLocation[1] = nextStoneLocation[1];
			}
			
			kingLocation[0] = nextKingLocation[0];
			kingLocation[1] = nextKingLocation[1];
		}
		
		sc.close();
		
		System.out.println((char) (kingLocation[1] + 'A' - 1) + "" + kingLocation[0]);
		System.out.print((char) (stoneLocation[1] + 'A' - 1) + "" + stoneLocation[0]);
	}
	
}
