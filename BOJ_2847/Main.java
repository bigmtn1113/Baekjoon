import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] scoreArray = new int[n];
		
		for (int i = 0; i < n; ++i) {
			scoreArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		int answer = 0;
		
		for (int i = n - 1; i > 0; --i) {
			if (scoreArray[i - 1] >= scoreArray[i]) {
				answer += scoreArray[i - 1] - (scoreArray[i] - 1);
				scoreArray[i - 1] = scoreArray[i] - 1;
			}
		}
		
		System.out.print(answer);
	}

}
