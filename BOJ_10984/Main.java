import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int cSum = 0;
			double gSum = 0;
			
			for (int j = 0; j < n; ++j) {
				int c = sc.nextInt();
				double g = sc.nextDouble();
				
				cSum += c;
				gSum += c * g;
			}
			
			System.out.format("%d %.1f\n", cSum, gSum / cSum);
		}
		
		sc.close();
	}
	
}
