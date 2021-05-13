import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int tempM = m;
			int tempN = n;
			
			while (tempN > 0) {
				int temp = tempM;
				tempM = tempN;
				tempN = temp % tempN;
			}
			
			int endYear = m * n / tempM;
			
			while ((x <= endYear) && ((x - 1) % n + 1 != y)) {
				x += m;
			}
			
			answer.append((x <= endYear) ? x : "-1").append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
