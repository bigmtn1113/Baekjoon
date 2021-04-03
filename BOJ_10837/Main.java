import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		for (int i = 0; i < c; ++i) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int scoreDifference = Math.abs(m - n);
			int remainRound = k - Math.max(m, n);
			
			if (m == n) {
				answer.append(1 + "\n");
			} else if (m < n) {
				if (scoreDifference - remainRound <= 1) {
					answer.append(1 + "\n");
				} else {
					answer.append(0 + "\n");
				}
			} else {
				if (scoreDifference - remainRound <= 2) {
					answer.append(1 + "\n");
				} else {
					answer.append(0 + "\n");
				}
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
