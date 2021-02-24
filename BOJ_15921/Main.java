import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] record = new int[n];
		int sum = 0;
		
		for (int i = 0; i < n; ++i) {
			record[i] = sc.nextInt();
			
			sum += record[i];
		}
		
		sc.close();
		
		if (n == 0) {
			System.out.print("divide by zero");
		} else {
			float recordAvg = sum / (float) n;
			float expectdValue = 0;
			
			for (int i = 0; i < n; ++i) {
				expectdValue += record[i] / (float) n;
			}
			
			System.out.format("%.2f", recordAvg / expectdValue);
		}
	}
	
}
