import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			if ((n == 0) && (k == 0)) {
				break;
			}
			
			if (k > n - k) {
				k = n - k;
			}
			
			long nCk = 1;
			int dividend = 1;
			
			while (k-- > 0) {
				nCk *= n--;
				nCk /= dividend++;
			}
			
			answer.append(nCk).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
