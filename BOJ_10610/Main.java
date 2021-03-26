import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 30배수는 항상 맨 끝에 0이 있어야 하고, 각 자리수 합이 3의 배수여야 한다.
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		sc.close();
		
		int[] numCnt = new int[10];
		int sum = 0;
		
		for (int i = 0; i < n.length(); ++i) {
			int c = n.charAt(i) - '0';
			
			++numCnt[c];
			sum += c;
		}
		
		if ((numCnt[0] == 0) || (sum % 3 != 0)) {
			System.out.print(-1);
			System.exit(0);
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 9; i >= 0; --i) {
			for (int j = 0; j < numCnt[i]; ++j) {
				answer.append(i);
			}
		}
		
		System.out.print(answer);
	}
	
}
