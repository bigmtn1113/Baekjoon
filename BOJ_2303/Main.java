import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] cards = new int[n][5];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 5; ++j) {
				cards[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int[] maxUnitSumOfN = new int[n];
		int maxUnitSum = 0;
		
		while (--n >= 0) {
			for (int i = 0; i < 3; ++i) {
				for (int j = i + 1; j < 5; ++j) {
					for (int k = j + 1; k < 5; ++k) {
						maxUnitSumOfN[n] = Math.max(maxUnitSumOfN[n], (cards[n][i] + cards[n][j] + cards[n][k]) % 10);
					}
				}
			}
			
			maxUnitSum = Math.max(maxUnitSum, maxUnitSumOfN[n]);
		}
		
		int answer = 0;
		
		for (int i = 0; i < maxUnitSumOfN.length; ++i) {
			if (maxUnitSumOfN[i] == maxUnitSum) {
				answer = i + 1;
			}
		}
		
		System.out.print(answer);
	}
	
}
