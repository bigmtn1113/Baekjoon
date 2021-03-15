import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] balls = new int[n + 1];
		
		for (int t = 1; t < n + 1; ++t) {
			balls[t] = t;
		}
		
		for (int t = 0; t < m; ++t) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int temp = balls[i];
			balls[i] = balls[j];
			balls[j] = temp;
		}
		
		sc.close();
		
		for (int t = 1; t < n + 1; ++t) {
			System.out.print(balls[t] + " ");
		}
	}
	
}
