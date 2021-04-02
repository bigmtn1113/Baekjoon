import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 1; ; ++i) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();
			
			if ((l == 0) && (p == 0) && (v == 0)) {
				break;
			}
			
			// ex) 5 8 20, 5 7 20
			answer.append("Case " + i + ": ");
			answer.append((v % p > l) ? l * (v / p + 1) : l * (v / p) + v % p).append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}
	
}
