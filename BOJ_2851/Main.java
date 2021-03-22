import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[10];
		
		for (int i = 0; i < 10; ++i) {
			scores[i] = sc.nextInt();
		}
		
		sc.close();
		
		int sum = 0;
		int minDifference = 100;
		int answer = 0;
		
		for (int i = 0; i < 10; ++i) {
			sum += scores[i];
			
			if (Math.abs(sum - 100) <= minDifference) {
				minDifference = Math.abs(sum - 100);
				answer = sum;
			}
		}
		
		System.out.print(answer);
	}
	
}
