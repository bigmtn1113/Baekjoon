import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static StringBuilder answer = new StringBuilder();
	
	public static void hanoi(int n, int from, int by, int to) {
		if (n == 1) {
			answer.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		hanoi(n - 1, from, to, by);
		answer.append(from).append(" ").append(to).append("\n");
		hanoi(n - 1, by, from, to);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		System.out.println(new BigInteger("2").pow(n).subtract(BigInteger.ONE));
		
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
			System.out.print(answer);
		}
	}

}
