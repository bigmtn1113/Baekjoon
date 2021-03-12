import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min = 1000;
		int max = 0;
		
		for (int i = 0; i < n; ++i) {
			int score = sc.nextInt();
			
			min = Math.min(min, score);
			max = Math.max(max, score);
		}
		
		sc.close();
		
		System.out.print(max - min);
	}
	
}
