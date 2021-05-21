import java.util.Scanner;

public class Main {
	public static int[][] matches = {
			{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
			{1, 2}, {1, 3}, {1, 4}, {1, 5},
			{2, 3}, {2, 4}, {2, 5},
			{3, 4}, {3, 5},
			{4, 5}};
	public static int[] win = new int[6];
	public static int[] draw = new int[6];
	public static int[] lose = new int[6];
	public static boolean isPossible;
	
	public static void dfs(int gameCnt) {
		if (gameCnt == 15) {
			isPossible = true;
			return;
		}
		
		int team1 = matches[gameCnt][0];
		int team2 = matches[gameCnt][1];
		
		if ((win[team1] > 0) && (lose[team2] > 0)) {
			--win[team1];
			--lose[team2];
			
			dfs(gameCnt + 1);
			
			++win[team1];
			++lose[team2];
		}
		
		if ((draw[team1] > 0) && (draw[team2] > 0)) {
			--draw[team1];
			--draw[team2];
			
			dfs(gameCnt + 1);
			
			++draw[team1];
			++draw[team2];
		}
		
		if ((lose[team1] > 0) && (win[team2] > 0)) {
			--lose[team1];
			--win[team2];
			
			dfs(gameCnt + 1);
			
			++lose[team1];
			++win[team2];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		
		for (int t = 0; t < 4; ++t) {
			int gameResultSum = 0;
			
			for (int i = 0; i < 6; ++i) {
				win[i] = sc.nextInt();
				draw[i] = sc.nextInt();
				lose[i] = sc.nextInt();
				
				gameResultSum += win[i] + draw[i] + lose[i];
			}
			
			if (gameResultSum == 30) {
				isPossible = false;
				dfs(0);
			}
			
			answer.append((isPossible) ? "1 " : "0 ");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
