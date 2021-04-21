import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		sc.close();
		
		long tempA = a;
		long tempB = b;
		
		while (tempB > 0) {
			long temp = tempA;
			tempA = tempB;
			tempB = temp % tempB;
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < tempA; ++i) {
			answer.append(1);
		}
		
		System.out.print(answer);
	}

}
