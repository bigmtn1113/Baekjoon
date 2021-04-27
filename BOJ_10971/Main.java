import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static int[] resultArray;			// 방문 도시 저장 배열
	public static int resultArrayIndex = 0;		// 현재까지 방문한 도시의 수
	
	public static int answer = 10000000;
	
	public static void recursionFunc(int[][] cost) {
		if (resultArrayIndex == cost.length) {
			if (cost[resultArray[cost.length - 1]][resultArray[0]] == 0) {		// 마지막 도시에서 출발 도시로 돌아올 수 없을 경우
				return;
			}
			
			int costSum = 0;
			
			for (int i = 0; i < cost.length - 1; ++i) {
				int from = resultArray[i];
				int to = resultArray[i + 1];
				
				if (cost[from][to] == 0) {		// 도시를 방문할 수 없는 경우
					return;
				}
				
				costSum += cost[from][to];
			}
			
			answer = Math.min(answer, costSum + cost[resultArray[cost.length - 1]][resultArray[0]]);
			return;
		}
		
		for (int i = 0; i < cost.length; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				resultArray[resultArrayIndex++] = i;
				
				recursionFunc(cost);
				
				visited[i] = false;
				--resultArrayIndex;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] cost = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		visited = new boolean[n];
		resultArray = new int[n];
		
		recursionFunc(cost);
		
		System.out.print(answer);
	}

}
