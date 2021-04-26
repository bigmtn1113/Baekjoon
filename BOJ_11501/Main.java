import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] sharePrice = new int[n];
			
			for (int j = 0; j < n; ++j) {
				sharePrice[j] = sc.nextInt();
			}
			
			long profit = 0;
			
			label: for (int j = n - 1; j > 0; --j) {
				for (int k = j - 1; k >= 0; --k) {
					if (sharePrice[j] <= sharePrice[k]) {
						j = k + 1;
						break;
					}
					
					profit += sharePrice[j] - sharePrice[k];
					
					if (k == 0) {
						break label;
					}
				}
			}
			
			answer.append(profit).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
