import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int w = sc.nextInt();
		
		int[] treesNums = new int[t + 1];
		
		for (int i = 1; i <= t; ++i) {
			treesNums[i] = sc.nextInt();
		}
		
		sc.close();
		
		// dp[i][j][k]: i초까지 j번 만큼 이동해서 k번 나무에 있을 때 받을 수 있는 최대 자두의 수
		int[][][] dp = new int[1001][31][3];
		
		dp[1][0][1] = (treesNums[1] == 1) ? 1 : 0;	// 1초에 0번 움직여서 1번 트리에 있을 때 받을 수 있는 최대 자두의 수
		dp[1][1][2] = (treesNums[1] == 2) ? 1 : 0;	// 1초에 1번 움직여서 2번 트리에 있을 때 받을 수 있는 최대 자두의 수
		
		int answer = Math.max(dp[1][0][1], dp[1][1][2]);
		
		for (int i = 2; i <= t; ++i) {
			// i초에 0번 움직여서 1번 트리에 있을 경우
			dp[i][0][1] = (treesNums[i] == 1) ? dp[i - 1][0][1] + 1 : dp[i - 1][0][1];
			
			answer = Math.max(answer, dp[i][0][1]);
			
			for (int j = 1; j <= w; ++j) {
				// 움직이는 횟수에 맞춰서 트리 번호 계산. ex) 1번 움직이면 2번 트리, 2번 움직이면 1번 트리
				int treeNum = (j % 2 == 0) ? 1 : 2;
				
				// i초에 떨어지는 자두의 위치가 현재 트리 번호와 같을 경우 
				if (treesNums[i] == treeNum) {
					// 이전에 j번 만큼 움직여서 더 움직일 수 없어 treeNum 위치에 있는 경우 vs 이전에 j - 1번 만큼 움직여서 1번 움직일 수 있고 움직여서 treeNum 위치에 있는 경우
					dp[i][j][treeNum] = Math.max(dp[i - 1][j][treeNum] + 1, dp[i][j - 1][treeNum % 2 + 1] + 1);
				} else {
					dp[i][j][treeNum] = dp[i - 1][j][treeNum];
				}
				
				answer = Math.max(answer, dp[i][j][treeNum]);
			}
		}
		
		System.out.print(Math.max(answer, Math.max(dp[t][w][1], dp[t][w][2])));
	}

}
