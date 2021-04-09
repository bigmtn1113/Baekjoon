import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		if (n == 0) {
			System.out.print(0);
			System.exit(0);
		}
		
		StringBuilder answer = new StringBuilder();
		
		while (n != 1) {
			int remainder = n % -2;
			
			if (remainder == -1) {
				n = n / -2 + 1;
				remainder = 1;
			} else {
				n /= -2;
			}
			
			answer = answer.insert(0, remainder);
		}
		
		System.out.print(answer = answer.insert(0, "1"));
	}

}
