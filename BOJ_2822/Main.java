import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[8];
		int[] sortedScores = new int[8];
		
		int sum = 0;
		
		for (int i = 0; i < 8; ++i) {
			sortedScores[i] = scores[i] = sc.nextInt();
			
			sum += scores[i];
		}
		
		sc.close();
		
		Arrays.sort(sortedScores);
		
		StringBuilder answer = new StringBuilder((sum - sortedScores[0] - sortedScores[1] - sortedScores[2]) + "\n");
		
		for (int i = 0; i < 8; ++i) {
			for (int j = 7; j > 2; --j) {
				if (scores[i] == sortedScores[j]) {
					answer.append((i + 1) + " ");
					break;
				}
			}
		}
		
		System.out.print(answer);
	}
	
}
