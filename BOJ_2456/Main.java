import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] scoreSum = new int[4];
		int[][] scoreCnt = new int[4][4];
		
		int maxSum = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 1; j < 4; ++j) {
				int score = sc.nextInt();
				
				scoreSum[j] += score;
				++scoreCnt[j][score];
				
				maxSum = Math.max(maxSum, scoreSum[j]);
			}
		}
		
		sc.close();
		
		int cnt = 0;
		int candidate = 0;
		
		int max3Cnt = 0;
		
		for (int i = 1; i < 4; ++i) {
			if (scoreSum[i] == maxSum) {
				++cnt;
				candidate = i;
				
				max3Cnt = Math.max(max3Cnt, scoreCnt[i][3]);
			}
		}
		
		if (cnt == 1) {
			System.out.format("%d %d", candidate, maxSum);
			System.exit(0);
		}
		
		cnt = 0;
		candidate = 0;
		
		int max2Cnt = 0;
		
		for (int i = 1; i < 4; ++i) {
			if ((scoreSum[i] == maxSum) && (scoreCnt[i][3] == max3Cnt)) {
				++cnt;
				candidate = i;
				
				max2Cnt = Math.max(max2Cnt, scoreCnt[i][2]);
			}
		}
		
		if (cnt == 1) {
			System.out.format("%d %d", candidate, maxSum);
			System.exit(0);
		}
		
		cnt = 0;
		candidate = 0;
		
		for (int i = 1; i < 4; ++i) {
			if ((scoreSum[i] == maxSum) && (scoreCnt[i][3] == max3Cnt) && (scoreCnt[i][2] == max2Cnt)) {
				++cnt;
				candidate = i;
			}
		}
		
		if (cnt == 1) {
			System.out.format("%d %d", candidate, maxSum);
			System.exit(0);
		}
		
		System.out.format("%d %d", 0, maxSum);
	}
	
}
