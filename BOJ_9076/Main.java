import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			ArrayList<Integer> scores = new ArrayList<>();
			
			Integer maxScore = 0;
			Integer minScore = 10;
			
			for (int j = 0; j < 5; ++j) {
				Integer n = sc.nextInt();
				
				scores.add(n);
				maxScore = Math.max(maxScore, n);
				minScore = Math.min(minScore, n);
			}
			
			scores.remove(maxScore);
			scores.remove(minScore);
			
			maxScore = 0;
			minScore = 10;
			
			int scoreSum = 0;
			
			for (int score : scores) {
				scoreSum += score;
				
				maxScore = Math.max(maxScore, score);
				minScore = Math.min(minScore, score);
			}
			
			System.out.println((maxScore - minScore < 4) ? scoreSum : "KIN");
		}
		
		sc.close();
	}
	
}
