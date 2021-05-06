import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] sourceOfLadderAndSnake;
	public static int[] destinationOfLadderAndSnake;
	public static int[] diceCnt = new int[101];
	
	public static int bfs(int location) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(location);
		
		int[] dice = {1, 2, 3, 4, 5, 6};
		
		while (!queue.isEmpty()) {
			int currLocation = queue.poll();
			
			if (currLocation == 100) {
				return diceCnt[100];
			}
			
			for (int diceNum : dice) {
				int nextLocation = currLocation + diceNum;
				
				if (nextLocation > 100) {
					continue;
				}
				
				if (diceCnt[nextLocation] == 0) {	// 이동할 곳에 처음 방문하는 경우
					diceCnt[nextLocation] = diceCnt[currLocation] + 1;
					
					// 이동할 곳에 사다리나 뱀이 있는지 확인. 있을 경우 이동 경로 수정.
					for (int i = 0; i < sourceOfLadderAndSnake.length; ++i) {
						if (sourceOfLadderAndSnake[i] == nextLocation) {
							if (diceCnt[destinationOfLadderAndSnake[i]] == 0) {
								diceCnt[destinationOfLadderAndSnake[i]] = diceCnt[nextLocation];
							} else {
								diceCnt[destinationOfLadderAndSnake[i]] = Math.min(diceCnt[destinationOfLadderAndSnake[i]], diceCnt[nextLocation]);
							}
							
							nextLocation = destinationOfLadderAndSnake[i];
							
							break;
						}
					}
					
					queue.offer(nextLocation);
				} else {
					// 이미 이동한 적이 있지만 주사위를 더 적게 던져서 이동할 수 있는 경우
					if (diceCnt[nextLocation] > diceCnt[currLocation] + 1) {
						diceCnt[nextLocation] = diceCnt[currLocation] + 1;
						queue.offer(nextLocation);
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sourceOfLadderAndSnake = new int[n + m];
		destinationOfLadderAndSnake = new int[n + m];
		
		for (int i = 0; i < sourceOfLadderAndSnake.length; ++i) {
			sourceOfLadderAndSnake[i] = sc.nextInt();
			destinationOfLadderAndSnake[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.print(bfs(1));
	}

}
