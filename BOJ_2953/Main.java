import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int maxSum = 0;
		int maxSumIndex = 0;
		
		for (int i = 1; i <= 5; ++i) {
			int sum = 0;
			
			for (int j = 0; j < 4; ++j) {
				int input = sc.nextInt();
				
				sum += input;
			}
			
			if (sum > maxSum) {
				maxSum = sum;
				maxSumIndex = i;
			}
		}
		
		sc.close();
		
		System.out.print(maxSumIndex + " " + maxSum);
	}
	
}
