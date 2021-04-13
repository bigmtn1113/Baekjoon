import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] array = new int[n];
			
			for (int j = 0; j < n; ++j) {
				array[j] = sc.nextInt();
			}
			
			long sum = 0;
			
			for (int j = 0; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					int num1 = array[j];
					int num2 = array[k];
					
					if (num1 < num2) {
						int temp = num1;
						num1 = num2;
						num2 = temp;
					}
					
					while (num1 % num2 > 0) {
						int temp = num1;
						num1 = num2;
						num2 = temp % num2;
					}
					
					sum += num2;
				}
			}
			
			answer.append(sum).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
