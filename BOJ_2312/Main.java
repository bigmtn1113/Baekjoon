import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			
			int[] cntArray = new int[n + 1];
			
			int dividend = 2;
			
			while (n > 1) {
				if (n % dividend == 0) {
					n /= dividend;
					++cntArray[dividend];
					
					dividend = 2;
				} else {
					++dividend;
				}
			}
			
			for (int j = 2; j < cntArray.length; ++j) {
				if (cntArray[j] > 0) {
					answer.append(j).append(" ").append(cntArray[j]).append("\n");
				}
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
